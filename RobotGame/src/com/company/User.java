package com.company;

import java.util.Scanner;


public class User{
    Scanner scan = new Scanner(System.in);
    private int zebraCount;
    private int cheetahCount;

    //Default
    public User() {
        this.zebraCount = 0;
        this.cheetahCount = 0;
    }

    public int getZebraCount() {
        return zebraCount;
    }

    public void setZebraCount(int zebraCount) {
        while (zebraCount <= 0) {
            System.out.println("You must have at least 1 Zebra!\nHow many Zebras?");
            zebraCount = scan.nextInt();
        }
        this.zebraCount = zebraCount;
    }

    public int getCheetahCount() {
        return cheetahCount;
    }

    public void setCheetahCount(int cheetahCount) {
        while (cheetahCount <= 0 || cheetahCount > getZebraCount()) {
            if (cheetahCount <= 0) {
                System.out.println("You must have at least 1 Cheetah!\nHow many Cheetahs?");
                cheetahCount = scan.nextInt();
            } else {
                System.out.println("Too many cheetahs!\nYou can't have more cheetahs than zebras!\nHow many Cheetahs?");
                cheetahCount = scan.nextInt();
            }
        }
        this.cheetahCount = cheetahCount;
    }

    public void animalCountInput() {
        System.out.println("How many Zebras?");
        setZebraCount(scan.nextInt());
        System.out.println("How many Cheetahs?");
        setCheetahCount(scan.nextInt());
    }
}
