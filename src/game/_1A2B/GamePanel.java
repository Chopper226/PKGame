package game._1A2B;

import main.Panel;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends Panel{
    
    GameBoard gb;
    Timer checkGameOverTimer;

    public GamePanel(){
        super();

        gb = new GameBoard();
        gb.setBounds(0, 0 , 1280, 720);
        this.add(gb);

        this.addKeyListener(gb.getKeyBoard());
        this.setFocusable(true);

        checkGameOverTimer = new Timer(100,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if( gb.getGameOver() ) {
                    
                }
            }
        });
        checkGameOverTimer.start();
    }
}