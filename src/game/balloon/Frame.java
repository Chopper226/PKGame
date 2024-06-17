package game.balloon;
import javax.swing.JFrame;

public class Frame extends JFrame{
    GamePanel gamepanel;

    public Frame(){
        gamepanel = new GamePanel(); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(gamepanel);
        this.pack();    
        this.setLocationRelativeTo(null);  
        this.setVisible(true);
    }
}