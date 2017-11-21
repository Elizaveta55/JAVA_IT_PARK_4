package com.company;

import static com.company.TextViewer.text;

public class findAllNumeral extends WorkWithThread implements Task{
    public void run(){
        HandleEvent(text);
    }

    @Override
    public void HandleEvent(String text) {
        char litters[] = text.toCharArray();
        int count = 0;
        for (int i = 0; i < litters.length; i ++){
            if (((int) litters[i] > 47 && (int) litters[i] < 58)) {
                System.out.println("Введена цифра " + litters[i]);
                count++;
            }
        }
        System.out.println("Введено " + count + " цифр");
    }
}
