package game._2048;

import javax.swing.JFrame;

class Frame extends JFrame{
    Panel panel ;

    Frame(){
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