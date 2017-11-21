package com.company;

import static com.company.TextViewer.text;

public abstract class WorkWithThread implements Task{
//    public void threadEvent (String text) {
//        Thread newTask = new Thread();
//        newTask.start();
//    }

    public void threadEvent(String text) {
        new Thread(() -> HandleEvent(text)).start();
    }

    public abstract void HandleEvent(String text);
//    public abstract void addTask(Task task);
}
