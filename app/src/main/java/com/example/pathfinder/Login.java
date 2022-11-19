package com.example.pathfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {


    EditText gmailfield;
    EditText passwordfield;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

      gmailfield = findViewById(R.id.gmail_in);
      passwordfield = findViewById(R.id.password_in);
      loginbtn = findViewById(R.id.login_btn);

    }
}