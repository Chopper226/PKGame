package main;

import java.awt.Dimension;
import javax.swing.JPanel;

public class Panel extends JPanel{
    final int PANEL_WIDTH = 1280;  
    final int PANEL_HEIGHT = 720;
    public Panel(){
        this.setPreferredSize(new Dimension( PANEL_WIDTH , PANEL_HEIGHT ));
        this.setLayout(null);
    }
}