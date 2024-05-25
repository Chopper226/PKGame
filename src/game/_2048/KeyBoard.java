package game._2048;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {
    private Move move ;
    private GameBoard gameBoard;
    private ScoreBoard scoreBoard;

    public KeyBoard( Move move , GameBoard gameBoard , ScoreBoard scoreBoard){
        this.move = move;
        this.gameBoard = gameBoard;
        this.scoreBoard = scoreBoard;
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
                if( move.getCheck() ) gameBoard.createBlocks();
                break;
            case KeyEvent.VK_DOWN :
                move.down();
                if( move.getCheck() ) gameBoard.createBlocks();
                break;
            case KeyEvent.VK_LEFT :
                move.left();
                if( move.getCheck() ) gameBoard.createBlocks();
                break;
            case KeyEvent.VK_RIGHT :
                move.right();
                if( move.getCheck() ) gameBoard.createBlocks();
                break;
            default:
                break;
        }
        gameBoard.repaint();
        scoreBoard.repaint();
    }

}