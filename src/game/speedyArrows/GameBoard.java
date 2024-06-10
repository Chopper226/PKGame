package game.speedyArrows;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Random;


public class GameBoard extends JPanel{

    private ArrayList <Node> dir;
    private String now;
    private int score ; 
    private int combo ;
    private KeyBoard KB ;
    private ScoreBoard SB ;
    private TimeBoard TB;
    private ComboBoard CB;
    private boolean isGameOver;
    private Timer timer;

    GameBoard( int playerNumber ){
        dir = new ArrayList<Node>();
        initDir();
        this.now = "";

        this.score = 0;
        this.SB = new ScoreBoard(this);
        
        this.TB = new TimeBoard(this);
        this.combo = 0;
        this.CB = new ComboBoard(this);
        this.isGameOver = false;

        if( playerNumber == 1 ) KB = new Player1KeyBoard(this);
        else if( playerNumber == 2) KB = new KeyBoard(this);

    }
    
    public Node getFirst(){
        return dir.get(0);
    }

    public int getScore(){
        return score;
    }
    
    public int getCombo(){
        return combo;
    }

    public void setCombo( int combo ){
        this.combo = combo;
    }

    public void setNow( String now ){
        this.now = now;
    }

    public KeyBoard getKeyBoard(){
        return KB;
    }

    public ScoreBoard getScoreBoard(){
        return SB;
    }

    public TimeBoard getTimeBoard(){
        return TB;
    }

    public ComboBoard getComboBoard(){
        return CB;
    }

    public void updateDir(){
        move();
        updateInfo();
    }

    public boolean getGameOver(){
        return isGameOver;
    }

    public void setGameOver( boolean gameOver ){
        this.isGameOver = gameOver;
        repaint();
    }

    private void randomDir(){
        Random random = new Random();
        int tmp = random.nextInt(4);
        Node node = new Node();
        if( tmp == 0 ) node = new Node( 510 ,155 , "UP");
        else if( tmp == 1 ) node = new Node( 510 ,155 , "DOWN");
        else if( tmp == 2 ) node = new Node( 510 ,155 , "LEFT");
        else if( tmp == 3 ) node = new Node( 510 ,155 , "RIGHT");
        dir.add(node);
    }

    private void initDir(){
        Random random = new Random();

        for( int i = 1 ; i<4 ; i++){
            int tmp = random.nextInt(4);
            Node node = new Node();
            if( tmp == 0 ) node = new Node( 110*i + 90*(i-1) ,155 , "UP");
            else if( tmp == 1 ) node = new Node( 110*i + 90*(i-1) ,155 , "DOWN");
            else if( tmp == 2 ) node = new Node( 110*i + 90*(i-1) ,155 , "LEFT");
            else if( tmp == 3 ) node = new Node( 110*i + 90*(i-1) ,155 , "RIGHT");
            dir.add(node);
        }

    }

    private void move(){
        dir.remove(0);
        timer = new Timer(3, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for( int i = 0 ; i <dir.size() ; i++ ){
                    int x = dir.get(i).getX();
                    dir.get(i).setX( x-10 );
                }
                if ( dir.get(0).getX() <= 110 ) {
                    timer.stop();
                    randomDir();
                }
                repaint();
            }
        });
        timer.start();
    }

    private void updateInfo(){
        score += 1;
        combo += 1;
        if( combo%5 == 0 ) score += 10;
        if( combo%10 == 0 ) {
            int time = TB.getRemainingTime();
            TB.setRemainingTime(time+5);
        }

        SB.setScore(score);
        CB.setCombo(combo);
    }

    public void paintComponent(Graphics g2) {
		super.paintComponent(g2);

		Graphics2D g = ((Graphics2D) g2); 

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		
        drawGameBoard(g);
        drawDirBackGround(g);

        for( int i = 0 ; i<dir.size() ; i++){
            drawDir(g , dir.get(i) , i );
        }
        
        drawPlayer(g);

        g.dispose();
	}

    private static void drawGameBoard(Graphics g) {
        g.setColor(Color.decode("#47515C"));
        g.fillRect(0, 0, 610, 570);
	}

    private static void drawDirBackGround(Graphics g) {
        g.setColor( new Color( 	245 ,245 , 245 , 20 ));  	
        g.fillRect(30, 80, 550, 120);
	}

    private static void drawDir(Graphics g , Node node , int i) {
        if( i == 0 && node.getX() == 110) g.setColor(Color.WHITE);
        else g.setColor(new Color( 	156,156 , 156 , 80 ));
        g.setFont(new Font("Arial" , Font.BOLD , 40));
        String text = node.getDirection();
        g.drawString(text , node.getX() - (int)(g.getFontMetrics().stringWidth(text)/2) , node.getY());
	}

    private void drawPlayer(Graphics g ) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial" , Font.BOLD , 80));
        String text = now;
        g.drawString(text , 610/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 400);
	}
    
    private void drawGameOver(Graphics g){
        String text = "Game Over !";
        g.setColor( new Color( 	240 ,255 , 255 , 150 ));  	
        g.fillRect(0 , 0 , 610 , 570 );
        g.setColor(Color.decode("#CD3700"));
        g.setFont(new Font("Arial" , Font.BOLD , 80));
        g.drawString(text, 610/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 570/2);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        SB.repaint();
        CB.setCombo(combo);
        CB.repaint();
        
        if( isGameOver ){
            drawGameOver(g);
            repaint();
        }
    }

}