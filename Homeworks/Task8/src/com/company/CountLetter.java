package com.company;

public class CountLetter implements Methodd {
    @Override
    public void handleEvent(char symbol, int[] count) {
        if (((int) symbol> 64 && (int) symbol < 91) || ((int) symbol > 96 && (int) symbol < 123)) {
            System.out.println("Введена буква " + symbol);
            count[(int)symbol]++;
        }
 //       else System.out.println("Не буква" + symbol);
    }
}
