import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel{
    final int PANEL_WIDTH = 1280;  
    final int PANEL_HEIGHT = 720;
    Panel(){
        this.setPreferredSize(new Dimension( PANEL_WIDTH , PANEL_HEIGHT));
    }
}