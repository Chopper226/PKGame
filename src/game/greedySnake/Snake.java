package game.greedySnake;

import java.util.ArrayList;

public class Snake {
    private Node head ;
    private ArrayList<Node> body;
    private int len ; // length
    private int speed;

    Snake( Node node ){
        this.head = node;
        this.body = new ArrayList<Node>();
        this.len = 1;
        this.speed = 200;
    }

    public Node getHead(){
        return head;
    }

    public ArrayList<Node> getBody(){
        return body;
    }

    public int getLen(){
        return len;
    }

    public void setLen( int len ){
        this.len = len;
    }

    public int getSpeed(){
        return speed;
    }

    public void updateSpeed(){
        changeSpeed();
    }

    private void changeSpeed(){
        if( body.size()+1 < 5 ) speed = 200;
        else if( body.size()+1 < 10 ) speed = 180;
        else if( body.size()+1 < 15 ) speed = 150;
        else if( body.size()+1 < 20 ) speed = 130;
        else speed = 100;
    }
}
