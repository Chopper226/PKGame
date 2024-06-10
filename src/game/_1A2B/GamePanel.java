package game._1A2B;

import main.Panel;
import main.GameOverListener;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends Panel{
    
    private GameBoard gameBoard;
    private Timer checkGameOverTimer;
    private GameOverListener gameOverListener;
    private String winner;
    private boolean start;

    public GamePanel(){
        super();
        
        this.start = false;
    }

    public void setStart( boolean start ){
        this.start = start;
        if( start ) init();
    }

    public void setGameOverListener(GameOverListener listener) {
        this.gameOverListener = listener;
    }

    private void init(){
        gameBoard = new GameBoard();
        gameBoard.setBounds(0, 0 , 1280, 720);
        this.add(gameBoard);

        this.addKeyListener(gameBoard.getKeyBoard());
        this.setFocusable(true);

        checkGameOverTimer = new Timer(100,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if( gameBoard.getGameOver() ) {
                    checkGameOverTimer.stop();
                    start = false;
                    if( gameBoard.getCurrentPlayer() == 1 ) winner = "Player1";
                    else winner = "Player2";
                    gameOverListener.GameOver(winner);
                }
            }
        });
        checkGameOverTimer.start();
    }
}