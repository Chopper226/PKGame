package main.instructions;

import main.Panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Instruction_paper_scissors_stone extends Panel{
    private static Font font = new Font("Arial" , Font.BOLD , 100);

    public void paintComponent(Graphics g2) {
        super.paintComponent(g2);

        Graphics2D g = ((Graphics2D) g2); 

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		
        drawText(g);

        g.dispose();
	}
    
    private static void drawText(Graphics g){
        String text = "paper_scissors_stone" ;
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString(text , 1280/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 720/2);
    }
}
