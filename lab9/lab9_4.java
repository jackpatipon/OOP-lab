package lab9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class lab9_4 extends JFrame {
    private JTextField txtUSD = new JTextField(10);
    private JTextField txtCAD = new JTextField(10);
    private JButton btnConvert = new JButton("Convert");

    public lab9_4() {
        setTitle("Convert US Dollars to Canadian Dollars");

        JPanel pCenter = new JPanel(new GridLayout(2, 2, 5, 5));
        pCenter.add(new JLabel("US Dollars"));
        pCenter.add(txtUSD);
        pCenter.add(new JLabel("Canadian Dollars"));
        pCenter.add(txtCAD);

        JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pSouth.add(btnConvert);

        add(pCenter, BorderLayout.CENTER);
        add(pSouth, BorderLayout.SOUTH);

        ActionListener convertAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        };

        btnConvert.addActionListener(convertAction);
        txtUSD.addActionListener(convertAction);
        txtCAD.addActionListener(convertAction);
    }

    private void convertCurrency() {
        try {
            if (!txtUSD.getText().trim().isEmpty()) {
                double usd = Double.parseDouble(txtUSD.getText().trim());
                double cad = usd * 1.5;
                txtCAD.setText(String.format("%.2f", cad));
            } else if (!txtCAD.getText().trim().isEmpty()) {
                double cad = Double.parseDouble(txtCAD.getText().trim());
                double usd = cad / 1.5;
                txtUSD.setText(String.format("%.2f", usd));
            }
        } catch (NumberFormatException ex) {
        }
    }

    public static void main(String[] args) {
        lab9_4 frame = new lab9_4();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
