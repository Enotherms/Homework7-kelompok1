package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText Username;
    EditText Password;
    EditText Email;
    Button RegisterButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

        Username = findViewById(R.id.username);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        RegisterButton = findViewById(R.id.registerButton);

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Password.getText().toString().equals("1234")) {
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                    myEdit.putString("name", Username.getText().toString());
                    myEdit.putString("email", Email.getText().toString());
                    myEdit.commit();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    Toast.makeText(RegisterActivity.this, "Register Successful!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(RegisterActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}