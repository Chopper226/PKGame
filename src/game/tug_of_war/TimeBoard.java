package game.tug_of_war;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeBoard extends JPanel {
    static private Font TimeFont = new Font("Arial", Font.BOLD, 35);
    static private Font font = new Font("Arial", Font.BOLD, 45);
    private int remainingTime = 60;
    private Timer timer;
    private GamePanel gamepanel;

    TimeBoard(GamePanel gamepanel) {
        this.gamepanel = gamepanel;
        initTimer();
    }

    private void initTimer() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (remainingTime > 0) {
                    remainingTime--;
                } else {
                    GamePanel.endGame(); 
                    timer.stop();
                }
                repaint();
            }
        });
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }
    
    public Timer getTimer() {
        return timer;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void paintComponent(Graphics g2) {
        super.paintComponent(g2);

        Graphics2D g = ((Graphics2D) g2);

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        drawTimeBoard(g);
        drawTimeText(g);
        drawTime(g);
        g.dispose();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawTime(g);
    }

    private static void drawTimeBoard(Graphics g) {
        g.setColor(new Color(123, 123, 123));
        g.fillRect(640-190/2, 20, 190, 120);
    }

    private static void drawTimeText(Graphics g) {
        String text = "T I M E";
        g.setFont(TimeFont);
        g.setColor(Color.WHITE);
        g.drawString(text, 583, 70);
    }

    private void drawTime(Graphics g) {
        String text = formatTime();
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(text, 571, 115);
    }

    private String formatTime() {
        int minutes = remainingTime / 60;
        int seconds = remainingTime % 60;
        return String.format("%02d : %02d", minutes, seconds);
    }
}
