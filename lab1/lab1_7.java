package lab1;

import java.util.Scanner;
import java.lang.Math;

public class lab1_7 {
    public static double calculateSum(double x, int n) {
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += Math.pow(x, i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int n = scanner.nextInt();

        if (n < 0) {
            return;
        } else {
            double result = calculateSum(x, n);
            System.out.println(result);
        }
    }
}