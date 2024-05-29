package game.greedySnake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {
    protected GameBoard gameBoard;
    protected ScoreBoard scoreBoard;

    public KeyBoard( GameBoard gameBoard , ScoreBoard scoreBoard ){
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
                gameBoard.getSnake().getHead().setDirection("UP");
                break;
            case KeyEvent.VK_DOWN :
                gameBoard.getSnake().getHead().setDirection("DOWN");
                break; 
            case KeyEvent.VK_LEFT :
                gameBoard.getSnake().getHead().setDirection("LEFT");
                break;
            case KeyEvent.VK_RIGHT :
                gameBoard.getSnake().getHead().setDirection("RIGHT");
                break;
            default:
                break;
        }
        gameBoard.repaint();
    }

}

class Player2KeyBoard extends KeyBoard {
    
    Player2KeyBoard( GameBoard gameBoard , ScoreBoard scoreBoard ){
        super(gameBoard, scoreBoard);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W :
                
            case KeyEvent.VK_S :
                
            case KeyEvent.VK_A :
                
            case KeyEvent.VK_D :
                
            default:
                break;
        }
        gameBoard.repaint();
        scoreBoard.repaint();
    }
}
