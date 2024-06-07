package game.speedyArrows;

import main.Panel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends Panel{

    PlayerSetting player1 ,player2;
    Timer checkGameOverTimer;
    
    public GamePanel(){

        super();

        player1 = new PlayerSetting(655, 140, 655, 855, 1065, 10, 1);
        this.add( player1.getGameBoard() );
        this.add( player1.getScoreBoard() );
        this.add( player1.getTimeBoard() );
        this.add( player1.getComboBoard() );
        player2 = new PlayerSetting(15, 140, 15 , 215 ,  425 , 10, 2);
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
                    
                }
            }
        });
        checkGameOverTimer.start();
        
    }
}