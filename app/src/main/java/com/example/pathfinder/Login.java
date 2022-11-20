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

public class Login extends AppCompatActivity {


    EditText gmailfield;
    EditText passwordfield;
    Button login;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        gmailfield = findViewById(R.id.gmail_in);
        passwordfield = findViewById(R.id.password_in);
        login = findViewById(R.id.login_btn);
        progressBar = findViewById(R.id.login_progress);
        login();


    }

    private void login() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email, password;

                email = gmailfield.getText().toString();
                password = passwordfield.getText().toString();
                if (!email.equals("") && !password.equals("")) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            String[] fields = new String[2];
                            fields[0] = "email";
                            fields[1] = "password";

                            String[] data = new String[2];
                            data[0] = email;
                            data[1] = password;

                            PutData putData = new PutData("http://192.168.254.124/LoginModule/login.php", "POST", fields, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equalsIgnoreCase("Login Success")) {
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Result is" + result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                        }
                    });

                }
                else {
                    Toast.makeText(getApplicationContext(), "Fields must be filled", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}