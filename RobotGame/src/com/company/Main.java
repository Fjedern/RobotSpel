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
        int antalZebra;
        int antalCheetah;
        System.out.println("How many Zebras?");
        antalZebra = scan.nextInt();
        while (antalZebra < 1){ //Check that there is at least one zebra in the game.
            System.out.println("You must have at least 1 Zebra!\nHow many Zebras?");
            antalZebra = scan.nextInt();
        }
        System.out.println("How many Cheetahs?");
        antalCheetah = scan.nextInt();
        while (antalCheetah <1 || antalCheetah > antalZebra){ //Check that there is at least one cheetah and that they are fewer than Zebras
            if(antalCheetah > antalZebra) {
                System.out.println("Too many cheetahs!\nYou can't have more cheetahs than zebras!");
            }
            else{
                System.out.println("You must have at least 1 Cheetah!");
            }
            System.out.println("How many Cheetahs?");
            antalCheetah = scan.nextInt();
        }

        //Create Zebra and generate random starting positions
        for (int i = 0; i < antalZebra; i++) {
            startingPositionX = rand.nextInt(40);
            startingPositionY = rand.nextInt(8);
            animalList.add(new Animal('Z', startingPositionX, startingPositionY));
        }
        //Create Cheetah and generate random starting positions
        for (int i = 0; i < antalCheetah; i++) {
            startingPositionX = rand.nextInt(40);
            startingPositionY = rand.nextInt(8);
            animalList.add(new Animal('C', startingPositionX, startingPositionY));
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


        //Actual running. Running until pressing stop
        while (true) {
            for (int j = 0; j < animalList.size(); j++) { //Loops animals
                direction = Direction.values()[rand.nextInt(Direction.values().length)];
                for (int i = 0; i < steps; i++) {  //Loops steps
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