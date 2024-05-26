package game._2048;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {
    protected Move move ;
    protected GameBoard gameBoard;
    protected ScoreBoard scoreBoard;

    public KeyBoard( Move move , GameBoard gameBoard , ScoreBoard scoreBoard ){
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
        System.out.println("Key1 pressed: " + keyCode);
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

class Player2KeyBoard extends KeyBoard {
    Player2KeyBoard( Move move , GameBoard gameBoard , ScoreBoard scoreBoard ){
        super(move, gameBoard, scoreBoard);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println("Key2 pressed: " + keyCode);
        switch (keyCode) {
            case KeyEvent.VK_W :
                System.out.print(123);
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
        scoreBoard.repaint();
    }
}
