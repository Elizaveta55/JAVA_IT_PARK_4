package com.company;

public class MyThread extends Thread {
    public MyThread(ThreadGroup group) {
        super(group, "Egg");
    }

    public void run() {
        for (int i=0;i<100;i++) {
            System.out.println("Egg");
        }
    }
}