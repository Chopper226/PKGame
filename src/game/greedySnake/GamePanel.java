package game.greedySnake;

import main.GameOverListener;
import main.Panel;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends Panel{
    
    private TimeBoard tb;
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
        player1 = new PlayerSetting(685, 150, 985, 10, 1);
        this.add( player1.getGameBoard() );
        this.add( player1.getScoreBoard() );
        player2 = new PlayerSetting(45, 150, 45, 10, 2);
        this.add( player2.getGameBoard() );
        this.add( player2.getScoreBoard() );
        
        this.addKeyListener(player1.getGameBoard().getKeyBoard());
        this.addKeyListener(player2.getGameBoard().getKeyBoard());
        this.setFocusable(true);
        
        
        tb = new TimeBoard();
        tb.setBounds(490, 10, 300, 120);
        this.add(tb);

        checkGameOverTimer = new Timer(100,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if( player1.getGameBoard().getGameOver() && player2.getGameBoard().getGameOver() ){
                    checkGameOverTimer.stop();
                    tb.getTimer().stop();
                    winner = "Player2";
                    gameOverListener.GameOver(winner);
                }
                if( tb.getRemainingTime() == 0 ){
                    player1.getGameBoard().setGameOver( true );
                    player2.getGameBoard().setGameOver( true );
                }
            }
        });
        checkGameOverTimer.start();
    }
}