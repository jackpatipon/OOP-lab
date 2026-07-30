package lab1;
import java.util.Scanner;
import java.lang.Math;

public class lab1_2 {
    public static void main(String[] args) {
        double money = 100;
        double new_money = 0;

        for(int i=0; i<6; i++){
            new_money = (money+new_money)*(1+0.00417);
        }
        money = new_money;

        System.out.print(money);
    }
}