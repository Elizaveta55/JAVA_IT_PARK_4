package ru.itpark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        cars car1= new cars();
        cars car2= new cars();
        cars car3= new cars();

        cars car[]={car1, car2, car3};
	    for (int i=0;i<3;i++){
	        car[i] = new cars();
            System.out.println("Enter number");
            car[i].number = scanner.nextInt();
            System.out.println("Enter color");
            car[i].color = scanner.next();
            System.out.println("Enter power");
            car[i].power = scanner.nextInt();
            car[i].power = scanner.nextInt();
        }
        for (int i=0;i<3-1;i++){
            for (int j=i+1;j<3;j++){
                if (car[i].power>car[j].power){
                    cars temp=car[j];
                    car[j]=car[i];
                    car[i]=temp;
                }
            }
        }
        for (int i=0;i<3;i++) {
            System.out.println(car[i].number + " " + car[i].power);
            //System.out.println(car[i].number + ' ' + car[i].power);
        }
    }
}
