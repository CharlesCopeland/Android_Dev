package com.example.androiddevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    public void generateTimesTable(int timesTableNumber) {

        Log.i("SeekBar Value: ", Integer.toString(timesTableNumber));
        ArrayList<String> contentArray = new ArrayList<String>();
        for (int j = 1; j <= 100; j++) {
            contentArray.add(Integer.toString(j * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contentArray);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekBar = findViewById(R.id.seekBar);
        listView = findViewById(R.id.listView);

         int max = 20;
         int startingPosition = 10;

        seekBar.setMax(20);
        seekBar.setProgress(10);

        generateTimesTable(startingPosition);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNumber;
                if(i < min) {
                    timesTableNumber = min;
                    seekBar.setProgress(min);
                } else {
                    timesTableNumber = i;
                }
                generateTimesTable(timesTableNumber);
            }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
        });

    }
}
