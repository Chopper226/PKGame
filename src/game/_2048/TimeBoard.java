package game._2048;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TimeBoard extends JPanel{
    static Font TimeFont = new Font("Arial" , Font.BOLD , 40);
    private int remainingTime = 180;
    private Timer timer;

    TimeBoard() {
        initTimer();
    }

    private void initTimer() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (remainingTime > 0) {
                    remainingTime--;
                } else {
                    timer.stop(); 
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
		
        drawTimeBoard(g);
        drawTimeText(g);
        //drawLine(g);
        drawTime(g);
        g.dispose();
	}

    @Override
    public void paint(Graphics g){
        super.paint(g);
        drawTime(g);
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
    
    private static void drawTimeText(Graphics g){
        String text = "T I M E" ;
        g.setFont(TimeFont);
        g.setColor(Color.WHITE);
        g.drawString(text , 300/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 45 );
    }

    private void drawTime( Graphics g ){
        String text = formatTime();
        g.setFont(TimeFont);
        g.setColor(Color.WHITE);
        g.drawString(text , 300/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 100 );
    }

    private String formatTime() {
        int minutes = remainingTime / 60;
        int seconds = remainingTime % 60;
        return String.format("%02d : %02d", minutes, seconds);
    }

}
