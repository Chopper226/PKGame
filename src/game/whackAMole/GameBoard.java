package game.whackAMole;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Random;

public class GameBoard extends JPanel{
    private ArrayList <Mole> diglett ;
    private Player player1;
    private Player player2;
    private StatusBoard SB;
    private KeyBoard KB ;
    private boolean isGameOver;
    private Timer timer;
    
    final private int blockSize = 50;
    final private int gap = 10;
    final private int blockX = 9;
    final private int blockY = 20;

    GameBoard(){
        diglett = new ArrayList<>();

        player1 = new Player(0, 0);
        player2 = new Player(blockX-1, blockY-1);
        
        this.SB = new StatusBoard(this);

        this.isGameOver = false;

        this.KB = new KeyBoard( this ); 

        timer = new Timer(1300,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateDiglett();
                addDiglett();
                repaint();
            }
        });
        timer.start();
    }

    public int getBlockX(){
        return blockX;
    }

    public int getBlockY(){
        return blockY;
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2(){
        return player2;
    }

    public void judge( int keyCode ){
        judgeTouch(keyCode);
    }

    public StatusBoard getStatusBoard(){
        return SB;
    }

    public KeyBoard getKeyBoard(){
        return KB;
    }

    public boolean getGameOver(){
        return isGameOver;
    }

    public void setGameOver( boolean isGameOver ){
        this.isGameOver = isGameOver;
    }

    private void updateDiglett(){
        for( int i = 0 ; i<diglett.size() ; i++ ){
            if( diglett.get(i).getTime() == 5 ){
                diglett.remove(i);
                i--;
            }
            else diglett.get(i).setTime(diglett.get(i).getTime()+1);
        }
    }

    private void addDiglett(){
        Random rand = new Random();
        boolean check = true;
        while( check ){
            int x = rand.nextInt(blockX);
            int y = rand.nextInt(blockY);
            boolean tmp = false;
            for( int i = 0 ; i<diglett.size() ; i++ ){
                if( diglett.get(i).getX() == x && diglett.get(i).getY() == y ){
                    tmp = true;
                    break;
                }
            }
            diglett.add(new Mole(x, y));
            check = tmp;
        }
    }

    private void judgeTouch( int keyCode ){
        if( keyCode == KeyEvent.VK_SPACE ){
            int x = player1.getX();
            int y = player1.getY();
            for( int i = 0 ; i<diglett.size() ; i++ ){
                int tmpX = diglett.get(i).getX();
                int tmpY = diglett.get(i).getY();
                if( x == tmpX && y == tmpY ){
                    diglett.remove(i);
                    if( SB.getRemainingTime() <= 30 ) player1.setScore(player1.getScore()+5);
                    else player1.setScore(player1.getScore()+1);
                    break;
                }
            }
        }
        else if( keyCode == KeyEvent.VK_E ){
            int x = player2.getX();
            int y = player2.getY();
            for( int i = 0 ; i<diglett.size() ; i++ ){
                int tmpX = diglett.get(i).getX();
                int tmpY = diglett.get(i).getY();
                if( x == tmpX && y == tmpY ){
                    diglett.remove(i);
                    if( SB.getRemainingTime() <= 30 ) player2.setScore(player2.getScore()+5);
                    else player2.setScore(player2.getScore()+1);
                    break;
                }
            }
        }
    }
    
    public void paintComponent(Graphics g2) {
		super.paintComponent(g2);

		Graphics2D g = ((Graphics2D) g2); 

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		
        drawGameBoard(g);
        
        for( int i = 0 ; i<blockX ; i++ ){
            for( int j = 0 ; j<blockY ; j++ ){
                drawBlock(g, i, j);
            }
        }
        drawPlayer(g);
        
        for( int i = 0 ; i<diglett.size() ; i++){
            drawDiglett(g , diglett.get(i).getX() , diglett.get(i).getY() );
        }

        g.dispose();
	}

    private static void drawGameBoard(Graphics g) {
        g.setColor(Color.decode("#4F4F4F"));
        g.fillRect(0, 0, 1210, 550);
	}
    
    
    private void drawBlock(Graphics g , int i , int j){
        g.setColor(Color.decode("#CDCDC1"));
        g.fillRoundRect(gap + ( gap + blockSize ) * j , gap + ( gap + blockSize ) * i , blockSize , blockSize , 5 , 5);
    }

    private void drawPlayer(Graphics g){
        int x,y;
        x = player1.getX();
        y = player1.getY();
        g.setColor(new Color( 250 ,128 , 114 , 120 ));
        g.fillRoundRect(gap + ( gap + blockSize ) * y -5 , gap + ( gap + blockSize ) * x -5 , blockSize+10 , blockSize+10 , 5 , 5);
        
        x = player2.getX();
        y = player2.getY();
        g.setColor(new Color( 96 ,123 , 139 , 120 )); 
        g.fillRoundRect(gap + ( gap + blockSize ) * y -5 , gap + ( gap + blockSize ) * x -5 , blockSize+10 , blockSize+10 , 5 , 5);
    }

    private void drawDiglett(Graphics g , int i , int j){
        g.setColor(Color.DARK_GRAY);
        g.fillOval(gap + ( gap + blockSize ) * j + 10 , gap + ( gap + blockSize ) * i + 10  , 30 ,  30);
    }

    
    private void drawGameOver(Graphics g){
        String text = "Game Over !";
        g.setColor( new Color( 	245 ,245 , 245, 200 ));  		 
        g.fillRect(0 , 0 , 1210 , 550 );
        g.setColor(Color.decode("#CD3333"));
        g.setFont(new Font("Arial" , Font.BOLD , 80));
        g.drawString(text, 1210/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 570/2);
    }
    

    @Override
    public void paint(Graphics g){
        super.paint(g);

        drawPlayer(g);
        for( int i = 0 ; i<diglett.size() ; i++){
            drawDiglett(g , diglett.get(i).getX() , diglett.get(i).getY() );
        }

        SB.repaint();

        if( isGameOver ){
            drawGameOver(g);
            repaint();
        }
    }

}