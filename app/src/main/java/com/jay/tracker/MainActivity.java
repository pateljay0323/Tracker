package com.jay.tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jay.tracker.BackgroundService.LocationService;
import com.jay.tracker.BackgroundService.TelephonyService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, TelephonyService.class);
        startService(intent);
    }
}
