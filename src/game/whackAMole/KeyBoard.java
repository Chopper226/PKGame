package game.whackAMole;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener { 
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;

    KeyBoard( GameBoard gameBoard  ){
        this.gameBoard = gameBoard;
        player1 = gameBoard.getPlayer1();
        player2 = gameBoard.getPlayer2();
    }


    @Override
	public void keyTyped(KeyEvent e) {}

    @Override
	public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int x1 = player1.getX();
        int y1 = player1.getY();
        int x2 = player2.getX();
        int y2 = player2.getY();

        if( gameBoard.getGameOver() == false ){
            switch (keyCode) {
                case KeyEvent.VK_W :
                    if( x1-1 >= 0 ) player1.setX(x1-1);
                    break;
                case KeyEvent.VK_S :
                    if( x1+1 < gameBoard.getBlockX() ) player1.setX(x1+1);
                    break; 
                case KeyEvent.VK_A :
                    if( y1-1 >= 0 ) player1.setY(y1-1);
                    break;
                case KeyEvent.VK_D :
                    if( y1+1 < gameBoard.getBlockY() ) player1.setY(y1+1);
                    break;
                case KeyEvent.VK_SLASH :
                    gameBoard.judge(keyCode);
                    break;
                case KeyEvent.VK_UP :
                    if( x2-1 >= 0 ) player2.setX(x2-1);
                    break;
                case KeyEvent.VK_DOWN :
                    if( x2+1 < gameBoard.getBlockX() ) player2.setX(x2+1);
                    break; 
                case KeyEvent.VK_LEFT :
                    if( y2-1 >= 0 ) player2.setY(y2-1);
                    break;
                case KeyEvent.VK_RIGHT :
                    if( y2+1 < gameBoard.getBlockY() ) player2.setY(y2+1);
                    break;
                case KeyEvent.VK_SPACE :
                    gameBoard.judge(keyCode);
                    break;
                default:
                    break;
            }
            gameBoard.repaint();
        }
    }
}