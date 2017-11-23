package com.company;

import static com.company.TextViewer.text;

public abstract class WorkWithThread implements Task{

    public void threadEvent(String text) {
       // new Thread(() -> HandleEvent(text)).start();
        new Thread(this).start();
    }

    public abstract void HandleEvent(String text);
    public void run(){
        HandleEvent(text);
    };
}
