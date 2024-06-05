package game.whackAMole;

public class Mole {
    private int x;
    private int y;
    private int time;

    Mole( int x , int y ){
        this.x = x;
        this.y = y;
        this.time = 0;
    }

    public void setX( int x ){
        this.x = x;
    }

    public void setY( int y ){
        this.y = y;
    }

    public void setTime( int time ){
        this.time = time;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getTime(){
        return time;
    }
}
