package game.minesweeper;


public class Player {
    private int x;
    private int y;

    Player( int x , int y ){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX( int x ){
        this.x = x;
    }

    public void setY( int y ){
        this.y = y;
    }
}
