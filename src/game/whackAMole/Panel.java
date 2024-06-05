package game.whackAMole;

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
    StatusBoard sb;
    Timer checkGameOverTimer;

    GamePanel(){
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