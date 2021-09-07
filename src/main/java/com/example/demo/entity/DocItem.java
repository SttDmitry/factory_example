package com.example.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class DocItem {
    private String name;
    private String info;

    public DocItem(){}

    public DocItem(String name, String info){
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}
