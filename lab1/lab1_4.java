package lab1;

import java.util.Scanner;
import java.lang.Math;

public class lab1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = sc.nextDouble();
        double annualinterest = sc.nextDouble();
        double interest = balance*(annualinterest/1200);

        System.err.println(interest);
    }
}