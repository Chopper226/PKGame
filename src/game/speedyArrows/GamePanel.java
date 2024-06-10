package game.speedyArrows;

import main.GameOverListener;
import main.Panel;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends Panel{
    
    private PlayerSetting player1 ,player2;
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
        player1 = new PlayerSetting(15, 140, 15 , 215 ,  425 , 10, 1);
        this.add( player1.getGameBoard() );
        this.add( player1.getScoreBoard() );
        this.add( player1.getTimeBoard() );
        this.add( player1.getComboBoard() );
        player2 = new PlayerSetting(655, 140, 655, 855, 1065, 10, 2);
        this.add( player2.getGameBoard() );
        this.add( player2.getScoreBoard() );
        this.add( player2.getTimeBoard() );
        this.add( player2.getComboBoard() );
        
        this.addKeyListener(player1.getGameBoard().getKeyBoard());
        this.addKeyListener(player2.getGameBoard().getKeyBoard());
        this.setFocusable(true);
        
        
        checkGameOverTimer = new Timer(100,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if( player1.getGameBoard().getGameOver() && player2.getGameBoard().getGameOver() ){
                    checkGameOverTimer.stop();
                    start = false;
                    if( player1.getGameBoard().getScore() > player2.getGameBoard().getScore() ) winner = "Player1";
                    else if( player1.getGameBoard().getScore() < player2.getGameBoard().getScore() ) winner = "Player2";
                    else winner = "Tie";
                    gameOverListener.GameOver(winner);
                }
            }
        });
        checkGameOverTimer.start();
    }
}