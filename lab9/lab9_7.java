package lab9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Date {
    private int day;
    private String month;
    private int year;

    public Date() {
        this.day = 1;
        this.month = "January";
        this.year = 2000;
    }

    public Date(int day, String month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return day + " " + month + " " + year;
    }
}

class Person {
    private String name;
    private String surname;
    private int age;
    private Date bDate;

    public Person() {
        this.name = "";
        this.surname = "";
        this.age = 0;
        this.bDate = new Date();
    }

    public Person(String name, String surname, int age, Date bDate) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bDate = bDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBDate() {
        return bDate;
    }

    public void setBDate(Date bDate) {
        this.bDate = bDate;
    }
}

class Account {
    private int id;
    private Person objPerson;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account() {
        this.dateCreated = new Date();
    }

    public Account(int id, double balance, double annualInterestRate, Person person, Date dateCreated) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.objPerson = person;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getObjPerson() {
        return objPerson;
    }

    public void setObjPerson(Person objPerson) {
        this.objPerson = objPerson;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}

public class lab9_7 extends JFrame {
    private JTextField txtId = new JTextField(10);
    private JTextField txtMoney = new JTextField(10);
    private JTextField txtInterest = new JTextField(10);
    private JComboBox<Integer> cbOpenDay;
    private JComboBox<String> cbOpenMonth;
    private JComboBox<Integer> cbOpenYear;
    private JTextField txtFirstName = new JTextField(15);
    private JTextField txtLastName = new JTextField(15);
    private JComboBox<Integer> cbBirthDay;
    private JComboBox<String> cbBirthMonth;
    private JComboBox<Integer> cbBirthYear;
    private JTextField txtAge = new JTextField(5);

    private JButton btnSave = new JButton("SAVE");
    private JButton btnShow = new JButton("SHOW");

    private ArrayList<Account> accountList = new ArrayList<>();

    public lab9_7() {
        setTitle("Show Detail of Account ...");

        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        Integer[] days = new Integer[31];
        for (int i = 0; i < 31; i++) {
            days[i] = i + 1;
        }
        Integer[] openYears = new Integer[30];
        for (int i = 0; i < 30; i++) {
            openYears[i] = 2000 + i;
        }
        Integer[] birthYears = new Integer[100];
        for (int i = 0; i < 100; i++) {
            birthYears[i] = 1930 + i;
        }

        cbOpenDay = new JComboBox<>(days);
        cbOpenMonth = new JComboBox<>(months);
        cbOpenYear = new JComboBox<>(openYears);

        cbBirthDay = new JComboBox<>(days);
        cbBirthMonth = new JComboBox<>(months);
        cbBirthYear = new JComboBox<>(birthYears);

        JPanel pForm = new JPanel(new GridBagLayout());
        pForm.setBorder(BorderFactory.createTitledBorder("Enter Data Account Money"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pForm.add(new JLabel("ID :"), gbc);
        gbc.gridx = 1;
        pForm.add(txtId, gbc);
        gbc.gridx = 2;
        pForm.add(new JLabel("MONEY :"), gbc);
        gbc.gridx = 3;
        pForm.add(txtMoney, gbc);
        gbc.gridx = 4;
        pForm.add(new JLabel("BATH"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pForm.add(new JLabel("ANNUALINTERATE RATE :"), gbc);
        gbc.gridx = 1;
        pForm.add(txtInterest, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pForm.add(new JLabel("DAY OPEN ACCOUNT :"), gbc);
        JPanel pOpenDate = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 0));
        pOpenDate.add(new JLabel("day"));
        pOpenDate.add(cbOpenDay);
        pOpenDate.add(new JLabel("month"));
        pOpenDate.add(cbOpenMonth);
        pOpenDate.add(new JLabel("year"));
        pOpenDate.add(cbOpenYear);
        gbc.gridx = 1;
        gbc.gridwidth = 4;
        pForm.add(pOpenDate, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        pForm.add(new JLabel("FIRST NAME :"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        pForm.add(txtFirstName, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 4;
        pForm.add(new JLabel("LAST NAME :"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        pForm.add(txtLastName, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 5;
        pForm.add(new JLabel("BIRTH DAY :"), gbc);
        JPanel pBirthDate = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 0));
        pBirthDate.add(new JLabel("day"));
        pBirthDate.add(cbBirthDay);
        pBirthDate.add(new JLabel("month"));
        pBirthDate.add(cbBirthMonth);
        pBirthDate.add(new JLabel("year"));
        pBirthDate.add(cbBirthYear);
        gbc.gridx = 1;
        gbc.gridwidth = 4;
        pForm.add(pBirthDate, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 6;
        pForm.add(new JLabel("AGE :"), gbc);
        gbc.gridx = 1;
        pForm.add(txtAge, gbc);
        gbc.gridx = 2;
        pForm.add(new JLabel("YEAR"), gbc);

        JPanel pButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pButtons.add(btnSave);
        pButtons.add(btnShow);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAccount();
            }
        });

        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAccounts();
            }
        });

        setLayout(new BorderLayout());
        JLabel lblTitle = new JLabel("ACCOUNT MONEY", JLabel.CENTER);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
        add(lblTitle, BorderLayout.NORTH);
        add(pForm, BorderLayout.CENTER);
        add(pButtons, BorderLayout.SOUTH);
    }

    private void saveAccount() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            double money = Double.parseDouble(txtMoney.getText().trim());
            double rate = Double.parseDouble(txtInterest.getText().trim());
            int age = Integer.parseInt(txtAge.getText().trim());

            int oDay = (Integer) cbOpenDay.getSelectedItem();
            String oMonth = (String) cbOpenMonth.getSelectedItem();
            int oYear = (Integer) cbOpenYear.getSelectedItem();
            Date openDate = new Date(oDay, oMonth, oYear);

            int bDay = (Integer) cbBirthDay.getSelectedItem();
            String bMonth = (String) cbBirthMonth.getSelectedItem();
            int bYear = (Integer) cbBirthYear.getSelectedItem();
            Date birthDate = new Date(bDay, bMonth, bYear);

            Person person = new Person(txtFirstName.getText().trim(), txtLastName.getText().trim(), age, birthDate);
            Account account = new Account(id, money, rate, person, openDate);

            accountList.add(account);
            JOptionPane.showMessageDialog(this, "Account saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid information.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showAccounts() {
        if (accountList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No accounts saved yet.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Account acc : accountList) {
            sb.append("ID: ").append(acc.getId()).append("\n");
            sb.append("Name: ").append(acc.getObjPerson().getName()).append(" ").append(acc.getObjPerson().getSurname()).append("\n");
            sb.append("Age: ").append(acc.getObjPerson().getAge()).append("\n");
            sb.append("Birth Day: ").append(acc.getObjPerson().getBDate()).append("\n");
            sb.append("Balance: ").append(acc.getBalance()).append(" BATH\n");
            sb.append("Interest Rate: ").append(acc.getAnnualInterestRate()).append("%\n");
            sb.append("Open Date: ").append(acc.getDateCreated()).append("\n");
            sb.append("------------------------------------\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Saved Account Details", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        lab9_7 frame = new lab9_7();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
