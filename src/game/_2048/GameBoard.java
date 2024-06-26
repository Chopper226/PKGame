package game._2048;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;


public class GameBoard extends JPanel{

    private Block[][] blocks ;
    private int score ;
    private Move move ; 
    private KeyBoard KB ;
    private ScoreBoard SB ;
    private boolean isGameOver;
    private boolean reach; // reach to 2048

    final int gap = 14;
    final int blockSize = 120;

    GameBoard(int playerNumber){
        this.blocks = new Block[4][4];
        initBlock();

        this.score = 0;
        this.SB = new ScoreBoard(this);

        this.move = new Move(blocks , this);
        
        this.isGameOver = false;
        this.reach = false;

        if( playerNumber == 1 ) KB = new Player1KeyBoard( move, this ); 
        else if( playerNumber == 2) KB = new KeyBoard( move, this );

    }


    public void createBlocks(){
        createBlock();
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

    public Block[][] getBlocks(){
        return this.blocks;
    }

    public boolean getGameOver(){
        return isGameOver;
    }

    public void setGameOver( boolean isGameOver ){
        this.isGameOver = isGameOver;
    }
    
    public boolean getReach(){
        return reach;
    }

    private void initBlock(){
        for( int i = 0 ; i<4 ; i++ ){
            for( int j = 0 ; j<4 ; j++){
                blocks[i][j] = new Block();
            }
        }
        createBlock();
        createBlock();
    }
    
    private ArrayList<Block> getEmptyBlock(){
        ArrayList<Block> empty = new ArrayList<>();
        for( int i = 0 ; i<4 ; i++ ){
            for( int j = 0 ; j<4 ; j++ ){
                if(blocks[i][j].getValue() == 0 ) empty.add(blocks[i][j]);
            }
        }
        return empty;
    }

    private void createBlock(){
        ArrayList<Block> empty = getEmptyBlock();
        if( !(empty.isEmpty()) ) {
            Random rand = new Random();
            int index = rand.nextInt(empty.size());

            int num = rand.nextInt(4); // Appearance probability -> 2 : 4 = 3 : 1
            if( num%3 == 1 ) num = 4;
            else num = 2;

            Block block = empty.get(index);
            block.setValue(num);
        }
    }

    private boolean gameOver(){
        for( int i = 0 ; i<4 ; i++ ){
            for( int j = 0 ; j<4 ; j++ ){
                if( blocks[i][j].getValue() == 2048 ){
                    reach = true;
                    return true;
                }
            }
        }
        if( !(getEmptyBlock().isEmpty()) ) return false;
        for( int i = 0 ; i<3 ; i++ ){
            for( int j = 0 ; j<3 ; j++ ){
                if( blocks[i][j].getValue() == blocks[i][j+1].getValue() || blocks[i][j].getValue() == blocks[i+1][j].getValue() ) return false;
            }
        }
        return true;
    }


    public void paintComponent(Graphics g2) {
		super.paintComponent(g2);

		Graphics2D g = ((Graphics2D) g2); 

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		drawGameBoard(g);

        for( int i = 0 ; i<4 ; i++ ){
            for( int j = 0 ; j<4 ; j++ ){
                drawBlock(g, i, j);
            }
        }
		
        g.dispose();
	}

    private static void drawGameBoard(Graphics g) {
        g.setColor(Color.decode("#BBADA0"));
        g.fillRect(0, 0, 550, 550);
	}
    
    private void drawBlock(Graphics g , int i , int j){
        Block block = blocks[i][j];
        g.setColor(block.getBackGroundColor());
        g.fillRoundRect(gap + ( gap + blockSize ) * j , gap + ( gap + blockSize ) * i , blockSize , blockSize , 10 , 10);
        
        if( block.getValue() != 0 ){
            String text = String.valueOf(block.getValue());
            g.setFont(block.getBlockFont());
            g.setColor(block.getFontColor());
            g.drawString(text , gap + ( gap + blockSize ) * j + blockSize/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , gap + ( gap + blockSize ) * i + blockSize/2 + (int)g.getFontMetrics().getHeight()/3);
        }
    }

    private void drawGameOver( Graphics g ){
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
        for( int i = 0 ; i<4 ; i++ ){
            for( int j = 0 ; j<4 ; j++ ){
                drawBlock(g, i, j);
            }
        }
        SB.setScore( score );
        SB.repaint();
        if( gameOver() ){
            isGameOver = gameOver();
            drawGameOver(g);
            repaint();
        }
    }
}