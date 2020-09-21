package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //gameBoard game = new gameBoard();
        //game.printGameBoard();
        gameBoard game = new gameBoard(40, 8);
        game.fillArray();
        game.setObjectOnLocation(3, 4);
        game.printGameBoard();
    }
}
