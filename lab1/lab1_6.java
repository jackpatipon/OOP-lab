package lab1;

import java.util.Scanner;
import java.lang.Math;

public class lab1_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();

        for(int i=1; i<=row; i++){
            for(int j=1; j<=column; j++){
                System.err.print(i*j+"\t");
            }
            System.err.println();
        }
    }
}