package com.example.demo.list;

import java.util.List;

public interface MyList<T> {
    void add(T item);
    T remove(int index);
    T remove(T item);
    int indexOf(T item);
    int size();
}
