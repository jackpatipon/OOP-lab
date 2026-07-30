package lab2;
import java.util.Scanner;

public class lab2_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter r1's center x-, y-coordinates, width, and height: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double w1 = input.nextDouble();
        double h1 = input.nextDouble();

        System.out.print("Enter r2's center x-, y-coordinates, width, and height: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double w2 = input.nextDouble();
        double h2 = input.nextDouble();

        double xDistance = x2 - x1;
        if (xDistance < 0) {
            xDistance = -xDistance;
        }

        double yDistance = y2 - y1;
        if (yDistance < 0) {
            yDistance = -yDistance;
        }

        // เช็คว่า r2 อยู่ข้างใน r1 ทั้งหมดหรือไม่
        if (xDistance <= (w1 - w2) / 2 && yDistance <= (h1 - h2) / 2) {
            System.out.println("r2 is inside r1");
        }
        else if (xDistance <= (w1 + w2) / 2 && yDistance <= (h1 + h2) / 2) {
            System.out.println("r2 overlaps r1");
        }
        else {
            System.out.println("r2 does not overlap r1");
        }
    }
}