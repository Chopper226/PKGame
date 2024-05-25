package game._2048;

import java.awt.*;
import javax.swing.*;

public class TimeBoard extends JPanel{
    public void paintComponent(Graphics g2) {
        super.paintComponent(g2);

        Graphics2D g = ((Graphics2D) g2); 

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		
        drawTimeBoard(g);
        drawLine(g);
        g.dispose();
	}

    private static void drawTimeBoard(Graphics g) {
        g.setColor(Color.decode("#8F7A66"));
        g.fillRect(0, 0, 300, 120);
	}
    private static void drawLine(Graphics2D g){
        g.setColor(Color.decode("#8F7A66"));
        g.setStroke(new BasicStroke(5));
        g.drawLine(150, 120, 150, 720);
    }
    
}
