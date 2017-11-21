package com.company;

import static com.company.TextViewer.text;

public class findAllPunctuationMarks extends WorkWithThread implements Task{
    public void run(){
        HandleEvent(text);
    }

    @Override
    public void HandleEvent(String text) {
        char litters[] = text.toCharArray();
        int count = 0;
        for (int i = 0; i < litters.length; i ++){
            if ((int) litters[i] > 31 && (int) litters[i] < 48) {
                System.out.println("Введен знак препинания " + litters[i]);
                count++;
            }
        }
        System.out.println("Введено " + count + " знаков препинания");
    }
}
