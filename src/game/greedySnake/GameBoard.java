package game.greedySnake;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameBoard extends JPanel{

    private Snake snake;
    private int score ;
    private Move move ; 
    private KeyBoard KB ;
    private ScoreBoard SB ;
    private Timer addBodyTimer;
    private Timer runTimer;

    GameBoard(){
        this.snake = new Snake(randomStart());
        this.score = 0;
        this.SB = new ScoreBoard(this);

        this.move = new Move( snake , this );
        this.KB = new KeyBoard( this , SB); 
        this.addKeyListener(KB);
        this.setFocusable(true);

        addBodyTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBody(snake);
            }
        });

        runTimer = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                run();
                repaint();
            }
        });
        
        addBodyTimer.start();
        runTimer.start();

        //if( playerNumber == 1 ) KB = new KeyBoard( move, this , SB );
        //else if( playerNumber == 2) KB = new Player2KeyBoard( move, this , SB );

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

    private Node randomStart(){
        Node start;
        Random rand = new Random();
        int x = rand.nextInt(440) + 55 ;
        int y = rand.nextInt(440) + 55 ;
        start = new Node(x, y);
        return start;
    }
    /*
    private boolean gameOver(){
    }
    */
    private void addBody( Snake snake ){
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

        if( dir.equals("UP") ) snake.getBody().add( new Node( x , y-5 ) );
        else if( dir.equals("DOWN") ) snake.getBody().add( new Node( x , y+5 ) );
        else if( dir.equals("RIGHT") ) snake.getBody().add( new Node( x+5 , y ) );
        else snake.getBody().add( new Node( x-5 , y ) );

        snake.getBody().get(snake.getBody().size()-1).setDirection(dir);
    }

    private void run(){
        String dir = snake.getHead().getDirection();
        if( dir.equals("UP") ) move.up();
        else if( dir.equals("DOWN") ) move.down();
        else if( dir.equals("RIGHT") ) move.right();
        else move.left();
    }

    public void paintComponent(Graphics g2) {
		super.paintComponent(g2);

		Graphics2D g = ((Graphics2D) g2); 

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		
        drawGameBoard(g);
        drawSnakeHead(g);
		
        g.dispose();
	}

    private static void drawGameBoard(Graphics g) {
        g.setColor(Color.decode("#BBADA0"));
        g.fillRect(0, 0, 550, 550);
	}
    
    private void drawSnakeHead(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval( snake.getHead().getX() , snake.getHead().getY() , 20 , 20 );
    }
    
    private void drawSnakeBody(Graphics g , int x , int y){
        g.setColor(Color.GRAY);
        g.fillOval( x , y , 20 , 20 );
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
        /*
        if( gameOver() ){

        }
        */
    }
}