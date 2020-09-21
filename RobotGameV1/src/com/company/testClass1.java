package com.company;
import java.util.*;

public class testClass1 {
    public static void main(String[] args) throws InterruptedException {
        /*for(int i = 0; i < 10; i++){
            System.out.print(i + "\n");
            drawLine();
            System.out.print("\r");
        }*/
        //gameTest1();
        //printGrid();

        //Thread.sleep(2000);
        //clearScreen();
    }

    public static void clearScreen() throws InterruptedException {
        for(int i = 0; i < 50; i++){
            System.out.print(" ");
            Thread.sleep(50);
        }
    }

    public static void drawLine() throws InterruptedException {
        for(int i = 0; i < 50; i++){
            System.out.print("-");
            Thread.sleep(15);
        }
    }

    public static void multTable() {
        int column = 1;
        int row = 1;
        int svar;
        while(column <= 10){
            row = 1;
            while(row <= 20){
                svar = row + column;
                System.out.print(svar + "\t");
                row++;
            }
            System.out.print("\n");
            column++;
        }
    }



    public static void printGrid(){
        int n = 10;
        int[][] Grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(Grid[i][j] + "");
            }
            System.out.print("\n");
        }
    }
}


