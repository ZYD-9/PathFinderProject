package com.example.pathfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class Assessment extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<Item>itemList;
    RecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);
        getSupportActionBar().hide();

        initData();
        initRecyclerView();
    }

    private void initData() {
        itemList=new ArrayList<>();
        itemList.add(new Item("1. WRITTEN COMMUNICATION: The ability to write clearly and concisely and convey information to different readers."));
        itemList.add(new Item("2. VERBAL COMMUNICATION: The ability to use spoken words to convey message clearly in a conversation or to a larger audience."));
        itemList.add(new Item("3. PROBLEM SOLVING: Devising and then using an appropriate method/rule/ technique or logic to solve a problem."));
        itemList.add(new Item("4. TEAM WORK: Cooperating with and supporting others in order to achieve a common goal."));
        itemList.add(new Item("5. ANALYTICAL ABILITY: Being able to pick out the key issues from a large amount of complex information."));
        itemList.add(new Item("6. CREATIVE THINKING: Being original and innovative in order to solve problems, generate ideas, or produce novel designs."));
        itemList.add(new Item("7. NUMERACY: The ability to understand and interpret facts and ideas expressed in figures and non-verbal data."));
        itemList.add(new Item("8. LEADERSHIP: The ability to guide, direct, motivate, and take responsibility for others."));
        itemList.add(new Item("9. COMMERCIAL AWARENESS: Having an understanding and appreciation of the organization and how it makes a profit or acquires funding."));
        itemList.add(new Item("10. DECISION-MAKING: The ability to select a logical choice by considering outcomes of each option and determining the best for the situation."));
        itemList.add(new Item("11. NEGOTIATING: The ability to deliberate with others in order to come to an agreement that is appropriate and beneficial to all."));
        itemList.add(new Item("12. PERSUADING: Being able to influence the attitudes and perspectives of others."));
        itemList.add(new Item("13. SELF-MOTIVATION: Being proactive and willing to take the initiative. Setting and achieving goals."));
        itemList.add(new Item("14. TIME MANAGEMENT: The ability to organize your work, priorities, and what needs to be done to meet deadlines."));
        itemList.add(new Item("15. FLEXIBILITY: The ability to carry out a variety of tasks, work in different situations, and manage change in your life and work."));
    }
    private void initRecyclerView() {
        recyclerView=findViewById(R.id.assessment_questionnaire);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(itemList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
