package com.company;

public class Main {

    public static void main(String[] args) {
	  Circle circle = new Circle("Circle");
	  Parallelogram parallelogram = new Parallelogram("Parallelogram");
	  Triangle triangle = new Triangle("Triangle");
	  Rectangle rectangle = new Rectangle("Rectangle");

	  Shape figures[] = {circle, parallelogram, triangle, rectangle};

	  for (Shape figure: figures){
	      figure.Area();
      }
    }
}
