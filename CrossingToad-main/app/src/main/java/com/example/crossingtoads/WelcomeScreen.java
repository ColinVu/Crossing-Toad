package com.example.crossingtoads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        Game game = new Game(null, null);
    }
    public void goGameCustomization(View view) {
        Intent gameCustom = new Intent(this, GameCustomization.class);
        startActivity(gameCustom);
    }
    public void quitGame(View view) {
        finish();
        System.exit(0);
    }
}