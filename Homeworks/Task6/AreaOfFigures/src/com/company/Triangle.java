package com.company;

public class Triangle extends Shape {
    private String name;

    public Triangle(String name){
        this.name=name;
    }

    public void Area(){
        System.out.print("Для ");
        System.out.print(name);
        System.out.println(" найдем площадь:");
        System.out.print("Площадь фигуры можно найти по формуле - ");
        System.out.println(" s = 1/2 * a * h");
        System.out.println("a - основание треугольника");
        System.out.println("h - высота треугольника");
        System.out.println();
    }
}
