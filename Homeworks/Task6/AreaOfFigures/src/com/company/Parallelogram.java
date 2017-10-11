package com.company;

public class Parallelogram extends Shape {
    private String name;

    public Parallelogram(String name){
        this.name=name;
    }

    public void Area(){
        System.out.print("Для ");
        System.out.print(name);
        System.out.println(" найдем площадь:");
        System.out.println("Площадь фигуры можно найти по формуле - ");
        System.out.println("s = a * h");
        System.out.println("a - основание");
        System.out.println("h - высота");
        System.out.println();
    }
}
