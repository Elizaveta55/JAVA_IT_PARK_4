package com.company;

import java.lang.reflect.Method;
import java.util.Locale;

public class Parser implements Observable{
    String string;
    private Methodd[] methodds = new Methodd[3];
    private int count;

//    public Parser(Locale.Builder builder){
//
//    }
//
//    public static Locale.Builder builder(){
///        return new Locale.Builder();
//    }
//
//    public static class Builder {
//
//
//
//
//       public Parser build(){
//            return new Parser(this);
//        }
//    }

    @Override
    public void addMethodd(Methodd methodd) {
        methodds[count] = methodd;
        count++;
    }

    public void beforeEvent (String string, int[] countt){
        char array[] = string.toCharArray();
        for (int j = 0; j < array.length; j++) {
            event(array[j], countt);
        }
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
        for (int i=0;i<3;i++) {
                methodds[i].handleEvent(symbol, countt);
        }
    }
}
