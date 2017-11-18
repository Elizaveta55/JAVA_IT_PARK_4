package com.company;

public class Main {

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("Quastion");
        MyThread thread1 = new MyThread(group);
        SecondThread thread2 = new SecondThread(group);
        thread1.start();
        thread2.start();

        ShowHuman thread = new ShowHuman();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new IllegalArgumentException();
        }
    }
}
