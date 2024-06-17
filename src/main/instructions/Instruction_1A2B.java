package main.instructions;

import main.Panel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Instruction_1A2B extends Panel{
    private Image backgroundImage;

    public Instruction_1A2B(){
        this.backgroundImage = new ImageIcon("res\\instructions\\1A2B.png").getImage();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this); 
        }
        g.dispose();
	}
}
