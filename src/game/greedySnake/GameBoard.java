package game.greedySnake;

import java.awt.*;
import javax.swing.*;

import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameBoard extends JPanel{

    private Snake snake;
    private Node food;
    private int score ;
    private int foodScore;
    private Move move ; 
    private KeyBoard KB ;
    private ScoreBoard SB ;
    private Timer addBodyTimer;
    private Timer runTimer;

    GameBoard( int playerNumber ){

        this.snake = new Snake(randomPos());
        this.food = randomPos();
        if( eatFood() ) updateFood();

        this.score = 0;
        this.foodScore = 0;
        this.SB = new ScoreBoard(this);
        
        this.move = new Move(snake);

        addBodyTime();
        runTime();

        if( playerNumber == 1 ) KB = new KeyBoard(this);
        else if( playerNumber == 2) KB = new Player2KeyBoard(this);

    }

    public int getScore(){
        return score;
    }
    
    public void setScore( int num ){
        this.score = num;
    }

    public KeyBoard getKeyBoard(){
        return KB;
    }

    public ScoreBoard getScoreBoard(){
        return SB;
    }

    public Snake getSnake(){
        return snake;
    }

    public boolean getStatus(){
        return gameOver();
    };

    private Node randomPos(){
        Node start;
        Random rand = new Random();
        int x = rand.nextInt(440) + 55 ;
        int y = rand.nextInt(440) + 55 ;
        start = new Node(x, y);
        return start;
    }

    private void addBodyTime(){
        addBodyTimer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBody();
            }
        });
        addBodyTimer.start();
    }

    private void runTime(){
        runTimer = new Timer( snake.getSpeed() , new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                run();
                if( eatFood() ){
                    updateFood();
                    foodScore += 1;
                    for( int i = 0 ; i <3 ; i++ ){
                        addBody();
                    }
                }
                repaint();
            }
        });
        runTimer.start();
    }
    private boolean gameOver(){
        int x = snake.getHead().getX();
        int y = snake.getHead().getY();
        if( x <= 0 || x+25 >=550 || y <= 0 || y+25 >= 550 ){
            return true;
        }
        Node head = snake.getHead();
        for( int i = 0 ; i<snake.getBody().size() ; i++ ){
            Node body = snake.getBody().get(i);
            if( head.getX() == body.getX() && head.getY() == body.getY() ) return true;
        }
        return false;
    }
    
    private void addBody(){
        String dir ;
        int x,y;
        if( snake.getBody().isEmpty() ) {
            x = snake.getHead().getX();
            y = snake.getHead().getY();
            dir = snake.getHead().getDirection();
        }
        else{
            x = snake.getBody().get(snake.getBody().size()-1).getX();
            y = snake.getBody().get(snake.getBody().size()-1).getY();
            dir = snake.getBody().get(snake.getBody().size()-1).getDirection();
        }

        if( dir.equals("UP") ) snake.getBody().add( new Node( x , y+20 ) );
        else if( dir.equals("DOWN") ) snake.getBody().add( new Node( x , y-20 ) );
        else if( dir.equals("RIGHT") ) snake.getBody().add( new Node( x-20 , y ) );
        else snake.getBody().add( new Node( x+20 , y ) );

        snake.getBody().get(snake.getBody().size()-1).setDirection(dir);
        snake.setLen(snake.getLen()+1);
        snake.updateSpeed();
        updateScore();
        repaint();
    }

    private void run(){
        String dir = snake.getHead().getDirection();
        if( dir.equals("UP") ) move.up();
        else if( dir.equals("DOWN") ) move.down();
        else if( dir.equals("RIGHT") ) move.right();
        else move.left();
    }

    private void updateScore(){
        score = snake.getLen() + foodScore*5;
    }

    private boolean eatFood(){
        if( ( Math.abs(snake.getHead().getX() - food.getX() ) <= 15 ) && ( Math.abs(snake.getHead().getY() - food.getY() ) <= 15 ) ) return true;
        else return false;
    }

    private void updateFood(){
        boolean check = true;
        while( check ){
            food = randomPos();
            boolean tmp = false;
            Node now = snake.getHead();
            if( ( Math.abs(now.getX() - food.getX() ) <= 15 ) && ( Math.abs(now.getY() - food.getY() ) <= 15 ) ) tmp = true;
            if( !tmp ){
                for( int i = 0 ; i<snake.getBody().size() ; i++ ){
                    now = snake.getBody().get(i);
                    if( ( Math.abs(now.getX() - food.getX() ) <= 15 ) && ( Math.abs(now.getY() - food.getY() ) <= 15 ) ){
                        tmp = true;
                        break;
                    }
                }
            }
            check = tmp;
        }
    }

    public void paintComponent(Graphics g2) {
		super.paintComponent(g2);

		Graphics2D g = ((Graphics2D) g2); 

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		
        drawGameBoard(g);
        drawSnakeHead(g);
		drawFood(g);

        g.dispose();
	}

    private static void drawGameBoard(Graphics g) {
        g.setColor(Color.decode("#CDC0B0"));
        g.fillRect(0, 0, 550, 550);
	}
    
    private void drawSnakeHead(Graphics g){
        g.setColor(Color.decode("#363636"));
        g.fillOval( snake.getHead().getX() , snake.getHead().getY() , 20 , 20 );
    }
    
    private void drawSnakeBody(Graphics g , int x , int y){
        g.setColor(Color.decode("#828282"));
        g.fillOval( x , y , 20 , 20 );
    }

    private void drawFood(Graphics g){
        g.setColor(Color.decode("#4A708B"));
        g.fillRect( food.getX() , food.getY() , 15 ,15 );
    }

    private void drawGameOver(Graphics g){
        String text = "Game Over !";
        g.setColor( new Color( 	188 ,210 , 238	 , 120 ));  	
        g.fillRect(0 , 0 , 550 , 550 );
        g.setColor(Color.decode("#EE6A50"));
        g.setFont(new Font("Arial" , Font.BOLD , 50));
        g.drawString(text, 550/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 550/2);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        for( int i = 0 ; i<snake.getBody().size() ; i++ ){
            int x = snake.getBody().get(i).getX();
            int y = snake.getBody().get(i).getY();
            drawSnakeBody( g , x , y );
        }
        drawSnakeHead(g);
        SB.setScore( score );
        SB.repaint();
        if( gameOver() ){
            addBodyTimer.stop();
            runTimer.stop();
            drawGameOver(g);
            repaint();
        }
    }
}