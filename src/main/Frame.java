package main;

import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    private Interface panel1;
    private game.ballgame.GamePanel panel2;
    private CardLayout cardLayout;

    public Frame() {
        setTitle("Panel Switching Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new Interface();
        panel2 = new game.ballgame.GamePanel();

        cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);

        getContentPane().add(panel1, "panel1");

        getContentPane().add(panel2, "panel2");

        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.BLACK);


    }

}
