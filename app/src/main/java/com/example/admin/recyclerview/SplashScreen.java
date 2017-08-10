package com.example.admin.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    long delay = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Timer Runsplash = new Timer();
        TimerTask showSplash = new TimerTask() {
            @Override
            public void run() {
                finish();

                Intent intent= new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
            }
        };

        Runsplash.schedule(showSplash, delay);
    }
}
