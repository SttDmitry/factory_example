package com.example.demo.figures;

public class Triangle implements Figure {
    private double h;
    private double side;

    public Triangle(double h, double side){
        this.h = h;
        this.side = side;
    }

    @Override
    public double getSurfaceSize() {
        return 0.5 * h * side;
    }
}
