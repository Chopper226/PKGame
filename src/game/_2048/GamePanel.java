package game._2048;

import main.GameOverListener;
import main.Panel;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GamePanel extends Panel{
    private TimeBoard timeBoard;
    private PlayerSetting player1 ,player2;
    private Timer checkGameOverTimer;
    private GameOverListener gameOverListener;
    private boolean start;
    private String winner;

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
        
        player1 = new PlayerSetting(45, 150, 45, 10, 1);
        this.add( player1.getGameBoard() );
        this.add( player1.getScoreBoard() );
        player2 = new PlayerSetting(685, 150, 985, 10, 2);
        this.add( player2.getGameBoard() );
        this.add( player2.getScoreBoard() );
        
        this.addKeyListener(player1.getGameBoard().getKeyBoard());
        this.addKeyListener(player2.getGameBoard().getKeyBoard());
        this.setFocusable(true);

        timeBoard = new TimeBoard();
        timeBoard.setBounds(490, 10, 300, 120);
        this.add(timeBoard);

        checkGameOverTimer = new Timer(100,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if( player1.getGameBoard().getGameOver() && player2.getGameBoard().getGameOver() ) {
                    timeBoard.getTimer().stop();
                    checkGameOverTimer.stop();
                    start = false;
                    removeAll();
                    if( player1.getGameBoard().getScore() > player2.getGameBoard().getScore() ) winner = "Player1";
                    else if( player1.getGameBoard().getScore() < player2.getGameBoard().getScore() ) winner = "Player2";
                    else winner = "Tie";
                    gameOverListener.GameOver(winner);
                }
                else if( timeBoard.getRemainingTime() == 0 ){
                    player1.getGameBoard().setGameOver(true);
                    player2.getGameBoard().setGameOver(true);
                }
            }
        });
        checkGameOverTimer.start();
    }
}