package lab1;
import java.util.Scanner;
import java.lang.Math;

public class lab1_1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double fahrenheit = sc.nextDouble();
        double celsius = (5.0/9.0)*(fahrenheit-32.0);
        System.out.print(celsius);
    }
}