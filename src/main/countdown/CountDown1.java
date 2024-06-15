package main.countdown;

import main.Panel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

public class CountDown1 extends Panel{

    private Image backgroundImage;

    public CountDown1() {
        this.backgroundImage = new ImageIcon("res\\countdown\\one.png").getImage(); 
    }

    public void paintComponent(Graphics g2) {
        super.paintComponent(g2);

        Graphics2D g = ((Graphics2D) g2); 

        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		
        g.dispose();
	}
}
