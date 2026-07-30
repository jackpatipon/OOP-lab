package lab1;
import java.util.Scanner;

public class lab1_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double max = Double.MIN_VALUE;
        int count = 0;

        while (true) {
            double num = scanner.nextDouble();

            if (num == 0) {
                break;
            }
            if (num > max) {
                max = num;
                count = 1;
            }
            else if (num == max) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println(max + " " + count);
        }
    }
}