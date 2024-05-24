package game._2048;

import java.awt.*;
import javax.swing.*;


class Frame extends JFrame{
    Panel panel ;

    Frame(){
        panel = new GamePanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        
        this.setBackground(Color.decode("#FAF8EF"));
        
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }


}

public class main {
    public static void main(String[] args) {
        Frame frame = new Frame();
    }
}

