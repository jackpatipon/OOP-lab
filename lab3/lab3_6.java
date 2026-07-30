package lab3;
import java.util.Scanner;

public class lab3_6 {
    public static boolean isPalindrome(String s) {
        String cleanStr = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toUpperCase(s.charAt(i));
            if (ch >= 'A' && ch <= 'Z') {
                cleanStr += ch;
            }
        }

        int left = 0;
        int right = cleanStr.length() - 1;
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (isPalindrome(input)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}