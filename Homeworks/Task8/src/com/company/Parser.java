package com.company;

import java.lang.reflect.Method;

public class Parser implements Observable {
    String string;
    private Methodd[] methodds = new Methodd[3];
    private int count=0;

    public Parser(Builder builder){
         this.methodds = builder.methodds;
         this.count = builder.count;
    }

    public static class Builder {
        String string;
        private Methodd[] methodds = new Methodd[3];
        private int count=0;

    public Builder methoddAdd(Methodd methodd){
              this.methodds[count] = methodd;
              count++;
              return this;
    }
       public Parser build(){
            return new Parser(this);
        }

    }

    @Override
    public void addMethodd(Methodd methodd) {
        methodds[count] = methodd;
        count++;
    }

    public void beforeEvent (String string, int[] countt){
        char array[] = string.toCharArray();
        char word[] = new char[array.length];
        int mark = 0;
        int wordCount=0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == ' ' || j == array.length - 1) {
                for (int k = mark; k<= j; k++){
                    int temp=0;
                    word[temp] = array[k];
                    event(word[temp], countt);
                    temp++;
                }
                wordCount++;
//                event(word[j], countt);
                mark = j;
            }
        }
        System.out.println("Введено слов - " + wordCount);
        for (int i=0;i<124;i++)
        {
            if (countt[i]!=0) {
                System.out.print("Символ ");
                System.out.print((char)i );
                System.out.print(" встретилсь ");
                System.out.print(countt[i]);
                System.out.println(" раз");
            }
        }
    }


    @Override
    public void event(char symbol, int[] countt) {

    }

    public static Builder builder() {
        return new Builder();
    }
}
