package com.example.demo.entity.Mediator;

public class Tuner extends Music implements Button,Turner {
    Music music = new Music();
    @Override
    public void press() {
        if (music.isActive()){
            music.switchOff();
        } else {
            music.switchOn();
        }
    }

    @Override
    public void turnRight() {
        music.increaseVolume();
    }

    @Override
    public void turnLeft() {
        music.decreaseVolume();
    }
}
