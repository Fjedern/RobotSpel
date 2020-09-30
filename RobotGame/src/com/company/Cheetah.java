package com.company;

public class Cheetah extends Animal{

    //Konstruktor
    public Cheetah(int x, int y){
        setCurrentX(x);
        setCurrentY(y);
        setSteps(3);
        setName('C');
        setHitTheWall(false); // Tillkommer
    }
}
