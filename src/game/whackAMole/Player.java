package game.whackAMole;


public class Player {
    private int x;
    private int y;
    private int score;

    Player( int x , int y ){
        this.x = x;
        this.y = y;
        this.score = 0;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getScore(){
        return score;
    }

    public void setX( int x ){
        this.x = x;
    }

    public void setY( int y ){
        this.y = y;
    }

    public void setScore( int score ){
        this.score = score;
    }
}
