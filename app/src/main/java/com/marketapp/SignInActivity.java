package com.marketapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.marketapp.databinding.ActivitySignInBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.utilities.Constants;
import com.utilities.PreferenceManager;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceManager = new PreferenceManager(getApplicationContext());
        if(preferenceManager.getBoolean(Constants.KEY_IS_SIGNED_IN)){

            String name = preferenceManager.getString(Constants.KEY_NAME);

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");
            Query checkData = reference.orderByChild("dataNameUser").equalTo(name);

            checkData.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        String nameOfUser = snapshot.child(name).child("dataNameUser").getValue(String.class);
                        String nameOfBoot = snapshot.child(name).child("dataNameBoot").getValue(String.class);
                        Intent intent = new Intent(SignInActivity.this,offerMarketFragment.class);
                        intent.putExtra("name_user",nameOfUser);
                        intent.putExtra("name_boot",nameOfBoot);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        String name = preferenceManager.getString(Constants.KEY_NAME);


                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Manager");
                        Query checkData = reference.orderByChild("dataEmail").equalTo(name);

                        checkData.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    Intent intent = new Intent(getApplicationContext(), mainMarketFragment.class);
                                    startActivity(intent);
                                    finish();
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });


                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


            Intent intent = new Intent(getApplicationContext(), offerMarketFragment.class);
            startActivity(intent);
            finish();
        }
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
    }

    private void setListeners(){
        binding.textCreateNewAccount.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class)));
        binding.buttonSignIn.setOnClickListener(v->{
            if(isValidSignInDetails()){
                signIn();
            }
        });
    }

    private void signIn(){
        loading(true);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection(Constants.KEY_COLLECTION_USERS)
                .whereEqualTo(Constants.KEY_NAME,binding.inputName.getText().toString())
                .whereEqualTo(Constants.KEY_PASSWORD,binding.inputPassword.getText().toString())
                .get()
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful() && task.getResult() != null
                    && task.getResult().getDocuments().size() >0){
                        DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
                        preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN,true);
                        preferenceManager.putString(Constants.KEY_USER_ID, documentSnapshot.getId());
                        preferenceManager.putString(Constants.KEY_NAME, documentSnapshot.getString(Constants.KEY_NAME));
                        preferenceManager.putString(Constants.KEY_IMAGE, documentSnapshot.getString(Constants.KEY_IMAGE));

                    }else{
                        loading(false);
                        showToast("Unable to sign in");
                    }
                });

        String name_user = binding.inputName.getText().toString();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");
        Query checkData = reference.orderByChild("dataNameUser").equalTo(name_user);

        checkData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    String nameOfUser = snapshot.child(name_user).child("dataNameUser").getValue(String.class);
                    String nameOfBoot = snapshot.child(name_user).child("dataNameBoot").getValue(String.class);

                    Intent intent = new Intent(getApplicationContext(),offerMarketFragment.class);
                    intent.putExtra("name_user",nameOfUser);
                    intent.putExtra("name_boot",nameOfBoot);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                else{
                    String name_m = binding.inputName.getText().toString();


                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Manager");
                    Query checkData = reference.orderByChild("dataNameManager").equalTo(name_m);

                    checkData.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                Intent intent = new Intent(getApplicationContext(), mainMarketFragment.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(SignInActivity.this,"ไม่พบข้อมูล",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void loading(Boolean isLoading){
        if(isLoading){
            binding.buttonSignIn.setVisibility(View.INVISIBLE);
            binding.proguressBar.setVisibility((View.INVISIBLE));
        }else {
            binding.proguressBar.setVisibility(View.INVISIBLE);
            binding.buttonSignIn.setVisibility(View.VISIBLE);
        }
    }

    private void showToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private Boolean isValidSignInDetails(){
        if(binding.inputName.getText().toString().trim().isEmpty()){
            showToast("Enter email.com");
            return false;
        }else if(binding.inputPassword.getText().toString().trim().isEmpty()){
            showToast("Enter password");
            return false;
        }else{
            return true;
        }
    }
}