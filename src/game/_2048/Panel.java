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
    GameBoard gb1;
    ScoreBoard sb1;
    GamePanel(){
        super();
        gb1 = new GameBoard();
        gb1.setBounds(680, 145, 550, 550);
        this.add(gb1);
        sb1 = new ScoreBoard(gb1);
        sb1.setBounds(980 , 10 , 250 , 120);
        this.add(sb1);
        /* 
        gb2 = new GameBoard();
        gb2.setBounds(50, 145, 550, 550);
        this.add(gb2);
        */
    }
}