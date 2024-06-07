 
package game._2048;


import main.Panel;

import javax.swing.JFrame;

public class Frame extends JFrame{
    Panel panel ;

    Frame(){
        panel = new Panel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
class GameFrame extends Frame{
    GameFrame(){
        super();
        this.remove(panel);
        panel = new GamePanel();
        this.add(panel);
        this.revalidate();
        this.repaint();
        panel.requestFocusInWindow();
    }
}