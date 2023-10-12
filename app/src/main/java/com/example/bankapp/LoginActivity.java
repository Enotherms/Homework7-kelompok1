package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    TextView SignUp;
    EditText Username;
    EditText Password;
    Button LoginButton;
    String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String usernameV = sharedPreferences.getString("name", "");

        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        LoginButton = findViewById(R.id.loginButton);
        SignUp = findViewById(R.id.SignUp);

        email = getIntent().getStringExtra("Email_Extra");

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Username.getText().toString().equals(usernameV) && Password.getText().toString().equals("1234")) {
                    String username = Username.getText().toString();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}