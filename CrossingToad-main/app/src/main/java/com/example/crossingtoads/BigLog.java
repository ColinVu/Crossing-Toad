package com.example.crossingtoads;

public class BigLog extends Log {
    public BigLog(int x, int y, int direction, int index) {
        super(x, y, 3, direction, 3, 5, index);
    }
    @Override
    public void move() {
        super.move();
        if (super.getX() > 1300) {
            super.setX(-340);
        }
        if (super.getX() < -350) {
            super.setX(1290);
        }
    }
}
