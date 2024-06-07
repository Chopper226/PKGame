package game.greedySnake;

import main.Panel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends Panel{
    
    TimeBoard tb;
    PlayerSetting player1 ,player2;
    Timer checkGameOverTimer;

    public GamePanel(){
        super();
       
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