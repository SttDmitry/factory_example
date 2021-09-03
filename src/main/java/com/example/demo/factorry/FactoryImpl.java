package com.example.demo.factorry;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemImpl;

public class FactoryImpl implements Factory{

    @Override
    public Item createItem() {
        return new ItemImpl(11, "apple");
    }
}
