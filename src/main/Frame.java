package main;

import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    private Interface panel1;
    private game._1A2B.GamePanel panel2;
    private CardLayout cardLayout;

    public Frame() {
        setTitle("Panel Switching Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new Interface(this);
        panel2 = new game._1A2B.GamePanel();

        cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);

        getContentPane().add(panel1, "panel1");

        getContentPane().add(panel2, "panel2");

        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.BLACK);
    }

    public void switchToPanel2() {
        cardLayout.show(getContentPane(), "panel2");
        panel2.setFocusable(true);
        panel2.requestFocusInWindow();
    }

}
