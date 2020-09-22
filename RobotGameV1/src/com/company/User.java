package com.company;

import java.util.Scanner;

public class User {
    private int cheetahCount;
    private int zebraCount;

    public int getCheetahCount() {
        return cheetahCount;
    }

    public void setCheetahCount(int cheetahCount) {
        if (cheetahCount > 0){
            this.cheetahCount = cheetahCount;
        }else {
            System.out.println("Please enter a bigger value");
        }

    }

    public int getZebraCount() {
        return zebraCount;
    }

    public void setZebraCount(int zebraCount) {
        if (zebraCount > 0){
            this.zebraCount = zebraCount;
        }else {
            System.out.println("Please enter a bigger value");
        }
    }

    public void userInputAnimals(){
        Scanner scan = new Scanner(System.in);
        System.out.println("How many cheetah do you want?");
        cheetahCount = scan.nextInt();
        System.out.println("How many zebra do you want?");
        zebraCount = scan.nextInt();
        System.out.println("Game will start with " + cheetahCount + " cheetahs and " + zebraCount + " zebra");
    }
}
