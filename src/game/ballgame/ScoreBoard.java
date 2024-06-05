package game.ballgame;

import java.awt.*;

public class ScoreBoard {
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    public void increaseScorePlayer1() {
        scorePlayer1++;
    }

    public void increaseScorePlayer2() {
        scorePlayer2++;
    }

    public void resetScores() {
        scorePlayer1 = 0;
        scorePlayer2 = 0;
    }

    public int getScorePlayer1(){ return scorePlayer1; }
    public int getScorePlayer2(){ return scorePlayer2; }

    public void draw(Graphics2D g2d, int width, int height) {
        g2d.setColor(Color.WHITE); 
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.drawString("Player 1 : " + scorePlayer1,100,100); 
        g2d.drawString("Player 2 : " + scorePlayer2,GamePanel.WIDTH-250, 100); 
    }
    
}
