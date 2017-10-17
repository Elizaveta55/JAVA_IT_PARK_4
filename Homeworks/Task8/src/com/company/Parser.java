package com.company;

import java.lang.reflect.Method;
import java.util.Locale;

public class Parser implements Observable {
    String string;
    private Methodd[] methodds = new Methodd[3];
    private int count;

//    public Parser(Builder builder){
//         this.methodds[0] = builder.methodd1;
//         this.methodds[1] = builder.methodd2;
//         this.methodds[2] = builder.methodd3;
//    }
//
//    public static Builder builder(){
//        return new Builder();
//    }
//
//    public static class Builder {
//          private Methodd[] methodds = new Methodd[3];
//
//    public Builder methodd1(Methodd methodd1){
//              this.methodds[0] = methodd1;
//              return this;
//    }
//    public Builder methodd2(Methodd methodd2){
//              this.methodds[1] = methodd2;
//              return this;
//    }
//    public Builder methodd3(Methodd methodd3){
//              this.methodds[2] = methodd3;
//              return this;
//    }
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
