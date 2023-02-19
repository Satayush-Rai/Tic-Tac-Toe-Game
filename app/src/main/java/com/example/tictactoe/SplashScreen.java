package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        try
        {
            Intent Control = new Intent(SplashScreen.this,AddPlayers.class);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(Control);
                }
            },3000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}