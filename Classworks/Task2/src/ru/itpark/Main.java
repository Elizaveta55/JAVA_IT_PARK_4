package ru.itpark;
import static java.lang.Math.*;
public class Main {

    public static double f(double x) {
        return sin(x);
    }

    public static double integrate(double a, double b, int n) {
        double h = abs(a - b) / (double)(n);
        double s=0;
        for (double x=a;x<=b;x=x+h) {
            s=s+f(x)*h;
        }
        return s;
    }

    public static void main(String[] args) {
        double in=integrate(0.1, PI,100000);
        System.out.println(in);
    }
}
