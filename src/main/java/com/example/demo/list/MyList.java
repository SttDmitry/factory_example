package com.example.demo.list;

public interface MyList<T> {
    void add(T item);
    boolean remove(int index);
    boolean remove(T item);
    int indexOf(T item);
    int size();
}
