package com.company;

import static com.company.TextViewer.text;

public class findAllLitters extends WorkWithThread implements Task{
//    public void run(){
//        HandleEvent(text);
//    }

    @Override
    public void HandleEvent(String text) {
        char litters[] = text.toCharArray();
        int count = 0;
        for (int i = 0; i < litters.length; i ++){
            if (((int) litters[i] > 64 && (int) litters[i] < 91) || ((int) litters[i] > 96 && (int) litters[i] < 123)) {
                System.out.println("Введена буква " + litters[i]);
                count++;
            }
            }
        System.out.println("Введено " + count + " букв");
    }
}
