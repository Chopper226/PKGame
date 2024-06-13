package game.paper_scissors_stone;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Player {
    private String player1Choice;
    private String player2Choice;

    public void setPlayer1Choice(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                player1Choice = "scissors";
                break;
            case KeyEvent.VK_S:
                player1Choice = "stone";
                break;
            case KeyEvent.VK_D:
                player1Choice = "paper";
                break;
        }
    }

    public void setPlayer2Choice(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                player2Choice = "scissors";
                break;
            case KeyEvent.VK_DOWN:
                player2Choice = "stone";
                break;
            case KeyEvent.VK_RIGHT:
                player2Choice = "paper";
                break;
        }
    }

    public String getPlayer1Choice() {
        return player1Choice;
    }

    public String getPlayer2Choice() {
        return player2Choice;
    }

    public ImageIcon getPlayer1ChoiceImage() {
        return getChoiceImage(player1Choice);
    }

    public ImageIcon getPlayer2ChoiceImage() {
        return getChoiceImage(player2Choice);
    }

    private ImageIcon getChoiceImage(String choice) {
        if (choice == null) {
            return null;
        }
        String imagePath = choice + ".png";
        return new ImageIcon(getClass().getResource(imagePath));
    }
}