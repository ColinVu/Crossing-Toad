package com.example.crossingtoads;

public class Game {
    private static GameCustomization s1;
    private static GameScreen s2;
    private static int difficulty;
    private static int score;
    private static int lives;
    private static Player player;
    private static Vehicle[] vehicles;
    private static Log[] logs;

    private static int iteration;
    private static boolean win;

    //Tiles: 0 = safe; 1 = road; 2 = water; 3 = goal
    private static int[][] tileArray = {
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    public Game(GameCustomization s1, GameScreen s2) {
        this.s1 = s1;
        this.s2 = s2;
        score = 0;
        lives = 3;
        win = false;
        iteration = 0;

        player = new Player(Constants.startingX, Constants.startingY);
        vehicles = new Vehicle[10];
        for (int i = 0; i < vehicles.length; i++) {
            if (i < 4) {
                vehicles[i] = new Sedan(((i - 2) * -400) - (int) (Math.random() * 100), 1620, 0, i);
            } else if (i < 8) {
                vehicles[i] = new Sedan(((i - 6) * -400) - (int) (Math.random() * 100), 1530, 0, i);
            } else if (i < 9) {
                vehicles[i] = new Truck(400, 1350, 0, i);
            } else {
                vehicles[i] = new Train(700, 1260, 0, i);
            }
        }
        logs = new Log[14];
        logs[0] = new BigLog(300, 900, 1, 0);
        logs[1] = new MedLog(200, 810, 2, 1);
        logs[2] = new MedLog(900, 810, 2, 2);
        logs[3] = new SmallLog(-50, 720, 1, 3);
        logs[4] = new SmallLog(350, 720, 1, 4);
        logs[5] = new SmallLog(750, 720, 1, 5);
        logs[6] = new MedLog(400, 540, 1, 6);
        logs[7] = new MedLog(1100, 540, 1, 7);
        logs[8] = new SmallLog(100, 450, 2, 8);
        logs[9] = new SmallLog(500, 450, 2, 9);
        logs[10] = new SmallLog(900, 450, 2, 10);
        logs[11] = new BigLog(600, 360, 1, 11);
        logs[12] = new MedLog(300, 270, 2, 12);
        logs[13] = new MedLog(1000, 270, 2, 13);
    }
    public Game(GameScreen s2) {
        this.s2 = s2;
    }
    public static void moveVehicles() {
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].move();
        }
    }
    public static void moveLogs() {
        for (int i = 0; i < logs.length; i++) {
            logs[i].move();
        }

    }
    public void setPlayerCoords(int x, int y) {
        player.setX(x);
        player.setY(y);
    }
    public static Player getPlayer() {
        return player;
    }
    public void setPlayer(Player newPlayer) {
        player = newPlayer;
    }
    //public void getTiles() {
    //    return tileArray;
    //}
    //public void setVehicles(Vehicle[] vehicles) {
    //    this.vehicles = vehicles;
    //}
    public static int getDifficulty() {
        return Game.difficulty;
    }
    public static void setDifficulty(int difficulty) {
        Game.difficulty = difficulty;
    }
    public static int getScore() {
        return Game.score;
    }
    public static int getLives() {
        return Game.lives;
    }
    public static void setLives(int lives) {
        Game.lives = lives;
    }

    public void checkCollisions() {
        //if (tileArray[playerX/?][playerY/?].equals("Road")) {
        //CHECK THIS COLLISION
        //} //REPEAT FOR THE REST OF THE COLLISIONS
    }
    public static int getCurrTile() {
        return tileArray[player.getY() / 90][player.getX() / 90];
    }

    public static boolean isEasy(int d, int l) {
        return d == 1 && l == 5;
    }
    public static boolean isMedium(int d, int l) {
        return d == 2 && l == 4;
    }
    public static boolean isHard(int d, int l) {
        return d == 3 && l == 3;
    }
    public static boolean isValidName(String n) {
        return !(n == null || n.isEmpty() || n.trim().isEmpty());
    }
    public static void moveX(int num) {
        player.setX(num);
    }
    public static void moveY(int num) {
        if (player.getY() >= 180) {
            player.setY(num);
        }
        switch (getCurrTile()) {
        case 1:
            if (player.getMaxDistance() > player.getY()) {
                player.setMaxDistance(num);
                score++;
            }
            break;
        case 2:
            if (player.getMaxDistance() > player.getY()) {
                player.setMaxDistance(num);
                score += 2;
            }
            break;
        case 3:
            if (player.getMaxDistance() > player.getY()) {
                player.setMaxDistance(num);
            }
            break;
        default:
            break;
        }
    }
    public static Vehicle[] getVehicles() {
        return vehicles;
    }
    public static Log[] getLogs() {
        return logs;
    }
    public static void death() {
        lives--;
        if (lives > 0) {
            score = 0;
        }
        player.setX(Constants.startingX);
        player.setY(Constants.startingY);
        player.setMaxDistance(Constants.startingY);
    }
    public static void setScore(int num) {
        score = num;
    }
    public static void setIteration() {
        iteration = 1;
    }
    public static int getIteration() {
        return iteration;
    }
    public static boolean getWin() {
        return win;
    }
    public static void setWin(boolean w) {
        win = w;
    }
}
