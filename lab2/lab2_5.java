package lab2;

import java.util.Scanner;
import java.lang.Math;

class LinearEquation{
    private double a,b,c,d,e,f;
    LinearEquation(double a, double b, double c, double d, double e, double f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    double[] get_element(){
        return new double[] {this.a, this.b, this.c, this.d, this.e, this.f};
    }
    boolean isSolvable(){
        return (a*d-b*c != 0)?true:false;
    }
    double getX(){
        //if(isSolvable()){
            return (e*d-b*f)/(a*d-b*c);
        //}
    }
    double getY(){
        //if(isSolvable()){
            return (a*f-e*c)/(a*d-b*c);
        //}
    }
}

public class lab2_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a b c d e f: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        double e = sc.nextDouble();
        double f = sc.nextDouble();
        LinearEquation L = new LinearEquation(a, b, c, d, e, f);
        if(L.isSolvable()){
            System.out.print("x is "+L.getX()+" and y is "+L.getY());
        }
        else{
            System.err.print("The equation has no solution");
        }
    }
}