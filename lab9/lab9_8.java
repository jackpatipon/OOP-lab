package lab9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

class Bird {
    private double x;
    private double y;

    public Bird(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void draw(Graphics g) {
        int ix = (int) x;
        int iy = (int) y;
        g.setColor(new Color(220, 20, 60));
        g.fillOval(ix - 15, iy - 15, 30, 30);
        g.setColor(Color.WHITE);
        g.fillOval(ix + 2, iy - 8, 8, 8);
        g.setColor(Color.BLACK);
        g.fillOval(ix + 6, iy - 6, 4, 4);
        g.setColor(Color.ORANGE);
        int[] bx = {ix + 10, ix + 18, ix + 10};
        int[] by = {iy - 2, iy + 2, iy + 6};
        g.fillPolygon(bx, by, 3);
    }
}

class Pig {
    private double x;
    private double y;

    public Pig(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void draw(Graphics g) {
        int ix = (int) x;
        int iy = (int) y;
        g.setColor(new Color(50, 205, 50));
        g.fillOval(ix - 18, iy - 18, 36, 36);
        g.setColor(new Color(34, 139, 34));
        g.fillOval(ix - 8, iy - 6, 16, 12);
        g.setColor(Color.BLACK);
        g.fillOval(ix - 5, iy - 3, 3, 5);
        g.fillOval(ix + 2, iy - 3, 3, 5);
        g.setColor(Color.WHITE);
        g.fillOval(ix - 12, iy - 12, 7, 7);
        g.fillOval(ix + 5, iy - 12, 7, 7);
        g.setColor(Color.BLACK);
        g.fillOval(ix - 9, iy - 10, 3, 3);
        g.fillOval(ix + 6, iy - 10, 3, 3);
    }
}

public class lab9_8 extends JFrame {
    private JTextField txtScore = new JTextField("0", 6);
    private JTextField txtY = new JTextField("-100", 10);
    private JTextField txtSpeed = new JTextField("50", 10);
    private JTextField txtAngle = new JTextField("30", 10);
    private JButton btnOk = new JButton("OK");

    private int score = 0;
    private Bird bird;
    private Pig pig;
    private Random random = new Random();
    private GameCanvas canvas;

    private boolean animating = false;
    private double currentAnimT = 0;
    private double maxAnimT = 0;
    private double animUx = 0;
    private double animUy = 0;
    private double startX = 250;
    private double startY = 220;
    private Timer animTimer;

