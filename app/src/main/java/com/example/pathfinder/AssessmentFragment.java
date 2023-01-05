package com.example.pathfinder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AssessmentFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<Item>itemList;
    RecyclerAdapter adapter;
    Button submitbtn;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private void initData() {
        itemList=new ArrayList<>();
        itemList.add(new Item("1. WRITTEN COMMUNICATION: The ability to write clearly and concisely and convey information to different readers.", 0));
        itemList.add(new Item("2. VERBAL COMMUNICATION: The ability to use spoken words to convey message clearly in a conversation or to a larger audience.", 0));
        itemList.add(new Item("3. PROBLEM SOLVING: Devising and then using an appropriate method/rule/ technique or logic to solve a problem.", 0));
        itemList.add(new Item("4. TEAM WORK: Cooperating with and supporting others in order to achieve a common goal.", 0));
        itemList.add(new Item("5. ANALYTICAL ABILITY: Being able to pick out the key issues from a large amount of complex information.",0));
        itemList.add(new Item("6. CREATIVE THINKING: Being original and innovative in order to solve problems, generate ideas, or produce novel designs.", 0));
        itemList.add(new Item("7. NUMERACY: The ability to understand and interpret facts and ideas expressed in figures and non-verbal data.", 0));
        itemList.add(new Item("8. LEADERSHIP: The ability to guide, direct, motivate, and take responsibility for others.", 0));
        itemList.add(new Item("9. COMMERCIAL AWARENESS: Having an understanding and appreciation of the organization and how it makes a profit or acquires funding.", 0));
        itemList.add(new Item("10. DECISION-MAKING: The ability to select a logical choice by considering outcomes of each option and determining the best for the situation.", 0));
        itemList.add(new Item("11. NEGOTIATING: The ability to deliberate with others in order to come to an agreement that is appropriate and beneficial to all.", 0));
        itemList.add(new Item("12. PERSUADING: Being able to influence the attitudes and perspectives of others.", 0));
        itemList.add(new Item("13. SELF-MOTIVATION: Being proactive and willing to take the initiative. Setting and achieving goals.", 0));
        itemList.add(new Item("14. TIME MANAGEMENT: The ability to organize your work, priorities, and what needs to be done to meet deadlines.", 0));
        itemList.add(new Item("15. FLEXIBILITY: The ability to carry out a variety of tasks, work in different situations, and manage change in your life and work.", 0));
    }
    private void initRecyclerView(View v) {

        recyclerView = v.findViewById(R.id.assessment_questionnaire);
        submitbtn = v.findViewById(R.id.submitbtn);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(itemList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_assessment, container, false);
        initData();
        initRecyclerView(v);
        submitbtnMethod();
        getData();
        return v;
    }
    // RETRIVE DATA
    private void getData() {
        firestore.collection("SKILL_ASSESSMENT_TEST").document(firebaseAuth.getUid()).get().addOnCompleteListener(
                new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){
                            DocumentSnapshot documentSnapshot = task.getResult();
                            if(documentSnapshot.exists()){
                                Log.d("TAG", documentSnapshot.get("WRITTEN_COMMUNICATION").toString());
                                Log.d("TAG",documentSnapshot.get("VERBAL_COMMUNICATION").toString());

                            }
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }
   // POST DATA
    private void submitbtnMethod() {
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, Object> senddate = new HashMap<>();
                senddate.put("WRITTEN_COMMUNICATION",itemList.get(0).getValue());
                senddate.put("VERBAL_COMMUNICATION",itemList.get(1).getValue());
                senddate.put("PROBLEM_COMMUNICATION",itemList.get(2).getValue());
                senddate.put("TEAMWORK",  itemList.get(3).getValue());
                senddate.put("ANALYTICAL_ABILITY",itemList.get(4).getValue());
                senddate.put("CREATIVE_THINKING",itemList.get(5).getValue());
                senddate.put("NUMERCY",itemList.get(6).getValue());
                senddate.put("LEADERSHIP",itemList.get(7).getValue());
                senddate.put("COMMERCIAL_AWARENESS", itemList.get(8).getValue());
                senddate.put("DECISION_MAKING",itemList.get(9).getValue());
                senddate.put("NEGOTIATING",itemList.get(10).getValue());
                senddate.put("PERSUADING",itemList.get(11).getValue());
                senddate.put("SELF_MOTIVATION",itemList.get(12).getValue());
                senddate.put("TIME_MANAGEMENT",itemList.get(13).getValue());
                senddate.put("FLEXIBILITY", itemList.get(14).getValue());

                firestore.collection("SKILL_ASSESMENT_TEST").document(firebaseAuth.getUid())
                        .set(senddate).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}