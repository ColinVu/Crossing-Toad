package com.example.crossingtoads;

public class Sedan extends Vehicle {
    public Sedan(int x, int y, int direction, int index) {
        super(x, y, 1, direction, 0, (int) (Math.random() * 5) + 5, index);
    }

    @Override
    public void move() {
        super.move();
        if (super.getX() > 1200) {
            super.setX(-500);
            super.setSpeed((int) (Math.random() * 5) + 5);
        }
    }
}
