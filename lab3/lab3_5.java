package lab3;
import java.util.Scanner;

class RoachPopulation {
    private int population;

    public RoachPopulation(int initialPopulation) {
        this.population = initialPopulation;
    }

    public void waitPeriod() {
        this.population *= 2;
    }

    public void spray() {
        this.population = this.population - (int)(this.population * 0.10);
    }

    public int getRoaches() {
        return this.population;
    }
}

public class lab3_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int initial = sc.nextInt();
        int cycles = sc.nextInt();

        RoachPopulation roach = new RoachPopulation(initial);

        for (int i = 0; i < cycles; i++) {
            roach.waitPeriod();
            roach.spray();
        }

        System.out.println(roach.getRoaches());
    }
}