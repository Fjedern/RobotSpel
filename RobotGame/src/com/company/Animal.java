package com.company;

import java.util.Random;

public abstract class Animal extends GameBoard {
    private int currentX;
    private int currentY;
    private char name;
    private int steps;
    private boolean hitTheWall = false;
    Random rand = new Random();

    // Defaultkonstruktor
    public Animal() {
        // styra hur många steg djuret ska gå denna omgång.
        this.currentX = 3;
        this.currentY = 4;
        this.hitTheWall = false;
        this.steps = 1;
    }

    public Animal(char name, int x, int y) {
        this.currentX = x;
        this.currentY = y;
        this.name = name;
    }

    public int getCurrentX() {
        return currentX;
    }

    public char getName() {
        return name;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        int back = rand.nextInt(steps) + 1;
        this.steps = back;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void moveAnimalRight() {
        hitTheWall = false;
        int right = this.currentX;
        int up = this.currentY;
        if (right < 39 && hitTheWall == false) {
            right++;
            setCurrentX(right);
        } else {
            setHitTheWall(true);
            if (right > 39 && up < 7) {
                up++;
                setCurrentY(up);
            } else {
                right--;
                setCurrentX(right);
            }
        }
    }

    //whatIsOnSpot(right++, up) == '-'

    public void moveAnimalLeft() {
        hitTheWall = false;
        int right = this.currentX;
        int up = this.currentY;
        if (right > 0 && hitTheWall == false) {
            right--;
            setCurrentX(right);
        } else {
            setHitTheWall(true);
            if (up < 7) {
                up++;
                setCurrentY(up);
            } else {
                right++;
                setCurrentX(right);
            }
            right++;
            setCurrentX(right);
        }
    }

    public void moveAnimalUp() {
        hitTheWall = false;
        int left = this.currentX;
        int up = this.currentY;
        if (up > 0 && hitTheWall == false) {
            up--;
            setCurrentY(up);
        } else {
            setHitTheWall(true);
            if (left > 0) {
                left--;
                setCurrentX(left);
            } else {
                up++;
                setCurrentY(up);
            }
        }
    }

    public void moveAnimalDown() {
        hitTheWall = false;
        int left = this.currentX;
        int down = this.currentY;
        if (down < 7 && hitTheWall == false) {
            down++;
            setCurrentY(down);
        } else {
            setHitTheWall(true);
            if (left > 0) {
                left--;
                setCurrentX(left);
            } else {
                down--;
                setCurrentY(down);
            }
        }
    }

    public void setHitTheWall(boolean hitTheWall) {
        this.hitTheWall = hitTheWall;
    }
}

