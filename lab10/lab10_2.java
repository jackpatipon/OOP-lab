package lab10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

class WorldClockPanel extends JPanel {
    private TimeZone timeZone;
    private String title;
    private int hour;
    private int minute;
    private int second;

    public WorldClockPanel(String title, TimeZone timeZone) {
        this.title = title;
        this.timeZone = timeZone;
        setPreferredSize(new Dimension(220, 260));
        setCurrentTime();
    }

    public void setCurrentTime() {
        Calendar cal = new GregorianCalendar(timeZone);
        this.hour = cal.get(Calendar.HOUR_OF_DAY);
        this.minute = cal.get(Calendar.MINUTE);
        this.second = cal.get(Calendar.SECOND);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int clockRadius = (int) (Math.min(getWidth(), getHeight() - 40) * 0.8 * 0.5);
        int xCenter = getWidth() / 2;
        int yCenter = (getHeight() - 40) / 2 + 10;

        g.setColor(Color.BLACK);
        g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);
        g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
        g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
        g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
        g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

        int sLength = (int) (clockRadius * 0.8);
        int xSecond = (int) (xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
        int ySecond = (int) (yCenter - sLength * Math.cos(second * (2 * Math.PI / 60)));
        g.setColor(Color.RED);
        g.drawLine(xCenter, yCenter, xSecond, ySecond);

        int mLength = (int) (clockRadius * 0.65);
        int xMinute = (int) (xCenter + mLength * Math.sin(minute * (2 * Math.PI / 60)));
        int yMinute = (int) (yCenter - mLength * Math.cos(minute * (2 * Math.PI / 60)));
        g.setColor(Color.BLUE);
        g.drawLine(xCenter, yCenter, xMinute, yMinute);

        int hLength = (int) (clockRadius * 0.5);
        int xHour = (int) (xCenter + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        int yHour = (int) (yCenter - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        g.setColor(Color.GREEN);
        g.drawLine(xCenter, yCenter, xHour, yHour);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        int titleWidth = g.getFontMetrics().stringWidth(title);
        g.drawString(title, xCenter - titleWidth / 2, getHeight() - 15);
    }
}

public class lab10_2 extends JFrame {
    private WorldClockPanel thailandClock;
    private WorldClockPanel japanClock;

    public lab10_2() {
        setTitle("Clock Around the World");
        setLayout(new GridLayout(1, 2, 10, 10));

        thailandClock = new WorldClockPanel("Thailand (GMT+7)", TimeZone.getTimeZone("GMT+7"));
        japanClock = new WorldClockPanel("Japan (GMT+9)", TimeZone.getTimeZone("GMT+9"));

        add(thailandClock);
        add(japanClock);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thailandClock.setCurrentTime();
                japanClock.setCurrentTime();
                thailandClock.repaint();
                japanClock.repaint();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        lab10_2 frame = new lab10_2();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
