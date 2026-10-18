package lab9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class lab9_6 extends JFrame {
    private int dx = 0;
    private HangmanPanel canvas = new HangmanPanel();

    public lab9_6() {
        setTitle("Hangman");
        setLayout(new BorderLayout());

        add(canvas, BorderLayout.CENTER);

        JPanel pControls = new JPanel(new FlowLayout());
        JButton btnLeft = new JButton("< Left");
        JButton btnRight = new JButton("Right >");

        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dx -= 10;
                canvas.repaint();
            }
        });

        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dx += 10;
                canvas.repaint();
            }
        });

        pControls.add(btnLeft);
        pControls.add(btnRight);
        add(pControls, BorderLayout.SOUTH);

        canvas.setFocusable(true);
        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    dx -= 10;
                    canvas.repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    dx += 10;
                    canvas.repaint();
                }
            }
        });
    }

    class HangmanPanel extends JPanel {
        public HangmanPanel() {
            setPreferredSize(new Dimension(400, 320));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int base = 20 + dx;

            g.drawArc(base, 220, 80, 40, 0, 180);
            g.drawLine(base + 40, 220, base + 40, 20);
            g.drawLine(base + 40, 20, base + 40 + 100, 20);
            g.drawLine(base + 40 + 100, 20, base + 40 + 100, 40);

            int radius = 20;
            g.drawOval(base + 40 + 100 - radius, 40, 2 * radius, 2 * radius);

            g.drawLine(base + 40 + 100 - (int) (radius * Math.cos(Math.toRadians(45))),
                    40 + radius + (int) (radius * Math.sin(Math.toRadians(45))),
                    base + 40 + 100 - 60, 40 + radius + 60);

            g.drawLine(base + 40 + 100 + (int) (radius * Math.cos(Math.toRadians(45))),
                    40 + radius + (int) (radius * Math.sin(Math.toRadians(45))),
                    base + 40 + 100 + 60, 40 + radius + 60);

            g.drawLine(base + 40 + 100, 40 + 2 * radius,
                    base + 40 + 100, 40 + radius + 80);

            g.drawLine(base + 40 + 100, 40 + radius + 80,
                    base + 40 + 100 - 40, 40 + radius + 80 + 40);

            g.drawLine(base + 40 + 100, 40 + radius + 80,
                    base + 40 + 100 + 40, 40 + radius + 80 + 40);
        }
    }

    public static void main(String[] args) {
        lab9_6 frame = new lab9_6();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
