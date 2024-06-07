package game.greedySnake;

public class Move {
    private Snake snake;

    Move( Snake snake ){
        this.snake = snake;
    }

    public void up(){
        moveUp();
    }

    public void down(){
        moveDown();
    }

    public void left(){
        moveLeft();
    }

    public void right(){
        moveRight();
    }

    private void moveUp(){
        if( !(snake.getBody().isEmpty()) ) updateBody();
        snake.getHead().setY(snake.getHead().getY()-20);
    }

    private void moveDown(){
        if( !(snake.getBody().isEmpty()) ) updateBody();
        snake.getHead().setY(snake.getHead().getY()+20);
    }

    private void moveLeft(){
        if( !(snake.getBody().isEmpty()) ) updateBody();
        snake.getHead().setX(snake.getHead().getX()-20);
    }

    private void moveRight(){
        if( !(snake.getBody().isEmpty()) ) updateBody();
        snake.getHead().setX(snake.getHead().getX()+20);
    }

    private void updateBody(){
        for( int i = snake.getBody().size()-1 ; i>0 ; i-- ){
            Node next = snake.getBody().get(i-1);
            snake.getBody().get(i).setX( next.getX() );
            snake.getBody().get(i).setY( next.getY() );
            snake.getBody().get(i).setDirection(next.getDirection());
        }
        snake.getBody().get(0).setX( snake.getHead().getX() );
        snake.getBody().get(0).setY( snake.getHead().getY() );
        snake.getBody().get(0).setDirection( snake.getHead().getDirection() );
    }
}
