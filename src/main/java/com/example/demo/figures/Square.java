package com.example.demo.figures;

public class Square implements Figure {
    private double side;

    public Square(double side){
        this.side = side;
    }

    @Override
    public double getSurfaceSize() {
        return side * side;
    }
}
