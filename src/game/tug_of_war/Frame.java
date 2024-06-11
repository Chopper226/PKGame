package game.tug_of_war;

import javax.swing.JFrame;

public class Frame extends JFrame {
    GamePanel gamePanel;

    public Frame() {
        gamePanel = new GamePanel(); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(gamePanel);
        this.pack();    
        this.setLocationRelativeTo(null);  
        this.setVisible(true);
    }
}
