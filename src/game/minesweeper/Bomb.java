package game.minesweeper;

import java.awt.Font;
import java.awt.Color;

public class Bomb {
    private Font font = new Font("Arial" , Font.BOLD , 35);
    private boolean isBomb;
    private int value;
    private boolean visit;

    Bomb( boolean bomb ){
        this.isBomb = bomb;
        this.value = 9;
        this.visit = false;
    }
    
    public boolean getIsBomb(){
        return isBomb;
    }

    public boolean getVisit(){
        return visit;
    }
    
    public void setVisit( boolean visit ){
        this.visit = visit;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public Color getFontColor(){
        return FontColor();
    }

    public Color getBackGroundColor(){
        return BackGroundColor();
    }

    public Font getBlockFont(){
        return font;
    }

    private Color FontColor(){
        switch (value) {
            case 0:
                return Color.decode("#CDC1B4");
            case 2:
                return Color.decode("#776E65");
            case 4:
                return Color.decode("#776E65");
            default:
                return Color.WHITE;
        }
    }

    private Color BackGroundColor(){
        if( visit ) return Color.decode("#ADB6D5");
        else return Color.decode("#4E64CA");
    }


}

/*
14 * 11
6*7 *13
*/
