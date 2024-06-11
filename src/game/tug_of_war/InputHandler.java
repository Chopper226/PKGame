package game.tug_of_war;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    private Knot knot;
    private GamePanel gamePanel;
    private boolean player1AKeyIsPressed = false;
    private boolean player2RightKeyIsPressed = false;

    public InputHandler(Knot knot, GamePanel gamePanel) {
        this.knot = knot;
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (GamePanel.isGameOver()) return;

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A && !player1AKeyIsPressed) {
            knot.moveLeft();
            player1AKeyIsPressed = true;
        } else if (key == KeyEvent.VK_RIGHT && !player2RightKeyIsPressed) {
            knot.moveRight();
            player2RightKeyIsPressed = true;
        }

        if (knot.getX() <= 0 || knot.getX() >= 1280 - Knot.WIDTH) {
            GamePanel.endGame();
        }

        gamePanel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A) {
            player1AKeyIsPressed = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            player2RightKeyIsPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
