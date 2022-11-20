package com.example.pathfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppStart extends AppCompatActivity {

    Button gotoRegister;
    Button gotoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start);

        gotoRegister = findViewById(R.id.registerbtn_start);
        gotoLogin = findViewById(R.id.loginbtn_start);
        toregister();
        toLogin();


    }

    private void toLogin() {
        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

    }

    private void toregister() {
        gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });
    }
}