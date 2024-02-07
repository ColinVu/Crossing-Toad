package com.example.crossingtoads;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {
    private TextView pText;
    private TextView dText;
    private TextView lText;
    private TextView nText;
    private ImageView spriteIm;
    private ImageView mapIm;
    private Handler handler;
    private Button rButton;
    private Button qButton;
    private TextView gText;

    private TextView wText;

    private ImageView[] vehicleIms;
    private ImageView[] logIms;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game_screen);
        pText = (TextView) findViewById(R.id.pointText);
        pText.setText("Points: " + Game.getScore());
        dText = (TextView) findViewById(R.id.difficultyText);
        dText.setText("Difficulty: " + Game.getDifficulty());
        lText = (TextView) findViewById(R.id.livesText);
        lText.setText("Lives: " + Game.getLives());
        nText = (TextView) findViewById(R.id.nameText);
        nText.setText(Game.getPlayer().getName());
        spriteIm = (ImageView) findViewById(R.id.spriteDisplay);
        mapIm = (ImageView) findViewById(R.id.mapDisplay);
        rButton = (Button) findViewById(R.id.restartButton);
        rButton.setVisibility(View.INVISIBLE);
        qButton = (Button) findViewById(R.id.quitButton);
        qButton.setVisibility(View.INVISIBLE);
        gText = (TextView) findViewById(R.id.gameOverText);
        gText.setVisibility(View.INVISIBLE);
        wText = (TextView) findViewById(R.id.gameWinText);
        wText.setVisibility(View.INVISIBLE);
        vehicleIms = new ImageView[10];
        vehicleIms[0] = (ImageView) findViewById(R.id.sedan1);
        vehicleIms[1] = (ImageView) findViewById(R.id.sedan2);
        vehicleIms[2] = (ImageView) findViewById(R.id.sedan3);
        vehicleIms[3] = (ImageView) findViewById(R.id.sedan4);
        vehicleIms[4] = (ImageView) findViewById(R.id.sedan5);
        vehicleIms[5] = (ImageView) findViewById(R.id.sedan6);
        vehicleIms[6] = (ImageView) findViewById(R.id.sedan7);
        vehicleIms[7] = (ImageView) findViewById(R.id.sedan8);
        vehicleIms[8] = (ImageView) findViewById(R.id.truck);
        vehicleIms[9] = (ImageView) findViewById(R.id.train);
        logIms = new ImageView[14];
        logIms[0] = (ImageView) findViewById(R.id.log1);
        logIms[1] = (ImageView) findViewById(R.id.log2);
        logIms[2] = (ImageView) findViewById(R.id.log3);
        logIms[3] = (ImageView) findViewById(R.id.log4);
        logIms[4] = (ImageView) findViewById(R.id.log5);
        logIms[5] = (ImageView) findViewById(R.id.log6);
        logIms[6] = (ImageView) findViewById(R.id.log7);
        logIms[7] = (ImageView) findViewById(R.id.log8);
        logIms[8] = (ImageView) findViewById(R.id.log9);
        logIms[9] = (ImageView) findViewById(R.id.log10);
        logIms[10] = (ImageView) findViewById(R.id.log11);
        logIms[11] = (ImageView) findViewById(R.id.log12);
        logIms[12] = (ImageView) findViewById(R.id.log13);
        logIms[13] = (ImageView) findViewById(R.id.log14);

        if (Game.getPlayer().getSprite() == 1) {
            spriteIm.setImageResource(getResources().getIdentifier("toad1", "drawable",
                    getPackageName()));
        } else if (Game.getPlayer().getSprite() == 2) {
            spriteIm.setImageResource(getResources().getIdentifier("toad2", "drawable",
                    getPackageName()));
        } else if (Game.getPlayer().getSprite() == 3) {
            spriteIm.setImageResource(getResources().getIdentifier("toad3", "drawable",
                    getPackageName()));
        } else {
            spriteIm.setImageResource(getResources().getIdentifier("toad4", "drawable",
                    getPackageName()));
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        mapIm.setX(0);
        mapIm.setY(-15);
        spriteIm.setX(Game.getPlayer().getX());
        spriteIm.setY(Game.getPlayer().getY());
        nText.setX(Game.getPlayer().getX());
        nText.setY(Game.getPlayer().getY() - 30);
        System.out.println(Game.getPlayer().getX());
        System.out.println(Game.getPlayer().getY());
        Vehicle[] gameVehicles = Game.getVehicles();
        Log[] gameLogs = Game.getLogs();
        for (int i = 0; i < vehicleIms.length; i++) {
            vehicleIms[i].setX(gameVehicles[i].getX());
            if (i == 8) {
                vehicleIms[i].setY(gameVehicles[i].getY() - 40);
            } else if (i == 9) {
                vehicleIms[i].setY(gameVehicles[i].getY() - 90);
            } else {
                vehicleIms[i].setY(gameVehicles[i].getY());
            }
        }
        for (int  i = 0; i < logIms.length; i++) {
            logIms[i].setX(gameLogs[i].getX());
            logIms[i].setY(gameLogs[i].getY());
        }
    }
    @Override
    protected void onResume() {
        super.onResume();

        handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                spriteIm.setFocusable(true);
                spriteIm.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if (event.getAction() == KeyEvent.ACTION_DOWN && Game.getPlayer().getY() >= 180) {
                            System.out.println("Name: " + nText.getX() + " " + nText.getY());
                            System.out.println("Frog: " + spriteIm.getX() + " " + spriteIm.getY());
                            System.out.println("Diff: " + dText.getX() + " " + dText.getY());
                            if (keyCode == KeyEvent.KEYCODE_A) {
                                Game.moveX(Game.getPlayer().getX() - 90);
                                System.out.println(Game.getPlayer().getX());
                                System.out.println(Game.getCurrTile());
                                return true;
                            } else if (keyCode == KeyEvent.KEYCODE_W) {
                                Game.moveY(Game.getPlayer().getY() - 90);
                                System.out.println(Game.getPlayer().getY());
                                System.out.println(Game.getCurrTile());
                                return true;
                            } else if (keyCode == KeyEvent.KEYCODE_D) {
                                Game.moveX(Game.getPlayer().getX() + 90);
                                System.out.println(Game.getPlayer().getX());
                                System.out.println(Game.getCurrTile());
                                return true;
                            } else if (keyCode == KeyEvent.KEYCODE_S) {
                                Game.moveY(Game.getPlayer().getY() + 90);
                                System.out.println(Game.getPlayer().getY());
                                System.out.println(Game.getCurrTile());
                                return true;
                            }
                        }
                        return false;
                    }
                });
                spriteIm.setX(Game.getPlayer().getX());
                spriteIm.setY(Game.getPlayer().getY());
                nText.setX(Game.getPlayer().getX());
                nText.setY(Game.getPlayer().getY() - 30);
                nText.setVisibility(View.VISIBLE);
                Vehicle[] gameVehicles = Game.getVehicles();
                Log[] gameLogs = Game.getLogs();
                for (int i = 0; i < vehicleIms.length; i++) {
                    vehicleIms[i].setX(gameVehicles[i].getX());
                }
                for (int i = 0; i < logIms.length; i++) {
                    logIms[i].setX(gameLogs[i].getX());
                }
                pText.setText("Points: " + Game.getScore());
                if (Game.getLives() >= 0) {
                    lText.setText("Lives: " + Game.getLives());
                }
                if (Game.getLives() <= 0) {
                    qButton.setVisibility(View.VISIBLE);
                    rButton.setVisibility(View.VISIBLE);
                    gText.setText("GAME OVER, Score: " + Game.getScore());
                    gText.setVisibility(View.VISIBLE);
                    Game.getPlayer().resetY(Constants.startingY);
                } else if (Game.getPlayer().getY() < 180) {
                    qButton.setVisibility(View.VISIBLE);
                    rButton.setVisibility(View.VISIBLE);
                    gText.setText("YOU WIN! Score: " + Game.getScore());
                    gText.setVisibility(View.VISIBLE);
                    Game.setWin(true);
                }
                Game.moveVehicles();
                Game.moveLogs();
                System.out.println(Game.getIteration());

                handler.postDelayed(this, 33);
            }
        };
        handler.postDelayed(r, 10);
    }
    public void quitGame(View view) {
        finish();
        System.exit(0);
    }
    public void restartGame(View view) {
        Game.setDifficulty(0);
        Game.setWin(false);
        Intent GameCustomization = new Intent(this, GameCustomization.class);
        Game.setIteration();
        Game.death();
        finish();
        startActivity(GameCustomization);
    }
}