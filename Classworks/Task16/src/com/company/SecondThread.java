package com.company;

public class SecondThread extends Thread {
    public SecondThread(ThreadGroup group){
        super(group, "Chicken");
    }

    public void run() {
        for (int i=0;i<100;i++) {
            System.out.println("Chicken");
        }
    }
}
