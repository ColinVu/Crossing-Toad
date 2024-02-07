package com.example.crossingtoads;

public class SmallLog extends Log {
    public SmallLog(int x, int y, int direction, int index) {
        super(x, y, 1, direction, 1, 15, index);
    }
    @Override
    public void move() {
        super.move();
        if (super.getX() > 1100) {
            super.setX(-150);
        }
        if (super.getX() < -200) {
            super.setX(1050);
        }
    }
}
