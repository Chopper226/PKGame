package game.minesweeper;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class InformationBoard extends JPanel{
    private Font PlayerFont = new Font("Arial" , Font.BOLD , 35);

    public void paintComponent(Graphics g2) {
		super.paintComponent(g2);

		Graphics2D g = ((Graphics2D) g2); 

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        drawBoard(g);

        g.dispose();
	}

    private void drawBoard(Graphics g) {
        g.setColor(Color.decode("#CDAF95"));
        g.fillRect(0, 40, 250, 300);
        g.fillRect(0, 380, 250, 300);
	}
    
    private void drawPlayer1Text(Graphics g){
        String text = "Player1 :" ;
        g.setFont(PlayerFont);
        g.setColor(Color.WHITE);
        g.drawString(text , 250/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 45 );
    }
}
