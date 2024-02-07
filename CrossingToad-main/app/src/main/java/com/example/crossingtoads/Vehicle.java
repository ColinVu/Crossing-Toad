package com.example.crossingtoads;

public abstract class Vehicle {
    private int x;
    private int y;
    private int length;
    private int speed;
    private int orientation;
    private int direction;
    private int sprite;
    private int index;

    public Vehicle(int x, int y, int length, int direction, int sprite, int speed, int index) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.direction = direction;
        this.sprite = sprite;
        this.speed = speed;
        this.index = index;
    }

    public void move() {
        if (Game.getLives() <= 0 || Game.getWin()) {
            return;
        }
        x += speed;
        Vehicle[] vehicles = Game.getVehicles();
        if (index != 0 && vehicles[index - 1].getY() == y && vehicles[index - 1].getX() < (x + 200)
                && speed > vehicles[index - 1].getSpeed()) {
            int temp = speed + (int) (Math.random() * 5) - 2;
            setSpeed(vehicles[index - 1].getSpeed() + (int) (Math.random() * 5) - 2);
            vehicles[index - 1].setSpeed(temp);
        } else if ((index == 0 || index == 4) && vehicles[index + 3].getX() < (x + 200)
                && speed > vehicles[index + 3].getSpeed()) {
            int temp = speed + (int) (Math.random() * 5) - 2;
            setSpeed(vehicles[index + 3].getSpeed() + (int) (Math.random() * 5) - 2);
            vehicles[index + 3].setSpeed(temp);
        }
        if (y == Game.getPlayer().getY() && x > Game.getPlayer().getX() - 90 * length && x < Game.getPlayer().getX() + 90) {
            System.out.println("COLLISION!");
            Game.death();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getOrientation() {
        return orientation;
    }

    public int getSpeed() {
        return speed;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSprite() {
        return sprite;
    }

    public void setSprite(int sprite) {
        this.sprite = sprite;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        if (speed > 10 && length == 1) {
            this.speed = (int) (Math.random() * 5) + 5;
        } else if (speed < 1) {
            this.speed = (int) (Math.random() * 5) + 5;
        }
    }
}
