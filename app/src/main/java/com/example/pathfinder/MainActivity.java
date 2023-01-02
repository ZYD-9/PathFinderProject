package com.example.pathfinder;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class MainActivity extends AppCompatActivity {

    TextView r1, r2, r3;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = findViewById(R.id.result1);
        r2 = findViewById(R.id.result2);
        r3 = findViewById(R.id.result3);
        pieChart = findViewById(R.id.piechart);

        setData();
    }

    private void setData() {
        r1.setText(Integer.toString(30));
        r2.setText(Integer.toString(5));
        r3.setText(Integer.toString(15));

        pieChart.addPieSlice(
                new PieModel(
                        "Result1",
                        Integer.parseInt(r1.getText().toString()),
                        Color.parseColor("@color/payo_results1")));
        pieChart.addPieSlice(
                new PieModel(
                        "Result2",
                        Integer.parseInt(r2.getText().toString()),
                        Color.parseColor("@color/payo_results2")));
        pieChart.addPieSlice(
                new PieModel(
                        "Result3",
                        Integer.parseInt(r3.getText().toString()),
                        Color.parseColor("@color/payo_results3")));

        pieChart.startAnimation();
    }
}