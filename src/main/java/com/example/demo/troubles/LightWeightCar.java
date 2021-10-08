package com.example.demo.troubles;

public class LightWeightCar extends Car implements Moveable {
    //LightWeightCar is clone of Lorry with less functions, so i think it's needed to be removed

    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

}
