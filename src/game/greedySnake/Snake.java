package game.greedySnake;

import java.util.ArrayList;

public class Snake {
    private Node head ;
    private ArrayList<Node> body;
    private int len ; // length

    Snake( Node node ){
        this.head = node;
        this.body = new ArrayList<Node>();
        this.len = 1;
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
}
