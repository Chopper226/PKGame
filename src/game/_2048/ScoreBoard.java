package game._2048;

import java.awt.*;
import javax.swing.*;

public class ScoreBoard extends JPanel{
    static Font ScoreFont = new Font("Arial" , Font.BOLD , 40);
    static Font font1 = new Font("Arial" , Font.BOLD , 50);
    static Font font2 = new Font("Arial" , Font.BOLD , 48);
    static Font font3 = new Font("Arial" , Font.BOLD , 46);
    static Font font4 = new Font("Arial" , Font.BOLD , 44);


    private GameBoard gameBoard;
    private int score;

    ScoreBoard(GameBoard gameBoard){
        this.gameBoard = gameBoard;
        this.score = gameBoard.getScore();
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
        g.setColor(Color.decode("#BBADA0"));
        g.fillRect(0, 0, 250, 200);
	}

    private static void drawScoreText(Graphics g){
        String text = "S C O R E" ;
        g.setFont(ScoreFont);
        g.setColor(Color.WHITE);
        g.drawString(text , 250/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 45 );
    }

    private void drawScore(Graphics g){
        String text = String.valueOf(score);
        g.setFont(getScoreFont());
        g.setColor(Color.WHITE);
        g.drawString(text , 250/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 100 );
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

    public void setScore( int score ){
        this.score = score ;
    }
}