package com.company;

public class CountDigit implements Methodd {
    @Override
    public void handleEvent(char symbol) {
        if (((int) symbol > 47 && (int) symbol < 58)) {
            System.out.println("Введена цифра " + symbol);
        }
 //       else System.out.println("Не цифра" + symbol);
    }
}
