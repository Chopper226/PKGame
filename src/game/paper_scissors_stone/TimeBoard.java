package game.paper_scissors_stone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeBoard extends JPanel {
    private int circlesRemaining = 3;
    private boolean countdownFinished = false;
    public boolean playerInputAllowed = false;
    private Timer timer;
    private Timer inputTimer;
    public boolean inputTimesUp = false;
    private GamePanel gamePanel;

    public TimeBoard(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        setPreferredSize(new Dimension(360, 150));
        setBackground(new Color(187, 167, 145));
    }

    public void startCountdown() {
        circlesRemaining = 3;
        playerInputAllowed = false;
        inputTimesUp = false;
        countdownFinished = false;

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (circlesRemaining > 0) {
                    circlesRemaining--;
                    repaint();
                    if (circlesRemaining == 0) {
                        playerInputAllowed = true;
                        startInputTimer();
                        timer.stop();
                        countdownFinished = true;
                    }
                }
            }
        });
        timer.start();
    }

    private void startInputTimer() {
        inputTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputTimer.stop();
                playerInputAllowed = false;
                inputTimesUp = true;
                gamePanel.repaint();
            }
        });
        inputTimer.setRepeats(false);
        inputTimer.start();
    }

    public boolean isCountdownFinished() {
        return countdownFinished;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int diameter = 80;
        int gap = 30;
        int x = 30;
        int y = getHeight() / 2 - diameter / 2;

        for (int i = 0; i < 3; i++) {
            if (i < circlesRemaining) {
                g2d.setColor(new Color(111, 94, 75));
                g2d.fillOval(x, y, diameter, diameter);
            }
            x += diameter + gap;
        }

        g2d.dispose();
    }
}