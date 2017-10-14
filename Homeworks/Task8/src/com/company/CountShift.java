package com.company;

public class CountShift implements Methodd {
    @Override
    public void handleEvent(char symbol) {
        if ((int)symbol == 32){
            System.out.println("Введен пробел ");
        }
 //       else System.out.println("Не пробел" + symbol);
    }
}
