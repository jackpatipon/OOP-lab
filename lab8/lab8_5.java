package lab8;

abstract class GeometricObject {
    private String color = "white";
    private boolean filled;

    protected GeometricObject() {
    }

    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}

class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            return this.radius == ((Circle) obj).radius;
        }
        return false;
    }

    @Override
    public int compareTo(Circle o) {
        return Double.compare(this.radius, o.radius);
    }
}

class Rectangle extends GeometricObject implements Comparable<Rectangle> {
    private double width;
    private double height;

    public Rectangle() {
        this(1.0, 1.0);
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rectangle) {
            return this.getArea() == ((Rectangle) obj).getArea();
        }
        return false;
    }

    @Override
    public int compareTo(Rectangle o) {
        return Double.compare(this.getArea(), o.getArea());
    }
}

class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    private double side;

    public Octagon() {
        this(1.0);
    }

    public Octagon(double side) {
        this.side = side;
    }

    public Octagon(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return (2.0 + 4.0 / Math.sqrt(2.0)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return 8.0 * side;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Octagon) {
            return this.getArea() == ((Octagon) obj).getArea();
        }
        return false;
    }

    @Override
    public int compareTo(Octagon o) {
        return Double.compare(this.getArea(), o.getArea());
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

class ComparableCircle extends Circle {
    public ComparableCircle() {
        super();
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(Circle o) {
        return Double.compare(this.getArea(), o.getArea());
    }
}

public class lab8_5 {
    public static void main(String[] args) {
        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle(5.0);
        System.out.println("Circle 1 equals Circle 2: " + c1.equals(c2));
        System.out.println("Circle 1 compareTo Circle 2: " + c1.compareTo(c2));

        Rectangle r1 = new Rectangle(4.0, 5.0);
        Rectangle r2 = new Rectangle(2.0, 10.0);
        System.out.println("Rectangle 1 equals Rectangle 2: " + r1.equals(r2));
        System.out.println("Rectangle 1 compareTo Rectangle 2: " + r1.compareTo(r2));

        Octagon oct1 = new Octagon(5.0);
        System.out.println("Octagon area: " + oct1.getArea());
        System.out.println("Octagon perimeter: " + oct1.getPerimeter());
        Octagon oct2 = (Octagon) oct1.clone();
        System.out.println("Octagon cloned equals original: " + oct1.equals(oct2));

        ComparableCircle cc1 = new ComparableCircle(4.0);
        ComparableCircle cc2 = new ComparableCircle(7.0);
        ComparableCircle larger = (cc1.compareTo(cc2) >= 0) ? cc1 : cc2;
        System.out.println("Larger ComparableCircle radius: " + larger.getRadius() + ", area: " + larger.getArea());
    }
}
