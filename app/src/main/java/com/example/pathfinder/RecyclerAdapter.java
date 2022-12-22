package com.example.pathfinder;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Item> itemList;
    public RecyclerAdapter (List<Item>itemList){
        this.itemList=itemList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_questionnaire, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        String questions= itemList.get(position).getAssessment();
        SeekBar seekbar=itemList.get(position).getSeekbar();

        holder.setData(questions,seekbar);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        private SeekBar seekBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView= itemView.findViewById(R.id.questionnaire);
            seekBar= itemView.findViewById(R.id.seekbarId);
        }

        public void setData(String questions, SeekBar seekbar){
            textView.setText(questions);
            seekBar.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) seekbar);
        }


    }
}
