package lab11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

class RaceCar extends JPanel implements Runnable {
    private int xBase = 0;
    private int sleepDelay = 10;
    private Thread carThread;

    public RaceCar() {
        setPreferredSize(new Dimension(300, 150));
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == 61) {
                    if (sleepDelay > 2) {
                        sleepDelay -= 2;
                    }
                } else if (e.isControlDown() && e.getKeyCode() == 45) {
                    sleepDelay += 2;
                }
            }
        });

        carThread = new Thread(this);
        carThread.start();
    }

    @Override
    public void run() {
        while (true) {
            int yBase = getHeight();
            if (xBase > getWidth()) {
                xBase = -50;
            } else {
                xBase += 1;
            }
            repaint();
            try {
                Thread.sleep(sleepDelay);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yBase = getHeight();

        g.setColor(Color.BLACK);
        g.fillOval(xBase + 10, yBase - 10, 10, 10);
        g.fillOval(xBase + 30, yBase - 10, 10, 10);

        g.setColor(Color.GREEN);
        g.fillRect(xBase, yBase - 20, 50, 10);

        g.setColor(Color.RED);
        Polygon polygon = new Polygon();
        polygon.addPoint(xBase + 10, yBase - 20);
        polygon.addPoint(xBase + 20, yBase - 30);
        polygon.addPoint(xBase + 30, yBase - 30);
        polygon.addPoint(xBase + 40, yBase - 20);
        g.fillPolygon(polygon);
    }
}

public class lab11_5 extends JFrame {
    public lab11_5() {
        setTitle("Exercise");
        setLayout(new BorderLayout());
        add(new RaceCar(), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        lab11_5 frame = new lab11_5();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
