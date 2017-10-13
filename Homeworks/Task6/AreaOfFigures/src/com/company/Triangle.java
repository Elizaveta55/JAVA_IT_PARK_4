package com.company;

public class Triangle extends Square {
    private int side;
    private int h;

    public Triangle(int side, int h) {
        super(side);
        this.side = side;
        this.h = h;
    }

    public void Area(){
        System.out.print("Для треугольника");
        System.out.println(" найдем площадь:");
        System.out.print("Площадь фигуры можно найти по формуле - ");
        System.out.println(" s = 1/2 * a * h");
        System.out.println("a - основание треугольника");
        System.out.println("h - высота треугольника");
        System.out.println("Для данных параметров площадь - ");
        System.out.println(0.5 * this.side * this.h);
    }
}
