package com.example.crossingtoads;

import android.content.Context;

public class Player {
    public static final int SPEED = 3;
    private String name;
    private int mUnmodifiedX = 0;
    private int mUnmodifiedY = 0;
    private int sprite;

    private int maxDistance;
    private int logShift;

    public Player(int x, int y) {
        mUnmodifiedX = x;
        mUnmodifiedY = y;
        maxDistance = y;
        sprite = 0;
    }

    public void setX(int unmodifiedX) {
        if (Game.getLives() <= 0) {
            return;
        }
        this.mUnmodifiedX = unmodifiedX;
        if (mUnmodifiedX > 990) {
            mUnmodifiedX = 990;
        } else if (mUnmodifiedX < 0) {
            mUnmodifiedX = 0;
        }
    }
    public void logMoveX(int x) {
        if (Game.getLives() <= 0) {
            return;
        }
        logShift = x;
        this.mUnmodifiedX += logShift;
        if (mUnmodifiedX < 0 || mUnmodifiedX > 990) {
            Game.death();
        }
        System.out.println();
    }

    public void setY(int unmodifiedY) {
        if (Game.getLives() <= 0) {
            return;
        }
        this.mUnmodifiedY = unmodifiedY;
        if (mUnmodifiedY > Constants.startingY) {
            mUnmodifiedY = Constants.startingY;
        } else if (mUnmodifiedY < 0) {
            mUnmodifiedY = 0;
        }
    }
    public void resetY(int y) {
        mUnmodifiedY = y;
    }
    public int getMaxDistance() {
        return maxDistance;
    }
    public void setMaxDistance(int num) {
        maxDistance = num;
    }
    public String getName() {
        return name;
    }
    public void setName(String str) {
        name = str;
    }
    public int getX() {
        return mUnmodifiedX;
    }
    public int getY() {
        return mUnmodifiedY;
    }
    public int getSprite() {
        return sprite;
    }
    public void setSprite(int num) {
        sprite = num;
    }
}
