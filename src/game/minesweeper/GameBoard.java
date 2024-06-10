package game.minesweeper;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Random;

public class GameBoard extends JPanel{

    private Bomb[][] bombs;
    private ArrayList <Bomb> isBomb ;
    private int currentPlayer;
    private Player player1;
    private Player player2;
    private StatusBoard SB;
    private int revealBlock ;
    private int remainingBlock;
    private KeyBoard KB ;
    private boolean isGameOver;
    private boolean bombStart;
    private Timer timer;
    
    final private int blockSize = 50;
    final private int gap = 10;
    final private int bombX = 9;
    final private int bombY = 20;
    final private int bombNum = 55;

    GameBoard(){
        bombs = new Bomb[bombX][bombY];
        isBomb = new ArrayList<>();

        createBomb();
        initBomb();
        
        this.currentPlayer = choosePlayer();
        this.player1 = new Player(0 , 0);
        this.player2 = new Player(bombX-1 , bombY-1);
        
        this.revealBlock = 0;
        this.remainingBlock = bombX * bombY - bombNum;
        this.SB = new StatusBoard(this);

        this.isGameOver = false;
        this.bombStart = false;

        this.KB = new KeyBoard( this , bombs ); 
    }

    public Player getPlayer(){
        if( currentPlayer == 1 ) return player1;
        else return player2;
    }

    public int getBombX(){
        return bombX;
    }

    public int getBombY(){
        return bombY;
    }

    public int getCurrentPlayer(){
        return currentPlayer;
    }

    public int getRemaining(){
        return remainingBlock;
    }
    
    public int getRevealed(){
        return revealBlock;
    }

    public void randomChoose(){
        choose();
    }

    public StatusBoard getStatusBoard(){
        return SB;
    }

    public KeyBoard getKeyBoard(){
        return KB;
    }

    public void updateBomb( int x ,int y ){
        revealBomb( x , y );
        if( bombStart == false ) changePlayer();
    }

    public boolean getGameOver(){
        return isGameOver;
    }

    public boolean getBombStart(){
        return bombStart;
    }
    
    private void createBomb(){
        int now = 0;
        Random rand = new Random();

        while ( now < bombNum ) {
            boolean check = true;
            while( check ){
                int x = rand.nextInt(bombX);
                int y = rand.nextInt(bombY);
                boolean tmp = false;
                if( bombs[x][y] != null && bombs[x][y].getIsBomb() ) tmp = true;
                else {
                    bombs[x][y] = new Bomb(true);
                    isBomb.add(bombs[x][y]);
                    bombs[x][y].setX(x);
                    bombs[x][y].setY(y);
                }
                check = tmp;
            }
            now ++ ;
        }

    }
    
    private void initBomb(){
        for( int i = 0 ; i<bombX ; i++ ){
            for( int j = 0; j<bombY ; j++ ){
                if( bombs[i][j] == null ){
                    bombs[i][j] = new Bomb(false);
                }
            }
        }

        for( int i = 0 ; i<bombX ; i++ ){
            for( int j = 0; j<bombY ; j++ ){
                int cnt = 0;
                if( bombs[i][j].getIsBomb() ) continue;
                for( int m = -1 ; m<2 ; m++ ){
                    for( int n = -1 ; n<2 ; n++ ){
                        if( m==0 && n==0 ) continue;
                        if( i+m < bombX && j+n < bombY && i+m >= 0 && j+n >= 0) {
                            if( bombs[i+m][j+n].getIsBomb() ) cnt ++;
                        }
                    }
                }
                bombs[i][j].setValue(cnt);
            }
        }
    }

    private int choosePlayer(){
        Random rand = new Random();
        int player = rand.nextInt(2);
        player += 1;
        return player;
    }

    private void choose(){
        Random rand = new Random();
        boolean check = true;
        while( check ){
            int x = rand.nextInt(bombX);
            int y = rand.nextInt(bombY);
            boolean tmp = false;
            if( bombs[x][y].getVisit() ) tmp = true;
            else {
                if( currentPlayer == 1 ){
                    player1.setX(x);
                    player1.setY(y);
                }
                else if( currentPlayer == 2 ){
                    player2.setX(x);
                    player2.setY(y);
                }
                repaint();
                updateBomb(x, y);
            }
            check = tmp;
        }

    }

