package com.example.crossingtoads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class GameCustomization extends AppCompatActivity {
    private TextView textView;
    private EditText inputText;
    private ImageButton b1;
    private ImageButton b2;
    private ImageButton b3;
    private ImageButton b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_customization);
        textView = (TextView) findViewById(R.id.textName);
        inputText = (EditText) findViewById(R.id.editTextNameInput);
        b1 = (ImageButton) findViewById(R.id.imageButtonToad1);
        b2 = (ImageButton) findViewById(R.id.imageButtonToad2);
        b3 = (ImageButton) findViewById(R.id.imageButtonToad3);
        b4 = (ImageButton) findViewById(R.id.imageButtonToad4);
    }

    public void moveStartScreen(View view) {
        Intent startScreen = new Intent(this, WelcomeScreen.class);
        startActivity(startScreen);
    }

    public void moveGameScreen(View view) {
        if (Game.getDifficulty() != 0) {
            Intent gameScreen = new Intent(this, GameScreen.class);
            startActivity(gameScreen);
        }
    }

    public void setDifficultyEasy(View view) {
        Game.setDifficulty(1);
        Game.setLives(5);
    }

    public void setDifficultyNormal(View view) {
        Game.setDifficulty(2);
        Game.setLives(4);
    }

    public void setDifficultyHard(View view) {
        Game.setDifficulty(3);
        Game.setLives(3);
    }

    public void setSpriteToad1(View view) {
        Drawable d = b1.getBackground();
        System.out.println("Sprite 1");
        Game.getPlayer().setSprite(1);
    }

    public void setSpriteToad2(View view) {
        Drawable d = b2.getBackground();
        System.out.println("Sprite 2");
        Game.getPlayer().setSprite(2);
    }

    public void setSpriteToad3(View view) {
        Drawable d = b3.getBackground();
        System.out.println("Sprite 3");
        Game.getPlayer().setSprite(3);
    }

    public void setSpriteToad4(View view) {
        Drawable d = b4.getBackground();
        System.out.println("Sprite 4");
        Game.getPlayer().setSprite(4);
    }

    public void updateText(View view) {
        textView.setText("Welcome" + inputText.getText() + "!");
    }

    public void setName(View view) {
        Game.getPlayer().setName(String.valueOf(inputText.getText()));
        updateText(view);
    }
}