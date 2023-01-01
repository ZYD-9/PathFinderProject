package com.example.pathfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignIn extends AppCompatActivity {
    EditText email_field;
    EditText password_field;
    Button signIn;
    ProgressBar progressBar;
    FirebaseAuth payoAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        email_field = findViewById(R.id.useremail_in);
        password_field = findViewById(R.id.password_in);
        signIn = findViewById(R.id.signedin_btn);
        progressBar = findViewById(R.id.signin_progress);
        payoAuth = FirebaseAuth.getInstance();

        signIn.setOnClickListener(view ->{
            signinUser();
        });


    }

    private void signinUser() {
        String email = email_field.getText().toString();
        String password = password_field.getText().toString();


        if (TextUtils.isEmpty(email)) {
            email_field.setError("Email cannot be empty");
            password_field.requestFocus();

        } else{
            payoAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(SignIn.this,"Signed In Successfully ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignIn.this,Assessment.class));
                    }

                    else {
                        Toast.makeText(SignIn.this,"Signign In Error: " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }



}