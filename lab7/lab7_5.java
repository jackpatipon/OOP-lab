package lab7;

class Address {
    protected String street;
    protected String city;

    public Address() {
        this.street = "";
        this.city = "";
    }

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressInfo() {
        return street + ", " + city;
    }
}

class Employee {
    protected int id;
    protected String name;
    protected double salary;
    protected Address address;

    public Employee() {
        this.id = 0;
        this.name = "";
        this.salary = 0.0;
        this.address = new Address();
    }

    public Employee(int id, String name, double salary, Address address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Address: " + (address != null ? address.getAddressInfo() : "None");
    }
}

class Manager extends Employee {
    protected String parkingNo;

    public Manager() {
        super();
        this.parkingNo = "";
    }

    public Manager(int id, String name, double salary, Address address, String parkingNo) {
        super(id, name, salary, address);
        this.parkingNo = parkingNo;
    }

    public String getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Parking No: " + parkingNo;
    }
}

public class lab7_5 {
    public static void main(String[] args) {
        Employee emp = new Manager();
        emp.setId(101);
        emp.setName("Alice");
        emp.setSalary(75000.0);
        emp.setAddress(new Address("123 Sukhumvit Rd", "Bangkok"));
        ((Manager) emp).setParkingNo("P-402");
        System.out.println(emp.getDetails());
    }
}
