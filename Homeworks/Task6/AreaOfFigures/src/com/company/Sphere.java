package com.company;

import static java.lang.Math.PI;

public class Sphere extends Circle {
    private int radius;

    public Sphere(int radius) {
        super(radius);
        this.radius= radius;
    }

    public void Area(){
        System.out.print("Для шара");
        System.out.println(" найдем площадь:");
        System.out.println("Площадь фигуры можно найти по формуле - ");
        System.out.println("s = 4* pi * r^2");
        System.out.println("где r - радиус");
        System.out.print("Для данного радиуса площадь - ");
        System.out.println(4 * PI * this.radius * this.radius);
    }

}
