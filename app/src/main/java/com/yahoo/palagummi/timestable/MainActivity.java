package com.yahoo.palagummi.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    ListView tableListView = null;
    SeekBar tableSeekBar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the seekBar and listView
        tableSeekBar = (SeekBar) findViewById(R.id.tableSeekBar);
        tableListView = (ListView)findViewById(R.id.tableListView);

        // set the maximum for seekBar
        tableSeekBar.setMax(20);
        tableSeekBar.setProgress(10); // initial value of the seekBar

        // initial array for the listView
        final ArrayList<String> arrayList = new ArrayList<String>(asList("1","2","3","4","5","6","7","8","9","10"));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        tableListView.setAdapter(arrayAdapter);

        // onSeekBarChangeListener
        tableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                if (b) {
                    if(progress < 1) {
                        tableSeekBar.setProgress(1); // set the minimum for the seekBar to 1
                        generateTimesTable(1);
                    }
                    else {
                        generateTimesTable(progress);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        // initial value of the list
        generateTimesTable(10);
    }

    public void generateTimesTable(int timesTable) {
        // initial array for the listView
        final ArrayList<String> arrayList = new ArrayList<String>();
        for (int i=1; i<=10; i++) {
            arrayList.add(Integer.toString(i * timesTable));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        tableListView = (ListView) findViewById(R.id.tableListView);
        tableListView.setAdapter(arrayAdapter);
    }
}
