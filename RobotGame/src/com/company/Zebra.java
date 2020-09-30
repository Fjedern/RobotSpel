package com.company;

public class Zebra extends Animal {

    //Konstructor
    public Zebra(int x, int y){
        setCurrentX(x);
        setCurrentY(y);
        setSteps(5);
        setName('Z');
        setHitTheWall(false); // Tillkommer
    }

    /*@Override
    public int getCurrentX() {
        return super.getCurrentX();
    }*/
}
