package lab10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class lab10_4 extends JFrame {
    private JTextField txtCar1 = new JTextField("10", 4);
    private JTextField txtCar2 = new JTextField("20", 4);
    private JTextField txtCar3 = new JTextField("30", 4);
    private JTextField txtCar4 = new JTextField("40", 4);

    private int[] xBase = {0, 0, 0, 0};
    private int[] speeds = {10, 20, 30, 40};
    private RaceTrack track = new RaceTrack();

    public lab10_4() {
        setTitle("Exercise18_17");
        setLayout(new BorderLayout());

        JPanel pTop = new JPanel(new FlowLayout());
        pTop.add(new JLabel("Car 1:"));
        pTop.add(txtCar1);
        pTop.add(new JLabel("Car 2:"));
        pTop.add(txtCar2);
        pTop.add(new JLabel("Car 3:"));
        pTop.add(txtCar3);
        pTop.add(new JLabel("Car 4:"));
        pTop.add(txtCar4);
        add(pTop, BorderLayout.NORTH);

        add(track, BorderLayout.CENTER);

        ActionListener speedListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSpeeds();
            }
        };

        txtCar1.addActionListener(speedListener);
        txtCar2.addActionListener(speedListener);
        txtCar3.addActionListener(speedListener);
        txtCar4.addActionListener(speedListener);

        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSpeeds();
                for (int i = 0; i < 4; i++) {
                    xBase[i] += Math.max(1, speeds[i] / 5);
                    if (xBase[i] > track.getWidth()) {
                        xBase[i] = -50;
                    }
                }
                track.repaint();
            }
        });
        timer.start();
    }

    private void updateSpeeds() {
        try {
            speeds[0] = Integer.parseInt(txtCar1.getText().trim());
        } catch (Exception ignored) {
        }
        try {
            speeds[1] = Integer.parseInt(txtCar2.getText().trim());
        } catch (Exception ignored) {
        }
        try {
            speeds[2] = Integer.parseInt(txtCar3.getText().trim());
        } catch (Exception ignored) {
        }
        try {
            speeds[3] = Integer.parseInt(txtCar4.getText().trim());
        } catch (Exception ignored) {
        }
    }

    class RaceTrack extends JPanel {
        public RaceTrack() {
            setPreferredSize(new Dimension(500, 300));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int h = getHeight();
            int laneHeight = h / 4;

            g.setColor(Color.LIGHT_GRAY);
            for (int i = 1; i < 4; i++) {
                g.drawLine(0, i * laneHeight, getWidth(), i * laneHeight);
            }

            for (int i = 0; i < 4; i++) {
                int yBase = (i + 1) * laneHeight;
                int x = xBase[i];

                g.setColor(Color.BLACK);
                g.fillOval(x + 10, yBase - 10, 10, 10);
                g.fillOval(x + 30, yBase - 10, 10, 10);

                g.setColor(Color.GREEN);
                g.fillRect(x, yBase - 20, 50, 10);

                g.setColor(Color.RED);
                Polygon polygon = new Polygon();
                polygon.addPoint(x + 10, yBase - 20);
                polygon.addPoint(x + 20, yBase - 30);
                polygon.addPoint(x + 30, yBase - 30);
                polygon.addPoint(x + 40, yBase - 20);
                g.fillPolygon(polygon);
            }
        }
    }

    public static void main(String[] args) {
        lab10_4 frame = new lab10_4();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
