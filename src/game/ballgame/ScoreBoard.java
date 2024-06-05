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

    public void draw(Graphics2D g2d, int width, int height) {
        g2d.setColor(Color.WHITE); // �N��r�C��]�m���¦�
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.drawString("Player 1: " + scorePlayer1, width / 4, 100); // �վ� Y �y��
        g2d.drawString("Player 2: " + scorePlayer2, width * 3 / 4, 100); // �վ� Y �y��
    }
    
}
