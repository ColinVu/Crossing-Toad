package com.example.crossingtoads;

public class Train extends Vehicle {
    public Train(int x, int y, int direction, int index) {
        super(x, y, 2, direction, 2, (int) (Math.random() * 3) + 60, index);
    }
    @Override
    public void move() {
        super.move();
        if (super.getX() > 1200) {
            super.setX(-500);
            super.setSpeed((int) (Math.random() * 3) + 60);
        }
    }
}
