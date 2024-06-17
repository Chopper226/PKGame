package game.paper_scissors_stone;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class ScoreBoard extends JPanel {
    private double player1Score = 0;
    private double player2Score = 0;

    public ScoreBoard() {
        setOpaque(false);
    }

    public void updateScores(String result) {
        if (result.equals("Player1")) {
            player1Score++;
        } else if (result.equals("Player2")) {
            player2Score++;
        } else if (result.equals("Tie")) {
            player1Score += 0.5;
            player2Score += 0.5;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.setColor(new Color(71, 62, 51));

        String player1ScoreText = "S C O R E: " + player1Score;
        int player1ScoreX = 130;
        int player1ScoreY = 135;
        g2d.drawString(player1ScoreText, player1ScoreX, player1ScoreY);

        String player2ScoreText = "S C O R E : " + player2Score;
        int player2ScoreX = 945;
        int player2ScoreY = 135;
        g2d.drawString(player2ScoreText, player2ScoreX, player2ScoreY);

        g2d.dispose();
    }
}
