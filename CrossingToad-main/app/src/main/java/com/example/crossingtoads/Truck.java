package com.example.crossingtoads;

public class Truck extends Vehicle {
    public Truck(int x, int y, int direction, int index) {
        super(x, y, 2, direction, 1, (int) (Math.random() * 3) + 25, index);
    }
    @Override
    public void move() {
        super.move();
        if (super.getX() > 1200) {
            super.setX(-500);
            super.setSpeed((int) (Math.random() * 3) + 25);
        }
    }
}
