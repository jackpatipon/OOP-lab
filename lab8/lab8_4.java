package lab8;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

abstract class Employee {
    private String firstname;
    private String lastname;
    private String id;

    public Employee(String firstname, String lastname, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getId() {
        return id;
    }

    public abstract double earning();

    public abstract double bonus(int year);
}

class SalariedEmployee extends Employee {
    private double salary;

    public SalariedEmployee(String firstname, String lastname, String id, double sal) {
        super(firstname, lastname, id);
        this.salary = sal;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double bonus(int year) {
        if (year > 5) {
            return salary * 12;
        } else {
            return salary * 6;
        }
    }

    @Override
    public double earning() {
        return salary - (salary * 0.05);
    }
}

class ComEmployee extends Employee {
    private double grossSale;
    private double ComRate;

    public ComEmployee(String firstname, String lastname, String id, double sales, double percent) {
        super(firstname, lastname, id);
        this.grossSale = sales;
        this.ComRate = percent;
    }

    public double getGrossSale() {
        return grossSale;
    }

    public void setGrossSale(double grossSale) {
        this.grossSale = grossSale;
    }

    public double getComRate() {
        return ComRate;
    }

    public void setComRate(double comRate) {
        this.ComRate = comRate;
    }

    @Override
    public double bonus(int year) {
        if (year > 5) {
            return grossSale * 6;
        } else {
            return grossSale * 3;
        }
    }

    @Override
    public double earning() {
        return grossSale + (grossSale * ComRate);
    }
}

public class lab8_4 {
    public static void printEmp(ArrayList<Employee> a) {
        double[] arrayEarn = new double[a.size()];
        double[] arrayBonus = new double[a.size()];

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-15s %-15s %-15s %-15s\n", "First name", "Last name", "Earning", "Bonus"));
        sb.append("-------------------------------------------------------------\n");

        for (int i = 0; i < a.size(); i++) {
            Employee r = a.get(i);
            arrayEarn[i] = r.earning();
            arrayBonus[i] = r.bonus(6);
            sb.append(String.format("%-15s %-15s %-15.2f %-15.2f\n", r.getFirstname(), r.getLastname(), arrayEarn[i], arrayBonus[i]));
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Employee Report", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new SalariedEmployee("John", "Doe", "S001", 30000));
        list.add(new SalariedEmployee("Jane", "Smith", "S002", 45000));
        list.add(new ComEmployee("Bob", "Johnson", "C001", 100000, 0.10));
        list.add(new ComEmployee("Alice", "Brown", "C002", 150000, 0.15));

        printEmp(list);
    }
}
