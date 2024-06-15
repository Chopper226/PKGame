package main;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GameOver extends Panel {
    private Font font = new Font("Arial" , Font.BOLD , 40);
    private Frame frame;
    private JButton switchExitButton;
    private JButton restartButton;
    private String winner;


    GameOver(Frame frame){
        this.frame = frame;
        initExitButton();
        initRestartButton();
    }

    public void setWinner( String winner ){
        this.winner = winner;
        repaint();
    }

    private void initExitButton(){
        switchExitButton = new JButton("Exit");
        switchExitButton.setFont( new Font("Arial" , Font.BOLD , 25) );
        switchExitButton.setForeground(Color.WHITE);
        switchExitButton.setBackground(Color.GRAY);
        switchExitButton.setBounds(490, 300, 300, 120);
        switchExitButton.setFocusPainted(false);
        switchExitButton.setBorder(BorderFactory.createEmptyBorder());
        switchExitButton.setOpaque(true);
        this.add(switchExitButton);

        switchExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void initRestartButton(){
        restartButton = new JButton("Restart");
        restartButton.setFont( new Font("Arial" , Font.BOLD , 25) );
        restartButton.setForeground(Color.WHITE);
        restartButton.setBackground(Color.GRAY);
        restartButton.setBounds(490, 500, 300, 120);
        restartButton.setFocusPainted(false);
        restartButton.setBorder(BorderFactory.createEmptyBorder());
        restartButton.setOpaque(true);
        this.add(restartButton);

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.restart();        
            }
        });
    }


    public void paintComponent(Graphics g2) {
		super.paintComponent(g2);

		Graphics2D g = ((Graphics2D) g2); 

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        g.dispose();
	}

    private void drawWinner(Graphics g){
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString(winner ,640 , 200 );
    }


    @Override
    public void paint(Graphics g){
        super.paint(g);

        drawWinner(g);
        switchExitButton.repaint();
        restartButton.repaint();
    }
}

