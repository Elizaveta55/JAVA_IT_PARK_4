package com.company;

public class Circle extends Shape {
    private String name;

    public Circle(String name){
        this.name=name;
    }

    public void Area(){
        System.out.print("Для ");
        System.out.print(name);
        System.out.println(" найдем площадь:");
        System.out.println("Площадь фигуры можно найти по формуле - ");
        System.out.println("s = pi * r^2");
        System.out.println("где r - радиус");
        System.out.println();
    }
}
