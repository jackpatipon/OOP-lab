package lab2;

import java.util.Scanner;
import java.lang.Math;
import java.util.Date;

class Account{
    private int id;
    private double balance, annualInterestRate;
    private Date dateCreated;

    Account(){
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();

    }
    Account(int id, double balance){
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    int get_id(){
        return this.id;
    }
    double get_balance(){
        return this.balance;
    }
    double get_annualInterestRate(){
        return this.annualInterestRate;
    }
    Date get_dateCreated(){
        return this.dateCreated;
    }
    void set_id(int x){
        this.id = x;
    }
    void set_balance(double x){
        this.balance = x;
    }
    void set_annualInterestRate(double x){
        this.annualInterestRate = x;
    }
    void set_dateCreated(Date x){
        this.dateCreated = x;
    }

    double getMonthlyInterestRate(){
        return annualInterestRate/12.0;
    }
    double getMonthlyInterest(){
        return balance*(getMonthlyInterestRate()/100.0);
    }
    void withdraw(double value){
        balance -= value;
    }
    void deposit(double value){
        balance += value;
    }
}

public class lab2_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account guest1 = new Account(1122, 20000);
        guest1.set_annualInterestRate(4.5);
        guest1.withdraw(2500);
        guest1.deposit(3000);
        System.out.println(guest1.get_balance());
        System.out.println(guest1.getMonthlyInterestRate());
        System.out.println(guest1.getMonthlyInterest());
    }
}