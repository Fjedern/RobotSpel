package com.company;

public class Zebra extends Animal implements setup {


    //Konstructor
    public Zebra(int x, int y){
        setCurrentX(x);
        setCurrentY(y);
        setup();
    }

    /*@Override
    public int getCurrentX() {
        return super.getCurrentX();
    }*/

    @Override
    public void setup(){
        setSteps(5);
        setName('Z');
    }
}
