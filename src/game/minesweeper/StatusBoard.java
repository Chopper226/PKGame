package game.minesweeper;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class StatusBoard extends JPanel{
    private Font PlayerFont = new Font("Arial" , Font.BOLD , 35);
    private Font girdFont = new Font("Arial" , Font.BOLD , 30);
    private Font numFont = new Font("Arial" , Font.BOLD , 60);
    private GameBoard gameBoard;
    private int player;
    private int remaining;
    private int revealed;

    StatusBoard( GameBoard gameBoard ){
        this.gameBoard = gameBoard;
        this.player = gameBoard.getCurrentPlayer();
        this.remaining = gameBoard.getRemaining();
        this.revealed = gameBoard.getRevealed();
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

        g.dispose();
	}

    private void drawCurrentPlayerBoard(Graphics g) {
        g.setColor(Color.decode("#CDAF95"));
        g.fillRect(0, 0, 250, 120);
	}
    
    private void drawCurrentPlayerText(Graphics g){
        String text = "Now round :" ;
        g.setFont(PlayerFont);
        g.setColor(Color.WHITE);
        g.drawString(text , 250/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 45 );
    }

    private void drawCurrentPlayer(Graphics g){
        String text = "player "+String.valueOf(player);
        g.setFont(PlayerFont);
        g.setColor(Color.WHITE);
        g.drawString(text , 250/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 95 );
    }

    private void drawRemainingBoard(Graphics g) {
        g.setColor(Color.decode("#CDAF95"));
        g.fillRect(0, 180, 250, 200);
	}

    private void drawRemainingText(Graphics g){
        g.setFont(girdFont);
        g.setColor(Color.WHITE);

        String text = "Number of " ;
        g.drawString(text , 5, 225 );

        text = "remaining grids :";
        g.drawString(text , 5 , 265 );
    }

    private void drawRemaining(Graphics g){
        String text = String.valueOf(remaining);
        g.setFont(numFont);
        g.setColor(Color.WHITE);
        g.drawString(text , 250/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 350 );
    }

    private void drawRevealBoard(Graphics g) {
        g.setColor(Color.decode("#CDAF95"));
        g.fillRect(0, 440, 250, 200);
	}

    private void drawRevealText(Graphics g){
        g.setFont(girdFont);
        g.setColor(Color.WHITE);

        String text = "Number of " ;
        g.drawString(text , 5, 485 );

        text = "revealed grids :";
        g.drawString(text , 5 , 525 );
    }

    private void drawReveal(Graphics g){
        String text = String.valueOf(revealed);
        g.setFont(numFont);
        g.setColor(Color.WHITE);
        g.drawString(text , 250/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 610 );
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        drawCurrentPlayer(g);

    }
    
}
