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
    GameBoard gb1,gb2;
    ScoreBoard sb1,sb2;
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
        //player1.getScoreBoard().setKeyBoard(player1.getGameBoard().getKeyBoard());
        //player1.getScoreBoard().addKeyListener(player1.getGameBoard().getKeyBoard());
        //player2.getScoreBoard().setKeyBoard(player2.getGameBoard().getKeyBoard());
        
        /*
        gb1 = new GameBoard(1);
        gb1.setBounds(685, 150  , 550, 550);
        this.add(gb1);
        sb1 = new ScoreBoard(gb1);
        sb1.setBounds(985 , 10 , 250 , 120);
        this.add(sb1);
        */
        
        //this.requestFocusInWindow();

        //gb2 = new GameBoard(2);
        //gb2.setBounds(45, 150, 550, 550);
        //this.add(gb2);
        //sb2 = new ScoreBoard(gb2);
        //sb2.setBounds(45, 10 , 250 , 120);
        //this.add(sb2);

        tb = new TimeBoard();
        tb.setBounds(490, 10, 300, 720);
        this.add(tb);
        
    }
}