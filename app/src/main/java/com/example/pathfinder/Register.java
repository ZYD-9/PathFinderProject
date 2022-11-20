package com.example.pathfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Register extends AppCompatActivity {

EditText username;
EditText email_new;
EditText password_new;
Button register;
ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username_field);
        email_new = findViewById(R.id.new_email_field);
        password_new = findViewById(R.id.new_password_field);
        register = findViewById(R.id.registerbtn);
        progressBar = findViewById(R.id.registration_progress);
        registerIn();


    }

    private void registerIn() {

        Toast.makeText(Register.this,"register method",Toast.LENGTH_LONG).show();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Register.this,"register clicked",Toast.LENGTH_LONG).show();

           String email,password;
           email = email_new.getText().toString();
           password = password_new.getText().toString();

        if(!email.equals("") && !password.equals("")) {
            progressBar.setVisibility(View.VISIBLE);
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {

                    String[]fields = new String[2];
                    fields[0] = "password";
                    fields[1] = "email";

                    String[]data = new String[2];
                    data[0] = password;
                    data[1] = email;

                    PutData putData = new PutData("http://192.168.254.124/LoginModule/signup.php", "POST", fields,data);
                      if (putData.startPut()){
                          if(putData.onComplete()){
                              progressBar.setVisibility(View.GONE);
                              String result = putData.getResult();
                              if(result.equalsIgnoreCase("Sign Up Success")){
                                  Intent intent = new Intent(getApplicationContext(),Login.class);
                                  startActivity(intent);
                              }
                              else {
                                  Toast.makeText(getApplicationContext(),"The result is " + result,Toast.LENGTH_SHORT).show();
                              }

                          }
                      }
                }
            });
        }
        else {
            Toast.makeText(getApplicationContext(),"All fields are required", Toast.LENGTH_SHORT).show();
        }

            }
        });
    }



}