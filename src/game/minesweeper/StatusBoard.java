package game.minesweeper;

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
    private Font font = new Font("Arial" , Font.BOLD , 35);
    private Font PlayerTextFont = new Font("Arial" , Font.BOLD , 45);
    private Font numFont = new Font("Arial" , Font.BOLD , 60);
    private Font TimeFont = new Font("Arial" , Font.BOLD , 50);
    
    private GameBoard gameBoard;
    private int player;
    private int remaining;
    private int revealed;
    private int remainingTime;
    private Timer timer;

    final private int playerX = 0;
    final private int remainingX = 270;
    final private int revealX = 590;
    final private int timeX = 910;

    StatusBoard( GameBoard gameBoard ){
        this.gameBoard = gameBoard;
        this.player = gameBoard.getCurrentPlayer();
        this.remaining = gameBoard.getRemaining();
        this.revealed = gameBoard.getRevealed();
        this.remainingTime = 15;
        initTimer();
    }

    private void initTimer() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (remainingTime > 0) {
                    remainingTime--;
                } else {
                    gameBoard.randomChoose();
                    //timer.stop();

                }    
                repaint();
            }
        });
        timer.start();
    }

    public void setPlayer( int player ){
        this.player = player;
    }

    public void setRemaining( int remaining ){
        this.remaining = remaining;
    }

    public void setRevealed( int revealed ){
        this.revealed = revealed;
    }

    public void setRemainingTime( int remainingTime ){
        this.remainingTime = remainingTime;
    }

    public Timer getTimer(){
        return timer;
    }
    
    public void paintComponent(Graphics g2) {
		super.paintComponent(g2);

		Graphics2D g = ((Graphics2D) g2); 

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        drawCurrentPlayerBoard(g);
        drawCurrentPlayerText(g);
        drawCurrentPlayer(g);

        drawRemainingBoard(g);
        drawRemainingText(g);
        drawRemaining(g);

        drawRevealBoard(g);
        drawRevealText(g);
        drawReveal(g);

        drawTimeBoard(g);
        drawTimeText(g);
        drawTime(g);

        g.dispose();
	}

    private void drawCurrentPlayerBoard(Graphics g) {
        g.setColor(Color.decode("#8B8B83"));
        g.fillRect(playerX, 0, 250, 120);
	}
    
    private void drawCurrentPlayerText(Graphics g){
        String text = "Now Round" ;
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(text , playerX + 250/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 40 );
    }

    private void drawCurrentPlayer(Graphics g){
        String text = "player "+String.valueOf(player);
        g.setFont(PlayerTextFont);
        g.setColor(Color.WHITE);
        g.drawString(text , playerX + 250/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 100 );
    }

    private void drawRemainingBoard(Graphics g) {
        g.setColor(Color.decode("#8B8B83"));
        g.fillRect(remainingX, 0, 300, 120);
	}

    private void drawRemainingText(Graphics g){
        g.setFont(font);
        g.setColor(Color.WHITE);

        String text = "Remaining Grids";
        g.drawString(text , remainingX + 300/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 40 );
    }

    private void drawRemaining(Graphics g){
        String text = String.valueOf(remaining);
        g.setFont(numFont);
        g.setColor(Color.WHITE);
        g.drawString(text , remainingX + 300/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 105 );
    }

    private void drawRevealBoard(Graphics g) {
        g.setColor(Color.decode("#8B8B83"));
        g.fillRect(revealX , 0, 300, 120);
	}

    private void drawRevealText(Graphics g){
        g.setFont(font);
        g.setColor(Color.WHITE);

        String text = "Revealed Grids";
        g.drawString(text , revealX + 300/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 40 );
    }

    private void drawReveal(Graphics g){
        String text = String.valueOf(revealed);
        g.setFont(numFont);
        g.setColor(Color.WHITE);
        g.drawString(text , revealX + 300/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 105 );
    }

    private void drawTimeBoard(Graphics g) {
        g.setColor(Color.decode("#8B8B83"));
        g.fillRect(timeX, 0, 300, 120);
	}

    private void drawTimeText(Graphics g){
        String text = "Left Time" ;
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(text , timeX + 300/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 40 );
    }

    private void drawTime( Graphics g ){
        String text = formatTime();
        g.setFont(TimeFont);
        g.setColor(Color.WHITE);
        g.drawString(text , timeX + 300/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 100 );
    }

    private String formatTime() {
        int minutes = remainingTime / 60;
        int seconds = remainingTime % 60;
        return String.format("%02d : %02d", minutes, seconds);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        drawCurrentPlayer(g);
        drawRemaining(g);
        drawReveal(g);
    }
    
}
