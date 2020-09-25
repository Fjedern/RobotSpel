package com.company;

import java.util.Scanner;


public class User {
    Scanner scan = new Scanner(System.in);
    private int zebraCount;
    private int cheetahCount;

    //Default
    public User(){
        this.zebraCount = 0;
        this.cheetahCount = 0;
    }

    public int getZebraCount() {
        return zebraCount;
    }

    public void setZebraCount(int zebraCount) {
        if(zebraCount < 1){
            System.out.println("You must have at least 1 Zebra!\nHow many Zebras?");
            this.zebraCount = scan.nextInt();
        }else {
            this.zebraCount = zebraCount;
        }
    }

    public int getCheetahCount() {
        return cheetahCount;
    }

    public void setCheetahCount(int cheetahCount) {
        if(cheetahCount < 1){
            System.out.println("You must have at least 1 Cheetah!");
            this.cheetahCount = scan.nextInt();
        }
        else if(cheetahCount > getZebraCount()){
            System.out.println("Too many cheetahs!\nYou can't have more cheetahs than zebras!");
            this.cheetahCount = scan.nextInt();
        }else {
            this.cheetahCount = cheetahCount;
        }
    }

    public void animalCountInput(){
        System.out.println("How many Zebras?");
        setZebraCount(scan.nextInt());
        System.out.println("How many Cheetahs?");
        setCheetahCount(scan.nextInt());
    }
}
