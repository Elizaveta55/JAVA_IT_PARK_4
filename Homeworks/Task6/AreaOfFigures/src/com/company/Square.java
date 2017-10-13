package com.company;

public class Square extends Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public void Area(){
        System.out.print("Для квадрата");
        System.out.println(" найдем площадь:");
        System.out.print("Площадь фигуры примерна равна - ");
        System.out.println("s = a * а");
        System.out.println("a - длина");
        System.out.print("Для данных параметров площадь - ");
        System.out.println(this.side*this.side);
    }

}
