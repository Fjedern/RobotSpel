package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);


        int startingPositionX;
        int startingPositionY;
        //Setup gameBoard
        GameBoard game = new GameBoard(40, 8);
        game.fillArray();

        //Create list of animals. Type of list is AnimalStaffan
        ArrayList<Animal> animalList = new ArrayList<Animal>();

        //Ask user for animal input
        User user = new User();
        user.animalCountInput();

        //Create Zebra and generate random starting positions
        for (int i = 0; i < user.getZebraCount(); i++) {
            startingPositionX = rand.nextInt(40);
            startingPositionY = rand.nextInt(8);
            animalList.add(new Zebra( startingPositionX, startingPositionY));
        }

        //Create Cheetah and generate random starting positions
        for (int i = 0; i < user.getCheetahCount(); i++) {
            startingPositionX = rand.nextInt(40);
            startingPositionY = rand.nextInt(8);
            animalList.add(new Cheetah( startingPositionX, startingPositionY));
        }

        //Set objects on respective coordinates on gameboard.
        for (int i = 0; i < animalList.size(); i++) {
            game.setObjectOnLocation(animalList.get(i).getName(), animalList.get(i).getCurrentX(), animalList.get(i).getCurrentY());
        }

        //Print gameboard
        game.printGameBoard();
        System.out.println();

        int steps = 1;
        Direction direction;

        boolean gameRunning = true;

        //Actual running. Running until pressing stop
        while (gameRunning) {
            for (int j = 0; j < animalList.size(); j++) { //Loops animals
                direction = Direction.values()[rand.nextInt(Direction.values().length)];
                for (int i = 0; i < steps ; i++) {  //Loops steps
                    game.clearScreenOnLocation(animalList.get(j).getCurrentX(), animalList.get(j).getCurrentY()); //Erase previous animal position
                    switch (direction) {    //Different directions
                        case LEFT:
                            animalList.get(j).moveAnimalLeft();
                            break;
                        case RIGHT:
                            animalList.get(j).moveAnimalRight();
                            break;
                        case UP:
                            animalList.get(j).moveAnimalUp();
                            break;
                        case DOWN:
                            animalList.get(j).moveAnimalDown();
                            break;
                        default:
                            System.out.println("Switch error in type out animal");
                    }
                    game.setObjectOnLocation(animalList.get(j).getName(), animalList.get(j).getCurrentX(), animalList.get(j).getCurrentY()); //Assign new positio to gameboard
                }
                for (int d = 0; d < animalList.size(); d++) { // compare x and y value of each animals
                    for (int a = d + 1; a < animalList.size(); a++) {
                        if (animalList.get(d).getCurrentX() == animalList.get(a).getCurrentX() && animalList.get(d).getCurrentY() == animalList.get(a).getCurrentY()) {
                            if (animalList.get(d).getName() != animalList.get(a).getName()) { // Checking collision between Zebra and Cheetah only not (zebra-zebra) or (cheetah-Cheetah)
                                if (animalList.get(d).getName() == 'Z') {
                                    animalList.remove(d);
                                } else {
                                    animalList.remove(a);
                                }
                            }
                        }
                    }
                }
            }
            game.printGameBoard();  //Print gameboard to console
            System.out.println();
            Thread.sleep(10);   //Pause. Print-out speed
        }
    }}