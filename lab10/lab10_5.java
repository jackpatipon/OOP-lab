package lab10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class lab10_5 extends JFrame {
    private BalloonPanel canvas = new BalloonPanel();

    public lab10_5() {
        setTitle("Exercise");
        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);

        canvas.setFocusable(true);
        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    canvas.moveGunLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    canvas.moveGunRight();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    canvas.fireBullet();
                }
            }
        });
    }

    class BalloonPanel extends JPanel {
        private int gunX = 190;
        private int gunWidth = 20;
        private int gunHeight = 30;

        private int balloonX;
        private int balloonY = 40;
        private int balloonRadius = 20;

        private int bulletX = -10;
        private int bulletY = -10;
        private boolean bulletActive = false;

        private Random random = new Random();
        private Timer bulletTimer;

        public BalloonPanel() {
            setPreferredSize(new Dimension(400, 350));
            randomizeBalloon();

            bulletTimer = new Timer(20, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (bulletActive) {
                        bulletY -= 8;
                        if (bulletY < 0) {
                            bulletActive = false;
                        }

                        double dist = Math.hypot(bulletX - (balloonX + balloonRadius), bulletY - (balloonY + balloonRadius));
                        if (dist <= balloonRadius + 4) {
                            bulletActive = false;
                            randomizeBalloon();
                        }
                        repaint();
                    }
                }
            });
            bulletTimer.start();
        }

        public void randomizeBalloon() {
            balloonX = 30 + random.nextInt(320);
            balloonY = 30 + random.nextInt(40);
            repaint();
        }

        public void moveGunLeft() {
            gunX = Math.max(10, gunX - 10);
            repaint();
        }

        public void moveGunRight() {
            gunX = Math.min(getWidth() - gunWidth - 10, gunX + 10);
            repaint();
        }

        public void fireBullet() {
            if (!bulletActive) {
                bulletActive = true;
                bulletX = gunX + gunWidth / 2;
                bulletY = getHeight() - gunHeight - 5;
                repaint();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.RED);
            g.drawOval(balloonX, balloonY, balloonRadius * 2, balloonRadius * 2);
            g.drawLine(balloonX + balloonRadius, balloonY + balloonRadius * 2, balloonX + balloonRadius, balloonY + balloonRadius * 2 + 15);

            int bottomY = getHeight() - 10;
            g.setColor(Color.BLACK);
            int[] gx = {gunX, gunX + gunWidth / 2, gunX + gunWidth};
            int[] gy = {bottomY, bottomY - gunHeight, bottomY};
            g.drawPolygon(gx, gy, 3);

            if (bulletActive) {
                g.setColor(Color.BLACK);
                g.fillOval(bulletX - 3, bulletY - 3, 6, 6);
            }
        }
    }

    public static void main(String[] args) {
        lab10_5 frame = new lab10_5();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
