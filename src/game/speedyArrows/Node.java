package game.speedyArrows;

public class Node {
    private int x ;
    private int y ;
    private String direction;
    
    Node(){

    }
    
    Node( int x  , int y , String dir ){
        this.x = x;
        this.y = y;
        this.direction = dir;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String getDirection(){
        return direction;
    }
    
    public void setX( int x ){
        this.x = x;
    }

    public void setY( int y ){
        this.y = y ;
    }



}
