package game.whackAMole;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StatusBoard extends JPanel{
    private Font font = new Font("Arial" , Font.BOLD , 40);
    private Font numFont = new Font("Arial" , Font.BOLD , 55);
    private Font TimeFont = new Font("Arial" , Font.BOLD , 50);
    
    private GameBoard gameBoard;
    private int remainingTime;
    private Timer timer;

    final private int player1X = 0;
    final private int player2X = 860;
    final private int timeX = 1210/2;

    StatusBoard( GameBoard gameBoard ){
        this.gameBoard = gameBoard;
        this.remainingTime = 180;
        initTimer();
    }

    public int getRemainingTime(){
        return remainingTime;
    }

    private void initTimer() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (remainingTime > 0) {
                    remainingTime--;
                } else {
                    timer.stop();
                    gameBoard.setGameOver(true);
                }    
                repaint();
            }
        });
        timer.start();
    }
    
    public void paintComponent(Graphics g2) {
		super.paintComponent(g2);

		Graphics2D g = ((Graphics2D) g2); 

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        drawPlayer1Board(g);
        drawPlayer1Text(g);
        drawPlayer1Score(g);

        drawTimeBoard(g);
        drawTimeText(g);
        drawTime(g);

        drawPlayer2Board(g);
        drawPlayer2Text(g);
        drawPlayer2Score(g);

        g.dispose();
	}

    private void drawPlayer1Board(Graphics g) {
        g.setColor(Color.decode("#8B8989"));
        g.fillRect(player1X, 0, 350, 120);
	}
    
    private void drawPlayer1Text(Graphics g){
        String text = "Player 1   Score" ;
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(text , player1X + 350/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 40 );
    }

    private void drawPlayer1Score(Graphics g){
        String text = String.valueOf(gameBoard.getPlayer1().getScore());
        g.setFont(numFont);
        g.setColor(Color.WHITE);
        g.drawString(text , player1X + 350/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 100 );
    }


    private void drawTimeBoard(Graphics g) {
        g.setColor(Color.decode("#8B8989"));
        g.fillRect(timeX-300/2, 0, 300, 120);
	}

    private void drawTimeText(Graphics g){
        String text = "Left Time" ;
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(text , timeX - (int)(g.getFontMetrics().stringWidth(text)/2) , 40 );
    }

    private void drawTime( Graphics g ){
        String text = formatTime();
        g.setFont(TimeFont);
        g.setColor(Color.WHITE);
        g.drawString(text , timeX- (int)(g.getFontMetrics().stringWidth(text)/2) , 100 );
    }

    private void drawPlayer2Board(Graphics g) {
        g.setColor(Color.decode("#8B8989"));
        g.fillRect(player2X, 0, 350, 120);
	}
    
    private void drawPlayer2Text(Graphics g){
        String text = "Player 2   Score" ;
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(text , player2X + 350/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 40 );
    }

    private void drawPlayer2Score(Graphics g){
        String text = String.valueOf(gameBoard.getPlayer2().getScore());
        g.setFont(numFont);
        g.setColor(Color.WHITE);
        g.drawString(text , player2X + 350/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 100 );
    }

    private String formatTime() {
        int minutes = remainingTime / 60;
        int seconds = remainingTime % 60;
        return String.format("%02d : %02d", minutes, seconds);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        drawPlayer1Score(g);
        drawTime(g);
        drawPlayer2Score(g);
    }
}
