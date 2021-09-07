package com.example.demo.entity;

public class ItemImpl implements Item{
    private long id;
    private String name;
    private int price;
    private static long counter;

    static {
        counter = 0;
    }

    public ItemImpl(){}

    public ItemImpl(int price, String name){
        this.price = price;
        this.name = name;
        this.id = counter++;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
