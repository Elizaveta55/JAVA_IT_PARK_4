package com.company;

public class Parallelogram extends Square {
    private int side;
    private int h;

    public Parallelogram(int side, int h) {
        super(side);
        this.side = side;
        this.h = h;
    }

    public void Area(){
        System.out.print("Для параллелограмма");
        System.out.println(" найдем площадь:");
        System.out.println("Площадь фигуры можно найти по формуле - ");
        System.out.println("s = a * h");
        System.out.println("a - основание");
        System.out.println("h - высота");
        System.out.print("Для данных параментров площадь - ");
        System.out.println(this.side * this.h);
    }
}
