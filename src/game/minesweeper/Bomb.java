package game.minesweeper;

import java.awt.Font;
import java.awt.Color;

public class Bomb {
    private Font font = new Font("Arial" , Font.BOLD , 35);
    private boolean isBomb;
    private int x;
    private int y;
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

    public void setX( int x ){
        this.x = x;
    }

    public int getX(){
        return x;
    }

    public void setY( int y ){
        this.y = y;
    }

    public int getY(){
        return y;
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
            case 1:
                return Color.decode("#27408B");
            case 2:
                return Color.decode("#247146");
            case 3:
                return Color.decode("#B22222");
            case 4:
                return Color.decode("#8B1A1A");
            default:
                return Color.decode("#711414");
        }
    }

    private Color BackGroundColor(){
        if( visit ) return Color.decode("#ADB6D5");
        else return Color.decode("#778899");
    }


}