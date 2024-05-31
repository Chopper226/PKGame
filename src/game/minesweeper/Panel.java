package game.minesweeper;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel{
    final int PANEL_WIDTH = 1280;  
    final int PANEL_HEIGHT = 720;

    Panel(){
        this.setPreferredSize(new Dimension( PANEL_WIDTH , PANEL_HEIGHT ));
        this.setLayout(null);
    }
}


class GamePanel extends Panel{
    
    GameBoard gb;
    //Timer checkGameOverTimer;

    GamePanel(){
        super();

        gb = new GameBoard();
        gb.setBounds(290, 10, 700, 700);
        this.add(gb);

        this.addKeyListener(gb.getKeyBoard());
        this.setFocusable(true);
       
        /*
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
        */
    }
}