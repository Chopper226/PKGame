package main;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;



public class GameOver extends Panel {
    private Frame frame;
    private JButton switchExitButton;
    private JButton restartButton;
    private String winner;

    private Image player1Background;
    private Image player2Background;
    private Image tieBackground;

    GameOver(Frame frame){
        this.frame = frame;
        initExitButton();
        initRestartButton();
        loadImages();
    }

    private void loadImages() {
        try {
            player1Background = ImageIO.read(new File("res\\gameOver\\player1win.png"));
            player2Background = ImageIO.read(new File("res\\gameOver\\player2win.png"));
            tieBackground = ImageIO.read(new File("res\\gameOver\\tied.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setWinner( String winner ){
        this.winner = winner;
        repaint();
    }

    private void initExitButton(){
        ImageIcon exiticon = new ImageIcon(Interface.class.getResource("/gameOver/exit.png"));
        switchExitButton = new JButton(exiticon);
        switchExitButton.setBounds(520, 500, 326, 98);
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
        ImageIcon restarticon = new ImageIcon(Interface.class.getResource("/gameOver/restart.png"));
        restartButton = new JButton(restarticon);
        restartButton.setBounds(510, 360, 339, 102);
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

