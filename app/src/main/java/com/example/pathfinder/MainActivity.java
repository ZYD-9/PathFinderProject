package com.example.pathfinder;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class MainActivity extends AppCompatActivity {

    TextView r1, r2, r3, r4, r5, r6;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = findViewById(R.id.result1);
        r2 = findViewById(R.id.result2);
        r3 = findViewById(R.id.result3);
        r4 = findViewById(R.id.result4);
        r5 = findViewById(R.id.result5);
        r6 = findViewById(R.id.result6);
        pieChart = findViewById(R.id.piechart);

        setData();
    }

    private void setData() {
        r1.setText(Integer.toString(30));
        r2.setText(Integer.toString(5));
        r3.setText(Integer.toString(15));
        r4.setText(Integer.toString(10));
        r5.setText(Integer.toString(25));
        r6.setText(Integer.toString(15));

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
        pieChart.addPieSlice(
                new PieModel(
                        "Result4",
                        Integer.parseInt(r4.getText().toString()),
                        Color.parseColor("@color/payo_results4")));

        pieChart.addPieSlice(
                new PieModel(
                        "Result5",
                        Integer.parseInt(r5.getText().toString()),
                        Color.parseColor("@color/payo_results5")));

        pieChart.addPieSlice(
                new PieModel(
                        "Result6",
                        Integer.parseInt(r6.getText().toString()),
                        Color.parseColor("@color/payo_results6")));

        pieChart.startAnimation();
    }
}