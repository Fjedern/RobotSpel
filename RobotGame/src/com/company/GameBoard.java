package com.company;



import static java.lang.System.currentTimeMillis;

public class GameBoard {
    private int width;
    private int height;
    private char[][] matrix;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    //Default
    public GameBoard(){
        width = 40;
        height = 8;
        this.matrix = new char[this.height][this.width];
    }

    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[this.height][this.width];
    }

    //Fill 2dArray with lines
    public void fillArray(){
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.matrix[i][j] = '-';
            }
        }
    }

    //Print entire 2d array
    public void printGameBoard() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    //Clear on x, y
    public void clearScreenOnLocation(int x, int y){
        this.matrix[y][x] = '-';
    }


    public void setObjectOnLocation(char name, int x, int y){
        this.matrix[y][x] = name;
    }
    public static boolean isCheetahHungry(Animal cheetah) {
        boolean hungry = false;
        if (cheetah.getHungry() == true) {
            long time = currentTimeMillis();
            cheetah.setStartTime(time);
            cheetah.setHungry(false);
            hungry =true;
        } else {
            long currentTime = currentTimeMillis() - cheetah.getStartTime();
            if (currentTime > 5000) {
                long time = currentTimeMillis();
                cheetah.setStartTime(time);
                hungry=true;
            }
        }
        return hungry;
    }}



