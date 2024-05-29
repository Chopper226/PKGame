package game.greedySnake;

import javax.swing.JFrame;

public class Frame extends JFrame{
    Panel panel ;

    public Frame(){
        panel = new GamePanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }
}
/*
class GameFrame extends Frame{
    Panel gamePanel;
    GameFrame(){
        super();
        gamePanel = new GamePanel();
        this.add(gamePanel);
    }
}
*/