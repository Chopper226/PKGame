package game.whackAMole;

import main.GameOverListener;
import main.Panel;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends Panel{
    
    private GameBoard gameBoard;
    private StatusBoard statusBoard;
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
        gameBoard.setBounds(35, 150 , 1210, 550);
        this.add(gameBoard);

        this.addKeyListener(gameBoard.getKeyBoard());
        this.setFocusable(true);

        statusBoard = gameBoard.getStatusBoard();
        statusBoard.setBounds(35, 15, 1210 , 120);
        this.add(statusBoard);
        
        checkGameOverTimer = new Timer(100,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if( gameBoard.getGameOver() ) {
                    checkGameOverTimer.stop();
                    start = false;
                    if( gameBoard.getPlayer1().getScore() > gameBoard.getPlayer2().getScore() ) winner = "Player1";
                    else if( gameBoard.getPlayer1().getScore() < gameBoard.getPlayer2().getScore() ) winner = "Player2";
                    else winner = "Tie";
                    gameOverListener.GameOver(winner);
                }
            }
        });
        checkGameOverTimer.start();
    }
}