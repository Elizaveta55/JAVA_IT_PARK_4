package com.company;

public class CountSpace implements Methodd {
    @Override
    public void handleEvent(char symbol, int[] count) {
        if ((int)symbol == 32){
            System.out.println("Введен пробел ");
            count[(int)symbol]++;
        }
 //       else System.out.println("Не пробел" + symbol);
    }
}
