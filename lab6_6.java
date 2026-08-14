package week;

import java.util.Scanner;
import java.lang.Math;

class Date{
    private int day;
    private String month;
    private int year;
    public Date(){
        this.day = 1;
        this.month = "January";
        this.year = 1;
    }
    public Date(int day, String month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public int getDay() {return day;}
    public void setDay(int day) {this.day = day;}
    public String getMonth() {return month;}
    public void setMonth(String month) {this.month = month;}
    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}
}

class Person{
    private String name;
    private String surname;
    private int age;
    private Date bDate;
    public Person(){
        this.name = "guest";
        this.surname = "guest";
        this.age = 0;
        this.bDate = new Date();
    }
    public Person(String name, String surname, int age, Date bDate) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bDate = bDate;
    }
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public int getAge() {return age;}
    public Date getbDate() {return bDate;}
}

class Account{
    private int id;
    private Person objPerson;
    private double balance, annualInterestRate;
    private Date dateCreated;

    Account(){
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

class SavingAccount extends Account{
    
}
class FixAccount extends Account{
    
}

public class lab6_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Account guest1 = new Account(1122, 20000);
//        guest1.set_annualInterestRate(4.5);
//        guest1.withdraw(2500);
//        guest1.deposit(3000);
//        System.out.println(guest1.get_balance());
//        System.out.println(guest1.getMonthlyInterestRate());
//        System.out.println(guest1.getMonthlyInterest());
    }
}
