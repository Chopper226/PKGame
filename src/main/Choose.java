package main;

import javax.swing.Timer;

import java.awt.Font;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Random;

public class Choose extends Panel {
    private Frame frame;
    private String mode;
    private int version;
    private ArrayList <String> level;
    private Timer timer;
    private int index;
    private KeyBoard keyBoard;

    Choose( Frame frame ){
        super();
        this.frame = frame;
        this.mode = frame.getMode();
        this.version = frame.getVersion();
        this.level = new ArrayList<>();
        this.index = 0;
        this.keyBoard = new KeyBoard(this);
        this.addKeyListener(keyBoard);
        this.setFocusable(true);
    }

    public void resetSetting(){
        reset();
    }

    public void addNum ( String n ){
        inputAddNum(n);
    }

    public void deleteNum (){
        inputDeleteNum();
    }

    public void startGame(){
        frame.setLevel( level );
        frame.switchToStart();
    }

    private void reset(){
        mode = frame.getMode();
        version = frame.getVersion();
        if( mode.equals("Random") ) {
            timer = new Timer(400,new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if( index < version ){
                        randomChoose();
                        index ++;
                    }
                    else timer.stop();
                    repaint();
                }
            });
            timer.start();
        }
    }

    private void randomChoose(){
        Random rand = new Random();
        int num = rand.nextInt(8);
        num += 1;
        boolean check = true;
        for( int i = 0 ; i<level.size() ; i++ ){
            if( level.get(i).equals(String.valueOf(num)) ) check = false;
        }
        if( check ) level.add(String.valueOf(num));
        else randomChoose();
    }

    private void inputAddNum( String n ){
        if( level.size() <version ) {
            boolean check = true;
            for( int i = 0 ; i<level.size() ; i++ ){
                //if( level.get(i).equals(n) ) check = false;
            }
            if( check ) level.add(n);
        }
        
    }

    private void inputDeleteNum(){
        if( level.size() >0 ) level.remove(level.size()-1);
    }

    public void paintComponent(Graphics g2) {
		super.paintComponent(g2);

		Graphics2D g = ((Graphics2D) g2); 

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		;

        for( int i = 0 ; i<version ; i++ ){
            drawLine(g, i);
        }

        g.dispose();
	}

    private void drawLine(Graphics2D g , int x ){
        g.setColor(Color.decode("#8B7D7B"));
        g.setStroke( new BasicStroke(5) );
        if( version == 3 ) g.drawLine(315 + x*250, 650, 465+x*250, 650);
        else if( version == 5 ) g.drawLine(65 + x*250, 650, 215+x*250, 650);
    }

    private void drawText(Graphics g , int x , String text ){
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Arial" , Font.BOLD , 100));
        if( version == 3 )  g.drawString(text , 390 + 250*x - (int)(g.getFontMetrics().stringWidth(text)/2)  , 630);
        else if( version == 5 )  g.drawString(text , 140 + 250*x - (int)(g.getFontMetrics().stringWidth(text)/2)  , 630);
    }

    @Override
    public void paint(Graphics g2){
        Graphics2D g = ((Graphics2D) g2);

        super.paint(g);

        for( int i = 0 ; i<version ; i++ ){
            drawLine(g, i);
        }

        for( int i = 0 ; i<level.size() ; i++ ){
            drawText(g, i, level.get(i) );
        }
    }
    
}
