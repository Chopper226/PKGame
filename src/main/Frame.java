package main;

import javax.swing.JFrame;

public class Frame extends JFrame{
    public Panel panel;

    public Frame(){
        panel = new Panel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(false);
    }
}