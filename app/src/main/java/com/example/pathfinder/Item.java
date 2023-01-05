package com.example.pathfinder;

import android.widget.SeekBar;

public class Item {


    private String assessment;
    private SeekBar seekbar;
    private int value;

    Item(String assessment, int value){
        this.assessment=assessment;
        this.value=value;
        this.seekbar= seekbar;
    }

    public String getAssessment() {
        return assessment;
    }

    public SeekBar getSeekbar() {
        return seekbar;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

