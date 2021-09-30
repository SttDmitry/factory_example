package com.example.demo.entity.Mediator;

public class Music {
    private int volume;
    private boolean active;

    void increaseVolume(){
        volume++;
    }

    void decreaseVolume(){
        volume--;
    }

    boolean isActive(){
        return active;
    }

    void switchOn(){
        active = true;
    }

    void switchOff(){
        active = false;
    }
}
