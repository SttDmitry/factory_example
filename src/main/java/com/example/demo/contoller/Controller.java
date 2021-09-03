package com.example.demo.contoller;

import com.example.demo.entity.Item;
import com.example.demo.factorry.Factory;
import com.example.demo.factorry.FactoryImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hello")
    public Item welcome() {
        Factory factory = new FactoryImpl();
        return factory.createItem();
    }
}
