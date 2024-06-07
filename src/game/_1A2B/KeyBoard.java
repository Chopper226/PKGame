package game._1A2B;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {
    private GameBoard gameBoard;

    KeyBoard( GameBoard gameBoard ){
        this.gameBoard = gameBoard;
    }


    @Override
	public void keyTyped(KeyEvent e) {}

    @Override
	public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if( gameBoard.getGameOver() == false && gameBoard.getJudge() == false ){
            int keyCode = e.getKeyCode();
            if( keyCode >= KeyEvent.VK_1 && keyCode <= KeyEvent.VK_9 ){
                gameBoard.addNum(String.valueOf(keyCode-48));
            }
            else if( keyCode == KeyEvent.VK_BACK_SPACE ){
                gameBoard.deleteNum();
            }
            else if( keyCode == KeyEvent.VK_ENTER ){
                gameBoard.StartJudge();
            }

            gameBoard.repaint();
        }
    }

}