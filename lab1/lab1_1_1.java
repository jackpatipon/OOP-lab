package lab1;
import java.util.Scanner;
import java.lang.Math;
import javax.swing.JOptionPane;

public class lab1_1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = JOptionPane.showInputDialog("fahrenheit:");
        double fahrenheit = Double.parseDouble(input);
        double celsius = (5.0/9.0)*(fahrenheit-32.0);

        JOptionPane.showMessageDialog(null, "Celsius = " + celsius);
    }
}