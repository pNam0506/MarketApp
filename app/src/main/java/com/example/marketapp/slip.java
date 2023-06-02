package com.example.marketapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class slip extends AppCompatActivity {

    ImageView uploadImageSlip;
    String imageURL;
    Uri uri;
    Button booking;

    private TextView log_selected,price_Log,time_Booking;

    public static final String LOG = "LOG";
    public static final String PRICE = "PRICE";
    private int log_int;

    private String log_s,price,price_set;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slip);

        log_selected = findViewById(R.id.log_B);
        price_Log = findViewById((int)R.id.price_log);
        time_Booking = findViewById((int)R.id.time_booking);

        slipClass slipClass_s = new slipClass();

        Intent intent = getIntent();
        log_int = intent.getIntExtra(LOG,0);
        price_set = intent.getStringExtra(PRICE);

        log_selected.setText("จองล็อคที่ "+log_int);
        price_Log.setText(price_set);

        log_s = log_selected.getText().toString();
             price = price_Log.getText().toString();
            slipClass_s.setDatalog(log_s);
            slipClass_s.setDataprice(price);

            long duration = TimeUnit.MINUTES.toMillis(1);

            new CountDownTimer(duration, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    String sDuration = String.format(Locale.ENGLISH,"%02d : %02d"
                    ,TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                            ,TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)-
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

                    time_Booking.setText(sDuration);

                }

                @Override
                public void onFinish() {

                    time_Booking.setVisibility(View.GONE);

                    Toast.makeText(getApplicationContext(),"ทำการจองใหม่อีกครั้ง",Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(slip.this,night_fairs.class);
                    startActivity(intent);

                }
            }.start();


        uploadImageSlip = findViewById((int)R.id.UploadSlip);
        booking = findViewById((int)R.id.booking);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK){

                            Intent data = result.getData();
                            uri = data.getData();
                            uploadImageSlip.setImageURI(uri);

                        }else{

                            Toast.makeText(slip.this,"กรุณาเเนบสลิป",Toast.LENGTH_SHORT).show();


                        }
                    }
                }
        );

        uploadImageSlip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPicker = new Intent(Intent.ACTION_PICK);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });



    }
    public void saveData(){

        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Android Image")
                .child(uri.getLastPathSegment());

        AlertDialog.Builder builder = new AlertDialog.Builder(slip.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri uriImage = uriTask.getResult();
                imageURL = uriImage.toString();
                uploadData();
                dialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();
            }
        });

    }
    public void uploadData(){


        slipClass slipClass;

        slipClass = new slipClass(log_s,price,imageURL);


        FirebaseDatabase.getInstance().getReference("slip").child(log_s)
                .setValue(slipClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(slip.this,"ได้ทำการจองเเล้ว",Toast.LENGTH_SHORT)
                                    .show();
                            Intent intent = new Intent(slip.this,offerMarketFragment.class);

                            startActivity(intent);



                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(slip.this,e.getMessage().toString(), Toast.LENGTH_SHORT)
                                .show();
                    }
                });









    }




}