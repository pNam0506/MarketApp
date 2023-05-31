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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class informationMarketFragment extends AppCompatActivity {

    ImageView uploadImage;
    Button saveButton;
    EditText uploadsir,uploadNameM,uploadNameMk,locationMk,uploadRules,uploadTimeM,uploadTimeB,uploadphoneNumber,uploadEmail,uploadOrder;
    String imageURL;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_information_market);

        uploadImage = findViewById((int)R.id.marketImage);
        uploadsir = findViewById(R.id.UploadSir);
        uploadNameM = findViewById(R.id.UploadNameOfManager);
        uploadNameMk = findViewById(R.id.UploadNameOfMarket);
        locationMk = findViewById(R.id.UploadLocationOfMarket);
        saveButton = findViewById(R.id.saveButton);
        uploadRules = findViewById(R.id.UploadRule);
        uploadTimeM = findViewById(R.id.UploadTimeOfMarket);
        uploadTimeB = findViewById(R.id.UploadTimeToBooking);
        uploadEmail = findViewById((int)R.id.UploadEmail);
        uploadphoneNumber = findViewById((int)R.id.UploadPhoneNumber);
        uploadOrder = findViewById((int)R.id.UploadOrder);


        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK){

                            Intent data = result.getData();
                            uri = data.getData();
                            uploadImage.setImageURI(uri);

                        }else{

                            Toast.makeText(informationMarketFragment.this,"กรุณาเลือกรูปโปรไฟล์ตลาด",Toast.LENGTH_SHORT).show();


                        }
                    }
                }
        );

        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPicker = new Intent(Intent.ACTION_PICK);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

       /* nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(informationMarketFragment.this,addItem.class);
                startActivity(intent);
            }
        });*/

    }

    public void saveData(){

        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Android Image")
                .child(uri.getLastPathSegment());

        AlertDialog.Builder builder = new AlertDialog.Builder(informationMarketFragment.this);
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

        String sir = uploadsir.getText().toString();
        String nameM = uploadNameM.getText().toString();
        String nameMk = uploadNameMk.getText().toString();
        String LMK = locationMk.getText().toString();
        String rules = uploadRules.getText().toString();
        String tm = uploadTimeM.getText().toString();
        String tb = uploadTimeB.getText().toString();
        String ph = uploadphoneNumber.getText().toString();
        String Em = uploadEmail.getText().toString();
        String Or = uploadOrder.getText().toString();

        DataClass dataClass;

        dataClass = new DataClass(sir,nameM,nameMk,LMK,rules,tb,tm,ph,Em,Or,imageURL);


        FirebaseDatabase.getInstance().getReference("Manager").child(nameMk)
                .setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(informationMarketFragment.this,"Saved",Toast.LENGTH_SHORT)
                                    .show();
                            Intent intent = new Intent(informationMarketFragment.this,mainMarketFragment.class);
                            startActivity(intent);



                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(informationMarketFragment.this,e.getMessage().toString(), Toast.LENGTH_SHORT)
                                .show();
                    }
                });


    }
}

