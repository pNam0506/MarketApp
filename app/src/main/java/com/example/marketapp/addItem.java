package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addItem extends AppCompatActivity {

    EditText uploadRules;
    Button saveButton;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        uploadRules = findViewById(R.id.UploadRule);
        saveButton = findViewById((int)R.id.saveRulesButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase = FirebaseDatabase.getInstance();
                reference = firebaseDatabase.getReference("rules");

                String rules = uploadRules.getText().toString();

                RuleClass ruleClass = new RuleClass(rules);
                reference.child(rules).setValue(ruleClass);

                Toast.makeText(addItem.this,"เพิ่มเรียบร้อย",Toast.LENGTH_SHORT).show();

            }
        });


    }
}