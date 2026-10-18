package lab7;

class Fruit {
}

class Apple extends Fruit {
    public void makeApple() {
    }
}

class Orange extends Fruit {
    public void makeOrangeJuice() {
    }
}

class GoldenDelicious extends Apple {
}

class Macintosh extends Apple {
}

public class lab7_3 {
    public static void main(String[] args) {
        Fruit fruit = new GoldenDelicious();
        Orange orange = new Orange();

        System.out.println("1. Is fruit instanceof Orange? " + (fruit instanceof Orange));
        System.out.println("2. Is fruit instanceof Apple? " + (fruit instanceof Apple));
        System.out.println("3. Is fruit instanceof GoldenDelicious? " + (fruit instanceof GoldenDelicious));
        System.out.println("4. Is fruit instanceof Macintosh? " + (fruit instanceof Macintosh));
        System.out.println("5. Is orange instanceof Orange? " + (orange instanceof Orange));
        System.out.println("6. Is orange instanceof Fruit? " + (orange instanceof Fruit));
        System.out.println("7. Is orange instanceof Apple? " + ((Object) orange instanceof Apple));
        System.out.println("8. fruit.makeApple(): No, orange.makeApple(): No");
        System.out.println("9. orange.makeOrangeJuice(): Yes, fruit.makeOrangeJuice(): No");
    }
}
