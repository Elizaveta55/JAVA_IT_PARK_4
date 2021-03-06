package com.company;

import static java.lang.Math.PI;

public class Circle extends Shape {
    private int radius;

    public Circle(int radius){
        this.radius=radius;
    }

    public void Area(){
        System.out.print("Для круга");
        System.out.println(" найдем площадь:");
        System.out.println("Площадь фигуры можно найти по формуле - ");
        System.out.println("s = pi * r^2");
        System.out.println("где r - радиус");
        System.out.print("Для данного радиуса площадь - ");
        System.out.println(PI*this.radius*this.radius);
    }
}