    private void revealBomb( int x , int y ){
        Bomb bomb = bombs[x][y];
        if( !(bomb.getVisit()) ){
            bomb.setVisit(true);
            
            revealBlock ++ ;
            remainingBlock --;
            SB.setRevealed(revealBlock);
            SB.setRemaining(remainingBlock);
            
            if( bomb.getValue() == 0 ){
                for( int i = -1 ; i<2 ; i++ ){
                    for( int j = -1 ; j<2 ; j++ ){
                        if( i == 0 && j == 0 ) continue;
                        if( x+i<bombX && y+j<bombY && x+i>=0 && y+j>=0 ){
                            Bomb now = bombs[x+i][y+j];
                            if( now.getVisit() == false && now.getIsBomb() == false ){
                                revealBomb( x+i , y+j );
                            }
                        }
                    }
                }
            }

            if( bomb.getIsBomb() ) {
                bombAll();
                SB.getTimer().stop();
            }
            else if( remainingBlock == 0 ){
                isGameOver = true;
                SB.getTimer().stop();
            }
        }
    }

    private void changePlayer(){
        if( currentPlayer == 1 ) currentPlayer = 2;
        else currentPlayer = 1;
        SB.setPlayer(currentPlayer);
        SB.setRemainingTime(15);
    }

    private void bombAll(){
        bombStart = true;
        timer = new Timer(100,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bomb();
                repaint();
            }
        });
        timer.start();
    }

    private void bomb(){
        if( isBomb.size() == 1 ){
            timer.stop();
            isGameOver = true;
        }
        for( int i = 0 ; i<isBomb.size() ; i++ ){
            if( isBomb.get(i).getVisit() ) isBomb.remove(i);
            else{
                int x = isBomb.get(i).getX();
                int y = isBomb.get(i).getY();
                bombs[x][y].setVisit(true);
                isBomb.remove(i);
                break;
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
        
        for( int i = 0 ; i<bombX ; i++ ){
            for( int j = 0 ; j<bombY ; j++ ){
                drawBlock(g, i, j);
            }
        }
        drawPlayer(g);

        g.dispose();
	}

    private static void drawGameBoard(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1210, 550);
	}
    
    
    private void drawBlock(Graphics g , int i , int j){
        Bomb bomb = bombs[i][j];
        g.setColor(bomb.getBackGroundColor());
        g.fillRoundRect(gap + ( gap + blockSize ) * j , gap + ( gap + blockSize ) * i , blockSize , blockSize , 5 , 5);
        
        if( bomb.getValue() != 0 && bomb.getValue() != 9 && bomb.getVisit() ){
            String text = String.valueOf(bomb.getValue());
            g.setFont(bomb.getBlockFont());
            g.setColor(bomb.getFontColor());
            g.drawString(text , gap + ( gap + blockSize ) * j + blockSize/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , gap + ( gap + blockSize ) * i + blockSize/2 + (int)g.getFontMetrics().getHeight()/3);
        }
        else if( bomb.getVisit() && bomb.getIsBomb() ) drawBomb(g, i, j);
    }

    private void drawBomb(Graphics g , int i , int j ){
        g.setColor(Color.DARK_GRAY);
        g.fillOval(gap + ( gap + blockSize ) * j + 10 , gap + ( gap + blockSize ) * i + 10  , 30 ,  30);
    }

    private void drawPlayer(Graphics g){
        int x,y;
        if( currentPlayer == 1 ){
            x = player1.getX();
            y = player1.getY();
            g.setColor(new Color( 250 ,128 , 114 , 120 ));
        }
        else{
            x = player2.getX();
            y = player2.getY();
            g.setColor(new Color( 193 ,205 , 193 , 120 )); 
        }

        g.fillRoundRect(gap + ( gap + blockSize ) * y -5 , gap + ( gap + blockSize ) * x -5 , blockSize+10 , blockSize+10 , 5 , 5);
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

        for( int i = 0 ; i<bombX ; i++ ){
            for( int j = 0 ; j<bombY ; j++ ){
                drawBlock(g, i, j);
            }
        }
        drawPlayer(g);
        SB.repaint();
        if( isGameOver ){
            drawGameOver(g);
            repaint();
        }
    }

}
