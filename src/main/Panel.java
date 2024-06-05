package main;

import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel{
    public final int PANEL_WIDTH = 1280;  
    public final int PANEL_HEIGHT = 720;
    public Panel(){
        this.setPreferredSize(new Dimension( PANEL_WIDTH , PANEL_HEIGHT));
    }

}