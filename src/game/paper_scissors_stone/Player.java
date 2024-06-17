package game.paper_scissors_stone;


import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {
    private String player1Choice;
    private String player2Choice;

    public String getPlayer1Choice() {
        return player1Choice;
    }

    public void setPlayer1Choice(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_A:
                this.player1Choice = "scissors";
                break;
            case KeyEvent.VK_S:
                this.player1Choice = "stone";
                break;
            case KeyEvent.VK_D:
                this.player1Choice = "paper";
                break;
        }
    }

    public void setPlayer1Choice(String choice) {
        this.player1Choice = choice;
    }

    public ImageIcon getPlayer1ChoiceImage() {
        if (player1Choice == null) return null;
        switch (player1Choice) {
            case "scissors":
                return new ImageIcon("res\\paper_scissors_stone\\scissors.png");
            case "stone":
                return new ImageIcon("res\\paper_scissors_stone\\scissors.png");
            case "paper":
                return new ImageIcon("res\\paper_scissors_stone\\paper.png");
            default:
                return null;
        }
    }

    public String getPlayer2Choice() {
        return player2Choice;
    }

    public void setPlayer2Choice(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                this.player2Choice = "scissors";
                break;
            case KeyEvent.VK_DOWN:
                this.player2Choice = "stone";
                break;
            case KeyEvent.VK_RIGHT:
                this.player2Choice = "paper";
                break;
        }
    }

    public void setPlayer2Choice(String choice) {
        this.player2Choice = choice;
    }

    public ImageIcon getPlayer2ChoiceImage() {
        if (player2Choice == null) return null;
        switch (player2Choice) {
            case "scissors":
                return new ImageIcon("res\\paper_scissors_stone\\scissors.png");
            case "stone":
                return new ImageIcon("res\\paper_scissors_stone\\scissors.png");
            case "paper":
                return new ImageIcon("res\\paper_scissors_stone\\paper.png");
            default:
                return null;
        }
    }
}