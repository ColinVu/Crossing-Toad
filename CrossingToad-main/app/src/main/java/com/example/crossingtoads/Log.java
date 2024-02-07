package com.example.crossingtoads;

public abstract class Log {
    private int x;
    private int y;
    private int length;
    private int speed;
    private int orientation;
    private int direction;
    private int sprite;
    private int index;
    private Log[] logList;

    public Log(int x, int y, int length, int direction, int sprite, int speed, int index) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.direction = direction;
        this.sprite = sprite;
        this.speed = speed;
        this.index = index;
        logList = Game.getLogs();
    }
    public boolean collision(int index) {
        if (logList[index].getY() == Game.getPlayer().getY() && (Game.getPlayer().getX() + 90 < logList[index].getX() || Game.getPlayer().getX() > logList[index].getX() + 90 * (length + 1))) {
           return true;
        }
        return false;
    }

    public void move() {
        if (Game.getLives() <= 0 || Game.getWin()) {
            return;
        }
        if (y == Game.getPlayer().getY()) {
            if (direction == 1) {
                x += speed;
                if (index == 0) {
                }
                if (index == 0 || index == 3 || index == 6 || index == 11) {
                    Game.getPlayer().logMoveX(speed);
                }
            } else if (direction == 2) {
                x -= speed;
                if (index == 1 || index == 8 || index == 12) {
                    Game.getPlayer().logMoveX(-1 * speed);
                }
            }
        } else {
            if (direction == 1) {
                x += speed;
            } else if (direction == 2) {
                x -= speed;
            }
        }
        if (y == Game.getPlayer().getY() && (Game.getPlayer().getX() + 90 < x || Game.getPlayer().getX() > x + 90 * (length + 1))) {
            if (index == 0 || index == 11) {
                Game.death();
            } else if ((index == 1 || index == 2) && collision(1) && collision(2)) {
                Game.death();
            } else if ((index == 3 || index == 4 || index == 5) && collision(3) && collision(4) && collision(5)) {
                Game.death();
            } else if ((index == 6 || index == 7) && collision(6) && collision(7)) {
                Game.death();
            } else if ((index == 8 || index == 9 || index == 10) && collision(8) && collision(9) && collision(10)) {
                Game.death();
            } else if ((index == 12 || index == 13) && collision(12) && collision(13)) {
                Game.death();
            }
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
