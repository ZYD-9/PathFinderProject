package com.example.pathfinder;

import android.widget.SeekBar;

public class Item {


    private String assessment;
    private SeekBar seekbar;

    Item(String assessment){
        this.assessment=assessment;
        this.seekbar=seekbar;
    }

    public String getAssessment() {

        return assessment;
    }

    public SeekBar getSeekbar() {

        return seekbar;
    }
}

