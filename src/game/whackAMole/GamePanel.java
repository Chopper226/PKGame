package game.whackAMole;

import main.Panel;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends Panel{
    
    GameBoard gb;
    StatusBoard sb;
    Timer checkGameOverTimer;

    public GamePanel(){
        super();

        gb = new GameBoard();
        gb.setBounds(35, 150 , 1210, 550);
        this.add(gb);

        this.addKeyListener(gb.getKeyBoard());
        this.setFocusable(true);

        sb = gb.getStatusBoard();
        sb.setBounds(35, 15, 1210 , 120);
        this.add(sb);
        
        checkGameOverTimer = new Timer(100,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if( gb.getGameOver() ) {
                    
                }
            }
        });
        checkGameOverTimer.start();
    }
}