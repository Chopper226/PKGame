package game.speedyArrows;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class ScoreBoard extends JPanel{
    private static Font ScoreFont = new Font("Arial" , Font.BOLD , 35);
    private static Font font1 = new Font("Arial" , Font.BOLD , 50);
    private static Font font2 = new Font("Arial" , Font.BOLD , 48);
    private static Font font3 = new Font("Arial" , Font.BOLD , 46);
    private static Font font4 = new Font("Arial" , Font.BOLD , 44);


    private GameBoard gameBoard;
    private int score;

    ScoreBoard(GameBoard gameBoard){
        this.gameBoard = gameBoard;
        this.score = gameBoard.getScore();
    }

    public void setScore( int score ){
        this.score = score ;
    }
    
    public void paintComponent(Graphics g2) {
        super.paintComponent(g2);

        Graphics2D g = ((Graphics2D) g2); 

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		
        drawScoreBoard(g);
        drawScoreText(g);
		drawScore(g);
        g.dispose();
        
	}

    private static void drawScoreBoard(Graphics g) {
        g.setColor(Color.decode("#838B8B"));
        g.fillRect(0, 0, 200, 200);
	}

    private static void drawScoreText(Graphics g){
        String text = "S C O R E" ;
        g.setFont(ScoreFont);
        g.setColor(Color.WHITE);
        g.drawString(text , 200/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 45 );
    }

    private void drawScore(Graphics g){
        String text = String.valueOf(score);
        g.setFont(getScoreFont());
        g.setColor(Color.WHITE);
        g.drawString(text , 200/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 105 );
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        drawScore(g);
    }
    
    private Font getScoreFont(){
        if( gameBoard.getScore() < 10 ) return font1;
        else if( gameBoard.getScore() < 100 ) return font2;
        else if( gameBoard.getScore() < 1000 ) return font3;
        return font4;
    }

}
