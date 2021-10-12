package com.example.demo.list;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T>, MyList<T>{
    private Node first;
    private Node last;

    private int size;

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    public ListIterator<T> listiterator() {
        return new ListIter();
    }

    private class Iter implements Iterator<T> {
        Node current = new Node(last,null, null);
        int index = size;
        boolean nextPoint = false;
        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            nextPoint = true;
            index++;
            current = current.getNext();
            return current.getValue();
        }
    }

    private class ListIter extends Iter implements ListIterator<T> {


        @Override
        public boolean hasPrevious() {
            return current.getPrev() != null;
        }

        @Override
        public T previous() {
            nextPoint = false;
            index--;
            current = current.getPrev();
            return current.getValue();
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index-1;
        }


        @Override
        public void remove() {
            if (nextPoint) {
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
                size--;
            } else if (!nextPoint && current.getNext().getNext() == null) {
                current.setNext(null);
            } else if (!nextPoint && hasNext()) {
                current.getNext().getNext().setPrev(current);
                current.setNext(current.getNext().getNext());
            }
        }

        @Override
        public void set(T t) {
            if (nextPoint) {
                current.setValue(t);
            } else {
                current.getNext().setValue(t);
            }
        }

        @Override
        public void add(T item) {
            if (nextPoint) {
                Node newNode = new Node (current, item, current.getNext());
                current.setNext(newNode);
                newNode.getNext().setPrev(newNode);
                current = newNode;
            } else {
                Node newNode = new Node (current, item, current.getNext());
                current.setNext(newNode);
                newNode.getNext().setPrev(newNode);
            }
        }
    }

    private class Node {
        Node prev;
        T value;
        Node next;

        public Node(Node prev, T value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    public void insertFirst(T item) {
        Node newNode = new Node(item, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public T removeFirst() {
        T temp = getFirst();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return temp;
    }

    public void insertLast(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.setPrev(last);
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public T removeLast() {
        T temp = getLast();
        if (last.getPrev() == null) {
            first = null;
        } else {
            last.getPrev().setNext(null);
        }
        last = last.getPrev();
        size--;
        return temp;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty");
        }
        return first.value;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty");
        }
        return last.value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public final int indexOf(T item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.value.equals(item)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    public void insert(int index, T item) {
        if (index < 0 || index > size) {
            throw new IllegalStateException("index: " + index);
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        if (index == size) {
            insertLast(item);
            return;
        }

        Node current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.getNext();
            i++;
        }
        Node newNode = new Node(current, item, current.getNext());
        current.getNext().setPrev(newNode);
        current.setNext(newNode);
        size++;
    }

    @Override
    public void add(T item) {
        insertLast(item);
    }

    @Override
    public boolean remove(int index) {
        if (size < index) return false;
        else
        {
            Node current = first;
            int i = 0;
            while (i < index ) {
                current = current.getNext();
                i++;
            }
            remove(current.value);
            return true;
        }
    }

    public boolean remove(T item) {
        if (isEmpty()) {
            return false;
        }
        if (first.value.equals(item)) {
            removeFirst();
            return true;
        }

        Node current = first;
        while (current != null && !current.getValue().equals(item)) {
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            removeLast();
            return true;
        }

        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = first;
        while (current != null) {
            sb.append(current.value).append(", ");
            current = current.getNext();
        }
        if (!isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }
}
