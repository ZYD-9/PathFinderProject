package com.example.pathfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignIn extends AppCompatActivity {

    EditText username_field;
    EditText password_field;
    Button signIn;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        username_field = findViewById(R.id.username_in);
        password_field = findViewById(R.id.password_in);
        signIn = findViewById(R.id.signin_btn);
        progressBar = findViewById(R.id.signin_progress);
        signedIn();


    }

    private void signedIn() {
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username, password;

                username = username_field.getText().toString();
                password = password_field.getText().toString();
                if (!username.equals("") && !password.equals("")) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            String[] fields = new String[2];
                            fields[0] = "username";
                            fields[1] = "password";

                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;

                            PutData putData = new PutData("http://192.168.254.124/LoginModule/login.php", "POST", fields, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equalsIgnoreCase("SignIn Success")) {
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