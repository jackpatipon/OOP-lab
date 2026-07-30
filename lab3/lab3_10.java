package lab3;
import java.util.Scanner;

public class lab3_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        double[] shipStart = new double[N];
        double[] shipEnd = new double[N];

        for (int i = 0; i < N; i++) {
            shipStart[i] = sc.nextDouble();
            shipEnd[i] = sc.nextDouble();
        }

        double[] lightX = new double[M];
        for (int j = 0; j < M; j++) {
            lightX[j] = sc.nextDouble();
        }

        int count = 0;

        for (int j = 0; j < M; j++) {
            double lx = lightX[j];
            for (int i = 0; i < N; i++) {
                double minX = Math.min(shipStart[i], shipEnd[i]);
                double maxX = Math.max(shipStart[i], shipEnd[i]);

                if (lx > minX && lx < maxX) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}