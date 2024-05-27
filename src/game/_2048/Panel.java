package game._2048;

import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel{
    final int PANEL_WIDTH = 1280;  
    final int PANEL_HEIGHT = 720;

    Panel(){
        this.setPreferredSize(new Dimension( PANEL_WIDTH , PANEL_HEIGHT ));
        this.setLayout(null);
    }
}


class GamePanel extends Panel{
    TimeBoard tb;
    PlayerSetting player1 ,player2;
    
    GamePanel(){
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
        
    }
}