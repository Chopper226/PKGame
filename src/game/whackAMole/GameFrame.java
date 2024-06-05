package game.whackAMole;

import javax.swing.JFrame;
import main.Frame;

public class GameFrame extends Frame{
    public GameFrame(){
        super();
        this.remove(panel);
        panel = new GamePanel();
        this.add(panel);
        this.revalidate();
        this.repaint();
        panel.requestFocusInWindow();
    }
}