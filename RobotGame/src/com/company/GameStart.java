package com.company;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.System.currentTimeMillis;


public class GameStart {
    //Actual running. Running until pressing stop
    void start() throws InterruptedException {
        Random rand = new Random();


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
            animalList.add(new Zebra(startingPositionX, startingPositionY));
        }

        //Create Cheetah and generate random starting positions
        for (int i = 0; i < user.getCheetahCount(); i++) {
            startingPositionX = rand.nextInt(40);
            startingPositionY = rand.nextInt(8);
            animalList.add(new Cheetah(startingPositionX, startingPositionY));
        }

        //Set objects on respective coordinates on gameboard.
        for (int i = 0; i < animalList.size(); i++) {
            game.setObjectOnLocation(animalList.get(i).getName(), animalList.get(i).getCurrentX(), animalList.get(i).getCurrentY());
        }

        //Print gameboard
        game.printGameBoard();


        Direction direction;

        boolean gameRunning = true;

        int zebraCount = user.getZebraCount();
        int cheetahCount = user.getCheetahCount();

        while (gameRunning) {
            for (int j = 0; j < animalList.size(); j++) { //Loops animals
                //direction = Direction.values()[rand.nextInt(Direction.values().length)];
                int randomSteps = rand.nextInt(animalList.get(j).getSteps()) + 1; // Makes each animal take random steps within its range every round
                for (int i = 0; i < randomSteps; i++) {  //Loops steps
                    direction = Direction.values()[rand.nextInt(Direction.values().length)];
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
                for (int x = 0; x < animalList.size(); x++) { // compare x and y value of each animals  0
                    for (int y = x + 1; y < animalList.size(); y++) {          //                         1
                        if (animalList.get(x).getCurrentX() == animalList.get(y).getCurrentX() && animalList.get(x).getCurrentY() == animalList.get(y).getCurrentY() && animalList.get(x).getName() != animalList.get(y).getName()) {     //Om samma plats
                            //if (animalList.get(x).getName() != animalList.get(y).getName()) { // Checking collision between Zebra and Cheetah only not (zebra-zebra) or (cheetah-Cheetah)
                                if (animalList.get(x).getName() == 'Z') {   //bara om Z i ytterloop
                                    if (animalList.get(y).getHungry() == true) {
                                        animalList.get(y).setHungry(false);
                                        long time = currentTimeMillis();
                                        animalList.get(y).setStartTime(time);
                                        animalList.remove(x);
                                        zebraCount--;
                                        System.out.print("1");// test
                                } else {
                                        long currentTime = currentTimeMillis() - animalList.get(y).getStartTime();
                                        //System.out.println(currentTime);
                                        if (currentTime > 10000) {
                                            animalList.get(y).setHungry(false);
                                            long time = currentTimeMillis();
                                            //System.out.println(time);
                                            animalList.get(y).setStartTime(time);
                                            animalList.remove(x);
                                            zebraCount--;
                                            System.out.print("2");
                                        }
                                    }
                                }
                            //}
                        }
                    }
                }
            }
            game.printGameBoard();  //Print gameboard to console
            System.out.printf("%s%n", "Zebror: " + zebraCount + " Cheetah: " + cheetahCount);   //Type out full cheetah count
            Thread.sleep(50);   //Pause. Print-out speed

            if(zebraCount == 0){
                gameRunning = false;
                game.printGameBoard();  //Print gameboard to console
                System.out.print("Game over all zebras are eaten!");
            }
        }
    }
}
