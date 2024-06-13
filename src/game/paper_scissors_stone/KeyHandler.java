package game.paper_scissors_stone;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private GamePanel gamePanel;
    private Player player;
    private TimeBoard timeBoard;

    private boolean player1InputReceived = false;
    private boolean player2InputReceived = false;

    public KeyHandler(GamePanel gamePanel, TimeBoard timeBoard, Player player) {
        this.gamePanel = gamePanel;
        this.timeBoard = timeBoard;
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (timeBoard.playerInputAllowed) {
            int keyCode = e.getKeyCode();
            if (!player1InputReceived && (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_D)) {
                player.setPlayer1Choice(e);
                player1InputReceived = true;
                gamePanel.updatePlayerChoices(player);
                System.out.println("player1 : " + player.getPlayer1Choice());
            } else if (!player2InputReceived && (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT)) {
                player.setPlayer2Choice(e);
                player2InputReceived = true;
                gamePanel.updatePlayerChoices(player);
                System.out.println("player2 : " + player.getPlayer2Choice());
            }
        }
        if (player1InputReceived && player2InputReceived) {
            timeBoard.playerInputAllowed = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}