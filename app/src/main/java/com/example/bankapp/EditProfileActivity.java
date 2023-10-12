package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditProfileActivity extends AppCompatActivity {

    TextView Username;
    TextView Email;
    Button SaveButton;
    Button CancelButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String email = sharedPreferences.getString("email", "");

        Username = findViewById(R.id.username);
        Email = findViewById(R.id.email);
        SaveButton = findViewById(R.id.saveButton);
        CancelButton = findViewById(R.id.cancelButton);

        Username.setText(name);
        Email.setText(email);

        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updateUsername = Username.getText().toString();
                String updateEmail = Email.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", updateUsername);
                editor.putString("email", updateEmail);
                editor.commit();
                Toast.makeText(EditProfileActivity.this, "Profile updated!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        CancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}