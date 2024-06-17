package main.instructions;

import main.Panel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Instruction_whackAMole extends Panel{
    private Image backgroundImage;

    public Instruction_whackAMole(){
        this.backgroundImage = new ImageIcon("res\\instructions\\whackAMole.png").getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this); 
        }
        g.dispose();
	}
}
