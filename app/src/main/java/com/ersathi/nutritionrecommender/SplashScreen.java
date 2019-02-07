package com.ersathi.nutritionrecommender;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        };

        handler.postDelayed(runnable, 0200);
    }
}
