package game._2048;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {
    protected Move move ;
    protected GameBoard gameBoard;

    public KeyBoard( Move move , GameBoard gameBoard  ){
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
        if( gameBoard.getGameOver() == false ){
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
        }
    }

}

class Player1KeyBoard extends KeyBoard {
    
    Player1KeyBoard( Move move , GameBoard gameBoard ){
        super(move, gameBoard);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if( gameBoard.getGameOver() == false ){
            switch (keyCode) {
                case KeyEvent.VK_W :
                    move.up();
                    if( move.getCheck() ) gameBoard.createBlocks();
                    break;
                case KeyEvent.VK_S :
                    move.down();
                    if( move.getCheck() ) gameBoard.createBlocks();
                    break;
                case KeyEvent.VK_A :
                    move.left();
                    if( move.getCheck() ) gameBoard.createBlocks();
                    break;
                case KeyEvent.VK_D :
                    move.right();
                    if( move.getCheck() ) gameBoard.createBlocks();
                    break;
                default:
                    break;
            }
            gameBoard.repaint();
        }
    }
}