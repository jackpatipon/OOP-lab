package lab1;

import java.util.Scanner;
import java.lang.Math;

public class lab1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

        double side1 = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
        double side2 = Math.sqrt(Math.pow(x2-x3,2)+Math.pow(y2-y3,2));
        double side3 = Math.sqrt(Math.pow(x3-x1,2)+Math.pow(y3-y1,2));
        double s = (side1+side2+side3)/2;
        double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
        System.err.println(area);
    }
}