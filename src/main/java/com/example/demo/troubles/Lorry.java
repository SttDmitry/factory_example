package com.example.demo.troubles;

public class Lorry extends Car implements Moveable, Stopable {
    //Lorry not EXTENDS, but implements Moveable, Stopable and that's said - there was need of method called "open"
    public void move(){
        System.out.println("Car is moving");
    }

    public void stop(){
        System.out.println("Car is stop");
    }

    @Override
    void open() {
        System.out.println("Car is open");
    }
}
