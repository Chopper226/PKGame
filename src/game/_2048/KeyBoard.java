package game._2048;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {
    private Move move ;
    private GameBoard gameBoard;

    public KeyBoard( Move move , GameBoard gameBoard){
        this.move = move;
        this.gameBoard = gameBoard;
    }


    @Override
	public void keyTyped(KeyEvent e) {}

    @Override
	public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP :
                move.up();
                gameBoard.createBlocks();
                break;
            case KeyEvent.VK_DOWN :
                move.down();
                gameBoard.createBlocks();
                break;
            case KeyEvent.VK_LEFT :
                move.left();
                gameBoard.createBlocks();
                break;
            case KeyEvent.VK_RIGHT :
                move.right();
                gameBoard.createBlocks();
                break;
            default:
                break;
        }
        gameBoard.repaint();
    }

}