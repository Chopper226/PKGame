package main;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;



public class GameOver extends Panel {
    private Font font = new Font("Arial" , Font.BOLD , 40);
    private JButton switchExitButton;
    private JButton restartButton;
    private String winner;

    private Image player1Background;
    private Image player2Background;
    private Image tieBackground;

    GameOver(Frame frame){
        initExitButton(frame);
        initRestartButton(frame);
    }

    public void setWinner( String winner ){
        this.winner = winner;
        repaint();
    }

    private void initExitButton(Frame frame){
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

    private void initRestartButton(Frame frame){
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

        if (winner != null) {
            switch (winner) {
                case "Player1":
                    g.drawImage(player1Background, 0, 0, getWidth(), getHeight(), this);
                    break;
                case "Player2":
                    g.drawImage(player2Background, 0, 0, getWidth(), getHeight(), this);
                    break;
                case "Tie":
                    g.drawImage(tieBackground, 0, 0, getWidth(), getHeight(), this);
                    break;
                default:
                    g.drawImage(tieBackground, 0, 0, getWidth(), getHeight(), this);
                    break;
            }
        }
	}
}

