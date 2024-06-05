package main;


import javax.swing.SwingUtilities;


public class Main{
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Frame frame = new Frame();
            frame.pack();
            frame.setVisible(true);
        });
    }
}