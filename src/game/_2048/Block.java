package game._2048;

import java.awt.Font;
import java.awt.Color;

public class Block{
    
    private Font font1 = new Font("Arial" , Font.BOLD , 75);
    private Font font2 = new Font("Arial" , Font.BOLD , 70);
    private Font font3 = new Font("Arial" , Font.BOLD , 60);
    private Font font4 = new Font("Arial" , Font.BOLD , 48);
    private int value;
    
    Block(){
        this.value = 0;
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
        return BlockFont();
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
        switch (value) {
            case 0:
                return Color.decode("#CDC1B4");
            case 2:
                return Color.decode("#EEE4DA");
            case 4:
                return Color.decode("#EEE1C9");
            case 8:
                return Color.decode("#F3B27A");
            case 16:
                return Color.decode("#F69664");
            case 32:
                return Color.decode("#F77C5F");
            case 64:
                return Color.decode("#F75F3B");
            case 128:
                return Color.decode("#EDD073");
            case 256:
                return Color.decode("#EDCC62");
            case 512:
                return Color.decode("#EDC950");  
            case 1024:
                return Color.decode("#EDC53F");
            case 2048:
                return Color.BLACK;
            default:
                return Color.decode("#BBADA0");
        }
    }

    private Font BlockFont(){
        if( value < 10 ) return font1;
        else if( value < 100 ) return font2;
        else if( value < 1000 ) return font3;
        return font4;
    }

}

