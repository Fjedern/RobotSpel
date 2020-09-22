package com.company;

import java.util.Random;

/*Created by David Nilsson(Fjedern) on 2020-09-21*/

public class gameBoard {
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

    public gameBoard(int width, int height) {
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
    }

    //Clear on (x, y)
    public void clearScreenOnLocation(int x, int y){
        this.matrix[y][x] = '-';
    }

    //setObject on (x,y)
    public void setObjectOnLocation(int x, int y){
        this.matrix[y - 1][x - 1] = 'T';
    }

}
