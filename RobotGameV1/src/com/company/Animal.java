package com.company;

public class Animal {
    private int x;
    private int y;
    private char name;

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

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void moveLeft(gameBoard game, Animal animal){
        animal.setX(getX() - 1);

    }
}

/*
Loop som flyttar alla djur
*/
