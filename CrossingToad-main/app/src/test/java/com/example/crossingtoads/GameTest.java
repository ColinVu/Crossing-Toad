package com.example.crossingtoads;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void testEasy() {
        boolean result = Game.isEasy(1, 5);
        boolean expected = true;
        assertEquals(result, expected);
    }

    @Test
    public void testMedium() {
        boolean result = Game.isMedium(2, 4);
        boolean expected = true;
        assertEquals(result, expected);
    }

    @Test
    public void testHard() {
        boolean result = Game.isHard(3, 3);
        boolean expected = true;
        assertEquals(result, expected);
    }

    @Test
    public void testNullName() {
        boolean result = Game.isValidName(null);
        boolean expected = false;
        assertEquals(result, expected);
    }

    @Test
    public void testEmptyName() {
        boolean result = Game.isValidName("");
        boolean expected = false;
        assertEquals(result, expected);
    }

    @Test
    public void testSpacesName() {
        boolean result = Game.isValidName(" ");
        boolean expected = false;
        assertEquals(result, expected);
    }

    @Test
    public void testTrainX() {
        Vehicle train1 = new Train(700, 1260,0, 9);
        Vehicle[] vehicles = new Vehicle[10];
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i] = new Sedan(0,0,0,i);
        }
        boolean actual = true;
        boolean expected = (train1.getX() <= 710 && train1.getX() >= 700);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testTrainDirection() {
        Vehicle train1 = new Train(700, 1260,0, 9);
        Vehicle[] vehicles = new Vehicle[10];
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i] = new Sedan(0,0,0,i);
        }
        boolean actual = true;
        boolean expected = (train1.getDirection() == 0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTrainY() {
        Vehicle train1 = new Train(700, 1260,0, 9);
        Vehicle[] vehicles = new Vehicle[10];
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i] = new Sedan(0,0,0,i);
        }
        boolean actual = true;
        boolean expected = (train1.getY() <= 1260);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testTruckX() {
        Vehicle truck1 = new Truck(400, 1350,0, 9);
        Vehicle[] vehicles = new Vehicle[10];
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i] = new Sedan(0,0,0,i);
        }
        boolean actual = true;
        boolean expected = (truck1.getX() <= 410 && truck1.getX() >= 400);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTruckDirection() {
        Vehicle truck1 = new Truck(400, 1350, 0, 9);
        Vehicle[] vehicles = new Vehicle[10];
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i] = new Sedan(0,0,0,i);
        }
        boolean actual = true;
        boolean expected = truck1.getDirection() == 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSedanX() {
        Vehicle sedan1 = new Sedan(300, 20,0, 9);
        Vehicle[] vehicles = new Vehicle[10];
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i] = new Sedan(0,0,0,i);
        }
        boolean actual = true;
        boolean expected = (sedan1.getX() <= 310 && sedan1.getX() >= 300);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSedanY() {
        Vehicle sedan1 = new Sedan(300, 20,0, 9);
        Vehicle[] vehicles = new Vehicle[10];
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i] = new Sedan(0,0,0,i);
        }
        boolean actual = true;
        boolean expected = (sedan1.getY() <= 20);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSedanDirection() {
        Vehicle sedan1 = new Sedan(300, 20,0, 9);
        Vehicle[] vehicles = new Vehicle[10];
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i] = new Sedan(0,0,0,i);
        }
        boolean actual = true;
        boolean expected = (sedan1.getDirection() == 0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerInitialX() {
        Player player1 = new Player(540, 1800);
        int actual = player1.getX();
        int expected = 540;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerInitialY() {
        Player player1 = new Player(540, 1800);
        int actual = player1.getY();
        int expected = 1800;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testPlayerRight() {
        Game game = new Game(null, null);
        game.moveX(20);
        int actual = game.getPlayer().getX();
        int expected = 20;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testPlayerDown() {
        Game game = new Game(null, null);
        game.moveY(20);
        int actual = game.getPlayer().getY();
        int expected = 20;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testDeathLives() {
        Game game = new Game(null, null);
        game.setLives(3);
        game.death();
        int actual = game.getLives();
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testVehicleCollisionLives() {
        Game game = new Game(null, null);
        game.setLives(3);
        Sedan v1 = new Sedan(400,1800,1,0);
        game.getPlayer().setX(400);
        game.getPlayer().setY(1800);
        v1.move();
        int actual = game.getLives();
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testDeathY() {
        Game game = new Game(null, null);
        game.getPlayer().setY(1710);
        game.death();
        int actual = game.getPlayer().getY();
        int expected = 1800;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testVehicleCollisionY() {
        Game game = new Game(null, null);
        Sedan v1 = new Sedan(400,1710,1,0);
        game.getPlayer().setX(400);
        game.getPlayer().setY(1710);
        v1.move();
        int actual = game.getPlayer().getY();
        int expected = 1800;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testDeathScoreAboveZero() {
        Game game = new Game(null, null);
        game.setLives(3);
        game.setScore(100);
        game.death();
        int actual = game.getScore();
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testDeathScoreAtZero() {
        Game game = new Game(null, null);
        game.setLives(1);
        game.setScore(100);
        game.death();
        int actual = game.getScore();
        int expected = 100;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testVehicleMovementGameOver() {
        Game game = new Game(null, null);
        game.setLives(0);
        Sedan v1 = new Sedan(10,10,1,1);
        v1.move();
        int actual = v1.getX();
        int expected = 10;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testPlayerXGameOver() {
        Game game = new Game(null, null);
        game.getPlayer().setX(10);
        game.setLives(0);
        game.moveX(100);
        int actual = game.getPlayer().getX();
        int expected = 10;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testPlayerYGameOver() {
        Game game = new Game(null, null);
        game.getPlayer().setY(1710);
        game.setLives(0);
        game.moveY(100);
        int actual = game.getPlayer().getY();
        int expected = 1710;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testLogMvmtSmall() {
        Log log = new SmallLog(100,100,1, 0);
        log.move();
        int actual = log.getX();
        int expected = 115;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testLogMvmtLarge() {
        Log log = new BigLog(100,100,1, 0);
        log.move();
        int actual = log.getX();
        int expected = 105;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testLogWrapAroundTooLarge() {
        Log log = new BigLog(2000,100,1, 0);
        log.move();
        int actual = log.getX();
        int expected = -340;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testLogWrapAroundTooSmall() {
        Log log = new BigLog(-2000,100,1, 0);
        log.move();
        int actual = log.getX();
        int expected = 1290;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testMovedWithLog() {
        Game game = new Game(null, null);
        game.getPlayer().setX(100);
        game.getPlayer().setY(1800);
        Log log = new BigLog(80,1800,1, 0);
        game.getPlayer().logMoveX(15);
        int actual = game.getPlayer().getX();
        int expected = 115;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testLogMovesOffWithPlayer() {
        Game game = new Game(null, null);
        game.getPlayer().setX(985);
        game.getPlayer().setY(1800);
        game.setLives(3);
        Log log = new BigLog(985,1800,1, 0);
        game.getPlayer().logMoveX(15);
        int actual = game.getLives();
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testNoMoveYGameWin() {
        Game game = new Game(null, null);
        game.getPlayer().setX(100);
        game.getPlayer().setY(100);
        game.moveY(10);
        int actual = game.getPlayer().getY();
        int expected = 100;
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testVehicleMvmtGameWin() {
        Game game = new Game(null, null);
        game.setWin(true);
        Log log = new BigLog(80,1800,1, 0);
        log.move();
        int actual = log.getX();
        int expected = 80;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testLogMvmtGameWin() {
        Game game = new Game(null, null);
        game.setWin(true);
        Vehicle car = new Sedan(80,1800,1, 0);
        car.move();
        int actual = car.getX();
        int expected = 80;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testLogMvmtGameOver() {
        Game game = new Game(null, null);
        game.setLives(-1);
        Vehicle car = new Sedan(80,1800,1, 0);
        car.move();
        int actual = car.getX();
        int expected = 80;
        Assert.assertEquals(expected, actual);
    }

}