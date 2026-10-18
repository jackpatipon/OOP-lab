package lab8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

abstract class AbstractDrawFunction extends JPanel {
    private Polygon p = new Polygon();

    protected AbstractDrawFunction() {
        drawFunction();
        setBackground(Color.white);
    }

    public abstract double f(double x);

    public void drawFunction() {
        for (int x = -100; x <= 100; x++) {
            p.addPoint(x + 200, 200 - (int) f(x));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(10, 200, 390, 200);
        g.drawLine(200, 30, 200, 390);
        g.drawLine(390, 200, 370, 190);
        g.drawLine(390, 200, 370, 210);
        g.drawLine(200, 30, 190, 50);
        g.drawLine(200, 30, 210, 50);
        g.drawString("X", 370, 170);
        g.drawString("Y", 220, 40);
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }
}

class DrawSquare extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return (x * x) / 50.0;
    }
}

class DrawSine extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 50 * Math.sin((x / 100.0) * 2 * Math.PI);
    }
}

class DrawCosine extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 50 * Math.cos((x / 100.0) * 2 * Math.PI);
    }
}

class DrawTangent extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 20 * Math.tan((x / 100.0) * 2 * Math.PI);
    }
}

class DrawCosPlus5Sin extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 10 * (Math.cos((x / 100.0) * 2 * Math.PI) + 5 * Math.sin((x / 100.0) * 2 * Math.PI));
    }
}

class Draw5CosPlusSin extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 10 * (5 * Math.cos((x / 100.0) * 2 * Math.PI) + Math.sin((x / 100.0) * 2 * Math.PI));
    }
}

class DrawLogPlusSquare extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        if (x <= 0) {
            return 0;
        }
        return (20 * Math.log(x)) + ((x * x) / 100.0);
    }
}

public class lab8_3 extends JFrame {
    public lab8_3() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("f(x) = x^2", new DrawSquare());
        tabbedPane.addTab("f(x) = sin(x)", new DrawSine());
        tabbedPane.addTab("f(x) = cos(x)", new DrawCosine());
        tabbedPane.addTab("f(x) = tan(x)", new DrawTangent());
        tabbedPane.addTab("f(x) = cos(x)+5sin(x)", new DrawCosPlus5Sin());
        tabbedPane.addTab("f(x) = 5cos(x)+sin(x)", new Draw5CosPlusSin());
        tabbedPane.addTab("f(x) = log(x)+x^2", new DrawLogPlusSquare());

        getContentPane().add(tabbedPane);
    }

    public static void main(String[] args) {
        lab8_3 frame = new lab8_3();
        frame.setSize(450, 450);
        frame.setTitle("Exercise 10.10");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
