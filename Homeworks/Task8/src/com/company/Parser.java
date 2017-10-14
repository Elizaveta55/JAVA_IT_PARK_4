package com.company;

import java.lang.reflect.Method;

public class Parser implements Observable{
    String string;
    private Methodd[] methodds = new Methodd[3];
    private int count;

    @Override
    public void addMethodd(Methodd methodd) {
        methodds[count] = methodd;
        count++;
    }

    public void beforeEvent (String string){
        char array[] = string.toCharArray();
        for (int j = 0; j < array.length; j++) {
            event(array[j]);
        }
    }


    @Override
    public void event(char symbol) {
        for (int i=0;i<3;i++) {
                methodds[i].handleEvent(symbol);
        }
    }
}
