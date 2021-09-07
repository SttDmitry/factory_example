package com.example.demo.utility;

import com.example.demo.entity.DocItem;
import com.example.demo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;

public class DocAdapter implements Item {
    private DocItem docItem;

    @Autowired
    public void setDocItem(DocItem docItem){
        this.docItem=docItem;
    }


    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public String getName() {
        return docItem.getName() + docItem.getInfo();
    }
}
