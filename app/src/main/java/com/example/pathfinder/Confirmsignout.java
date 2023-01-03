package com.example.pathfinder;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class Confirmsignout extends Fragment {

    Button confirm;
    FirebaseAuth payoAuth;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v =  inflater.inflate(R.layout.fragment_confirmsignout, container, false);

        confirm = v.findViewById(R.id.confirm_signout);
        payoAuth = FirebaseAuth.getInstance();

        confirm.setOnClickListener(view ->{
            payoAuth.signOut();
            Intent intent = new Intent(getActivity(),SignIn.class);
            startActivity(intent);
        });

        return v;
    }
}