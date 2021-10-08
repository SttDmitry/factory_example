package com.example.demo.figures;

public class Circle implements Figure {
    private double radius;

    public Circle(double radius){
        this.radius=radius;
    }

    @Override
    public double getSurfaceSize() {
        return 3.14 * radius * radius;
    }
}