    public lab9_8() {
        setTitle("Angry Birds - Scene 1: At Tokyo");
        setLayout(new BorderLayout());

        JPanel pTop = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        JLabel lblScene = new JLabel("SCENE 1: At Tokyo");
        lblScene.setFont(new Font("Arial", Font.BOLD, 16));
        pTop.add(lblScene);

        JPanel pScore = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        pScore.add(new JLabel("SCORE"));
        txtScore.setEditable(false);
        txtScore.setHorizontalAlignment(JTextField.CENTER);
        pScore.add(txtScore);
        pTop.add(pScore);
        add(pTop, BorderLayout.NORTH);

        canvas = new GameCanvas();
        add(canvas, BorderLayout.CENTER);

        JPanel pBottom = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 6, 4, 6);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pBottom.add(new JLabel("Bird Position in y-axis"), gbc);
        gbc.gridx = 1;
        pBottom.add(txtY, gbc);
        gbc.gridx = 2;
        pBottom.add(new JLabel("m"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pBottom.add(new JLabel("Shooting speed"), gbc);
        gbc.gridx = 1;
        pBottom.add(txtSpeed, gbc);
        gbc.gridx = 2;
        pBottom.add(new JLabel("m/s"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pBottom.add(new JLabel("Angle"), gbc);
        gbc.gridx = 1;
        pBottom.add(txtAngle, gbc);
        gbc.gridx = 2;
        pBottom.add(new JLabel("degree"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        pBottom.add(btnOk, gbc);

        add(pBottom, BorderLayout.SOUTH);

        resetPig();
        resetBird();

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shootBird();
            }
        });
    }

    private void resetBird() {
        double yPos = 220;
        try {
            double sy = Double.parseDouble(txtY.getText().trim());
            yPos = 320 + sy;
        } catch (Exception ignored) {
        }
        bird = new Bird(startX, yPos);
    }

    private void resetPig() {
        double pigX = 350 + random.nextInt(250);
        pig = new Pig(pigX, 320);
    }

    private void shootBird() {
        if (animating) {
            return;
        }

        try {
            double sy = Double.parseDouble(txtY.getText().trim());
            double u = Double.parseDouble(txtSpeed.getText().trim());
            double deg = Double.parseDouble(txtAngle.getText().trim());
            double rad = Math.toRadians(deg);

            animUx = u * Math.cos(rad);
            animUy = u * Math.sin(rad);

            double a = 5.0;
            double b = -animUy;
            double c = sy;

            double disc = b * b - 4 * a * c;
            if (disc < 0) {
                JOptionPane.showMessageDialog(this, "The bird does not reach the ground with these parameters.");
                return;
            }

            maxAnimT = (-b + Math.sqrt(disc)) / (2 * a);
            if (maxAnimT <= 0) {
                maxAnimT = (-b - Math.sqrt(disc)) / (2 * a);
            }

            double groundSx = animUx * maxAnimT;
            double finalLandX = startX + groundSx;

            animating = true;
            currentAnimT = 0;

            animTimer = new Timer(20, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentAnimT += 0.15;
                    if (currentAnimT >= maxAnimT) {
                        currentAnimT = maxAnimT;
                        animTimer.stop();
                        animating = false;

                        if (Math.abs(finalLandX - pig.getX()) <= 20) {
                            score += 100;
                            txtScore.setText(String.valueOf(score));
                            JOptionPane.showMessageDialog(lab9_8.this, "Hit Pig! +100 Score!", "Victory", JOptionPane.INFORMATION_MESSAGE);
                            resetPig();
                        } else {
                            JOptionPane.showMessageDialog(lab9_8.this, String.format("Missed! Landed at x=%.1f, Pig at x=%.1f", finalLandX, pig.getX()), "Result", JOptionPane.INFORMATION_MESSAGE);
                        }
                        resetBird();
                        canvas.repaint();
                    } else {
                        double curSx = animUx * currentAnimT;
                        double curSy = animUy * currentAnimT - 0.5 * 10.0 * currentAnimT * currentAnimT;
                        bird.setX(startX + curSx);
                        bird.setY((320 + sy) - curSy);
                        canvas.repaint();
                    }
                }
            });
            animTimer.start();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.");
        }
    }

    class GameCanvas extends JPanel {
        public GameCanvas() {
            setPreferredSize(new Dimension(650, 350));
            setBackground(new Color(176, 224, 230));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(new Color(135, 206, 235));
            g.fillRect(0, 0, getWidth(), 330);

            g.setColor(new Color(160, 160, 175));
            g.fillRect(50, 150, 50, 180);
            g.fillRect(120, 120, 70, 210);
            g.fillRect(210, 170, 60, 160);
            g.fillRect(380, 100, 80, 230);
            g.fillRect(490, 140, 70, 190);
            g.fillRect(580, 160, 60, 170);

            g.setColor(new Color(255, 69, 0));
            int[] tx = {300, 315, 330};
            int[] ty = {330, 80, 330};
            g.fillPolygon(tx, ty, 3);
            g.setColor(Color.WHITE);
            g.fillRect(313, 50, 4, 30);

            g.setColor(new Color(34, 139, 34));
            g.fillRect(0, 330, getWidth(), getHeight() - 330);

            g.setColor(new Color(139, 69, 19));
            g.fillRect((int) startX - 25, 220, 30, 110);

            if (pig != null) {
                pig.draw(g);
            }
            if (bird != null) {
                bird.draw(g);
            }
        }
    }

    public static void main(String[] args) {
        lab9_8 game = new lab9_8();
        game.pack();
        game.setLocationRelativeTo(null);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }
}
