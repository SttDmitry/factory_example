package com.example.demo.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hw3 {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';
    private static int count = 0;
    public static Lock lock = new ReentrantLock();


    public static void main(String[] args) {
        Hw3 w = new Hw3();

        Thread t1 = new Thread(() -> {
            w.printPing();
        });
        Thread t2 = new Thread(() -> {
            w.printPong();
        });
        t1.start();
        t2.start();

        Thread t3 = new Thread(() -> {
            for (int i = 0; i<10; i++){
                try {
                    lock.lock();
                    w.countUp();
                    System.out.println(getCount());
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i<10; i++){
                try {
                    lock.lock();
                    w.countUp();
                    System.out.println(getCount());
                } finally {
                    lock.unlock();
                }
            }
        });
        t3.start();
        t4.start();
    }

    public void printPing() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        mon.wait();
                    }
                    System.out.print("Ping\n");
                    currentLetter = 'B';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printPong() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        mon.wait();
                    }
                    System.out.print("Pong\n");
                    currentLetter = 'A';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void countUp(){
        count++;
    }

    public static int getCount(){
        return count;}
}
