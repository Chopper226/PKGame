package game.greedySnake;

public class Node {
    private int x ;
    private int y ;
    private String direction;

    Node( int x  , int y ){
        this.x = x;
        this.y = y;
        this.direction = dir( x , y );
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
        this.y = y ;
    }

    public void setDirection( String dir ){
        this.direction = dir;
    }

    public String getDirection(){
        return direction;
    }

    private String dir( int x , int y){
        if( x<=550/2 ){
            if ( y<=550/2 ){
                if( x<y ) return "RIGHT";
                else return "DOWN";
            }
            else {
                if( x<y-550/2 ) return "RIGHT";
                else return "UP";
            }
        }
        else{
            if ( y<=550/2 ){
                if( x-550/2<y ) return "LEFT";
                else return "DOWN";
            }
            else {
                if( x<y ) return "LEFT";
                else return "UP";
            }
        }
    }
}
