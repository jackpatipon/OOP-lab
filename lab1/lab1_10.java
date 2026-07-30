package lab1;

import java.util.Scanner;

public class lab1_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double xc = scanner.nextDouble();
        double yc = scanner.nextDouble();
        double r = scanner.nextDouble();
        double v = scanner.nextDouble();

        int n = scanner.nextInt();

        double[][] house = new double[n][2];
        boolean[] affected = new boolean[n];

        for (int i = 0; i < n; i++) {
            house[i][0] = scanner.nextDouble();
            house[i][1] = scanner.nextDouble();
            affected[i] = false;
        }

        int totalAffectedHouses = 0;

        while (v >= 1.0) {
            for (int i = 0; i < n; i++) {
                if (!affected[i]) {
                    double dx = house[i][0] - xc;
                    double dy = house[i][1] - yc;
                    if (dx * dx + dy * dy <= r * r) {
                        affected[i] = true;
                        totalAffectedHouses++;
                    }
                }
            }

            xc -= v * 1.0;

            r -= r * 0.2;
            v -= v * 0.2;
        }

        System.out.println(totalAffectedHouses);

        scanner.close();
    }
}
