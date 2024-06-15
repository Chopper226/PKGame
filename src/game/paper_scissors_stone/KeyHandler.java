package game.paper_scissors_stone;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private GamePanel gamePanel;
    private Player player;
    private TimeBoard timeBoard;
    private Judge judge;

    private boolean player1InputReceived = false;
    private boolean player2InputReceived = false;
    private boolean resultDone = false;

    public KeyHandler(GamePanel gamePanel, TimeBoard timeBoard, Player player) {
        this.gamePanel = gamePanel;
        this.timeBoard = timeBoard;
        this.player = player;
        this.judge = new Judge();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (timeBoard.playerInputAllowed) {
            int keyCode = e.getKeyCode();
            if (!player1InputReceived && (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_D)) {
                player.setPlayer1Choice(e);
                player1InputReceived = true;
                gamePanel.updatePlayerChoices(player);
            } else if (!player2InputReceived && (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT)) {
                player.setPlayer2Choice(e);
                player2InputReceived = true;
                gamePanel.updatePlayerChoices(player);
            }

            if (player1InputReceived && player2InputReceived && !resultDone) {
                timeBoard.playerInputAllowed = false;
                String result = judge.determineWinner(player.getPlayer1Choice(), player.getPlayer2Choice());
                gamePanel.displayResult(result, judge.player1String, judge.player2String);
                resultDone = true;
                resetInputsForNextRound();
            } else if (timeBoard.inputTimesUp) {
                timeBoard.playerInputAllowed = false;
                String result = judge.determineWinner(player.getPlayer1Choice(), player.getPlayer2Choice());
                gamePanel.displayResult(result, judge.player1String, judge.player2String);
                resultDone = true;
                resetInputsForNextRound();
            }
        }
    }

    private void resetInputsForNextRound() {
        player1InputReceived = false;
        player2InputReceived = false;
        player.setPlayer1Choice((String) null);
        player.setPlayer2Choice((String) null);
        resultDone = false;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}