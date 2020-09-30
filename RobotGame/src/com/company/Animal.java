package com.company;



public abstract class Animal extends GameBoard implements Movable {
    private int currentX;
    private int currentY;
    private char name;
    private int steps;

    private boolean hungry;
    private long startTime;
    //private boolean hitTheWall = false;


    // Defaultkonstruktor
    public Animal() {
        // styra hur många steg djuret ska gå denna omgång.
        this.currentX = 3;
        this.currentY = 4;
        this.steps = 1;
        //this.hitTheWall = false;
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
        this.steps = steps;
    }

    public void setName(char name) {
        this.name = name;
    }
    public boolean getHungry() {
        return hungry;
    }
    public void setHungry(boolean value){
        hungry = value;
    }
    public long getStartTime(){
        return startTime;
    }
    public void setStartTime(long time){
        startTime = time;
    }



    /*public void moveAnimalRight() {
        //hitTheWall = false;
        int right = this.currentX;
        int up = this.currentY;
        if (right < 39) {
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
        //hitTheWall = false;
        int right = this.currentX;
        int up = this.currentY;
        if (right > 0) {
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
        }
    }

    public void moveAnimalUp() {
        //hitTheWall = false;
        int left = this.currentX;
        int up = this.currentY;
        if (up > 0) {
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
        //hitTheWall = false;
        int left = this.currentX;
        int down = this.currentY;
        if (down < 7) {
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
    }*/
    public void moveAnimalRight() {
        int right = this.currentX;
        int up = this.currentY;
        if (right < 39) {
            right++;
            setCurrentX(right);
        } else {
            if (up < 7) {
                up++;
                setCurrentY(up);
            } else {
                up--;
                setCurrentY(up);
            }
        }
    }



    public void moveAnimalLeft() {
        int right = this.currentX;
        int up = this.currentY;
        if (right > 0) {
            right--;
            setCurrentX(right);
        } else {
            if (up < 7) {
                up++;
                setCurrentY(up);
            } else {
                up--;
                setCurrentY(up);
            }
        }
    }

    public void moveAnimalUp() {
        int left = this.currentX;
        int up = this.currentY;
        if (up > 0) {
            up--;
            setCurrentY(up);
        } else {

            if (left > 0) {
                left--;
                setCurrentX(left);
            } else {
                left++;
                setCurrentX(left);
            }
        }
    }

    public void moveAnimalDown() {
        int left = this.currentX;
        int down = this.currentY;
        if (down < 7) {
            down++;
            setCurrentY(down);
        } else {

            if (left > 0) {
                left--;
                setCurrentX(left);
            } else {
                left++;
                setCurrentX(left);
            }
        }
    }

    /*public void setHitTheWall(boolean hitTheWall) {
        this.hitTheWall = hitTheWall;
    }*/
}

