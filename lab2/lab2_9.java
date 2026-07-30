package lab2;
import java.util.Scanner;

class PrimeFinder {
    private int maxPrime = -1;

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void processNumber(int number) {
        if (isPrime(number)) {
            if (number > maxPrime) {
                maxPrime = number;
            }
        }
    }

    public int getMaxPrime() {
        return maxPrime;
    }
}

public class lab2_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrimeFinder finder = new PrimeFinder();

        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            
            if (num == 0) {
                break;
            }

            finder.processNumber(num);
        }

        System.out.println(finder.getMaxPrime());
        
        scanner.close();
    }
}