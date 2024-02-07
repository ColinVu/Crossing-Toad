package com.example.crossingtoads;

public class MedLog extends Log {
    public MedLog(int x, int y, int direction, int index) {
        super(x, y, 2, direction, 2, 10, index);
    }
    @Override
    public void move() {
        super.move();
        if (super.getX() > 1200) {
            super.setX(-190);
        }
        if (super.getX() < -200) {
            super.setX(1190);
        }
    }
}
