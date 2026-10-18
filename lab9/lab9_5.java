package lab9;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class lab9_5 extends JFrame implements ActionListener {
    private JTextField display = new JTextField("0");
    private double firstOperand = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public lab9_5() {
        setTitle("Simple Calculator");

        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        add(display, BorderLayout.NORTH);

        JPanel pButtons = new JPanel(new GridLayout(5, 4, 4, 4));
        String[] buttons = {
            "sqrt", "x^2", "+/-", "C",
            "7", "8", "9", "+",
            "6", "5", "4", "-",
            "1", "2", "3", "*",
            "0", ".", "=", "/"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            btn.addActionListener(this);
            pButtons.add(btn);
        }

        add(pButtons, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') {
            if (startNewNumber || display.getText().equals("0")) {
                display.setText(cmd);
                startNewNumber = false;
            } else {
                display.setText(display.getText() + cmd);
            }
        } else if (cmd.equals(".")) {
            if (startNewNumber) {
                display.setText("0.");
                startNewNumber = false;
            } else if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
        } else if (cmd.equals("C")) {
            display.setText("0");
            firstOperand = 0;
            operator = "";
            startNewNumber = true;
        } else if (cmd.equals("+/-")) {
            double val = Double.parseDouble(display.getText());
            val = -val;
            display.setText(formatResult(val));
        } else if (cmd.equals("sqrt")) {
            double val = Double.parseDouble(display.getText());
            if (val >= 0) {
                display.setText(formatResult(Math.sqrt(val)));
            } else {
                display.setText("Error");
            }
            startNewNumber = true;
        } else if (cmd.equals("x^2")) {
            double val = Double.parseDouble(display.getText());
            display.setText(formatResult(val * val));
            startNewNumber = true;
        } else if (cmd.equals("=")) {
            if (!operator.isEmpty()) {
                double secondOperand = Double.parseDouble(display.getText());
                double result = calculate(firstOperand, secondOperand, operator);
                display.setText(formatResult(result));
                operator = "";
                startNewNumber = true;
            }
        } else {
            if (!operator.isEmpty() && !startNewNumber) {
                double secondOperand = Double.parseDouble(display.getText());
                firstOperand = calculate(firstOperand, secondOperand, operator);
                display.setText(formatResult(firstOperand));
            } else {
                firstOperand = Double.parseDouble(display.getText());
            }
            operator = cmd;
            startNewNumber = true;
        }
    }

    private double calculate(double a, double b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return b != 0 ? a / b : 0;
            default:
                return b;
        }
    }

    private String formatResult(double val) {
        if (Double.isInfinite(val) || Double.isNaN(val)) {
            return "Error";
        }
        if (val == (long) val) {
            return String.format("%d", (long) val);
        } else {
            return String.format("%.6g", val);
        }
    }

    public static void main(String[] args) {
        lab9_5 calc = new lab9_5();
        calc.setSize(320, 360);
        calc.setLocationRelativeTo(null);
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
    }
}
