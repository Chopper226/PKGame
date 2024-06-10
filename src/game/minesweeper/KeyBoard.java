package game.minesweeper;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {
    private GameBoard gameBoard;
    private Bomb bombs[][];
    private int playerNumber;
    private Player player;

    KeyBoard( GameBoard gameBoard , Bomb bombs[][] ){
        this.gameBoard = gameBoard;
        this.bombs = bombs;
    }


    @Override
	public void keyTyped(KeyEvent e) {}

    @Override
	public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        resetPlayer();
        int keyCode = e.getKeyCode();
        int x = player.getX();
        int y = player.getY();
        if( gameBoard.getBombStart() == false ){
            if( playerNumber == 1 ){
                switch (keyCode) {
                    case KeyEvent.VK_W :
                        if( x-1 >= 0 ) player.setX(x-1);
                        break;
                    case KeyEvent.VK_S :
                        if( x+1 < gameBoard.getBombX() ) player.setX(x+1);
                        break; 
                    case KeyEvent.VK_A :
                        if( y-1 >= 0 ) player.setY(y-1);
                        break;
                    case KeyEvent.VK_D :
                        if( y+1 < gameBoard.getBombY() ) player.setY(y+1);
                        break;
                    case KeyEvent.VK_SPACE :
                        if( bombs[x][y].getVisit() == false ) gameBoard.updateBomb( x , y );
                        break;
                    default:
                        break;
                }
            }
            else if( playerNumber == 2 ){
                switch (keyCode) {
                    case KeyEvent.VK_UP :
                        if( x-1 >= 0 ) player.setX(x-1);
                        break;
                    case KeyEvent.VK_DOWN :
                        if( x+1 < gameBoard.getBombX() ) player.setX(x+1);
                        break; 
                    case KeyEvent.VK_LEFT :
                        if( y-1 >= 0 ) player.setY(y-1);
                        break;
                    case KeyEvent.VK_RIGHT :
                        if( y+1 < gameBoard.getBombY() ) player.setY(y+1);
                        break;
                    case KeyEvent.VK_COMMA :
                        if( bombs[x][y].getVisit() == false ) gameBoard.updateBomb( x , y );
                        break;
                    default:
                        break;
                }
            }
            gameBoard.repaint();
        }
    }

    private void resetPlayer(){
        this.playerNumber = gameBoard.getCurrentPlayer();
        this.player = gameBoard.getPlayer();
    }

}