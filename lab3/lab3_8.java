package lab3;
import java.util.Scanner;

public class lab3_8 {
    public static double m(int i) {
        double sum = 0;
        for (int k = 1; k <= i; k++) {
            double term = Math.pow(-1, k + 1) / (2 * k - 1);
            sum += term;
        }
        return 4 * sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        System.out.printf("%.4f\n", m(i));
    }
}