package game._1A2B;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Random;

public class GameBoard extends JPanel{

    private String[] ans;
    private ArrayList<String> input;
    private ArrayList<String> judge;
    private int currentPlayer;
    private Player player1;
    private Player player2;
    private int remaining;
    private KeyBoard KB ;
    private boolean isGameOver;
    private boolean isJudge;
    private int a;
    private int b;
    private Timer timer;

    GameBoard(){
        ans = new String[4];
        input = new ArrayList<>();
        judge = new ArrayList<>();
        initAns();
        initJudge();

        this.currentPlayer = choosePlayer();
        this.player1 = new Player();
        this.player2 = new Player();

        this.isGameOver = false;
        this.isJudge = false;
        this.a = 0;
        this.b = 0;

        this.KB = new KeyBoard( this ); 
    }

    public void addNum ( String n ){
        inputAddNum(n);
    }

    public void deleteNum (){
        inputDeleteNum();
    }

    public void StartJudge(){
        inputJudge();
    }

    public int getCurrentPlayer(){
        return currentPlayer;
    }

    public KeyBoard getKeyBoard(){
        return KB;
    }

    public boolean getGameOver(){
        return isGameOver;
    }

    private void initAns(){
        Random rand = new Random();
        int[] tmpAns = new int[4];
        for( int i = 0 ; i<4 ; i++ ){
            boolean check = true;
            while( check ){
                int num = rand.nextInt(8);
                num += 1;
                boolean tmp = false;
                for( int j = 0 ; j<i ; j++ ){
                    if( tmpAns[j] == num ) tmp = true;
                }
                if( tmp == false ){
                    tmpAns[i] = num;
                    ans[i] = String.valueOf(num);
                }
                check = tmp;
            }
        } 
    }

    private void initJudge(){
        judge.add("0");
        judge.add("A");
        judge.add("0");
        judge.add("B");
    }

    private int choosePlayer(){
        Random rand = new Random();
        int player = rand.nextInt(2);
        player += 1;
        return player;
    }

    private void inputAddNum( String n ){
        if( input.size() <4 ) {
            boolean check = true;
            for( int i = 0 ; i<input.size() ; i++ ){
                if( input.get(i).equals(n) ) check = false;
            }
            if( check ) input.add(n);
        }
        
    }

    private void inputDeleteNum(){
        if( input.size() >0 ) input.remove(input.size()-1);
    }

    private void inputJudge(){
        if( input.size() == 4 ){
            a = 0;
            b = 0;
            for( int i = 0 ; i<4 ; i++ ){
                for( int j = 0 ; j<4 ; j++ ){
                    if( input.get(i).equals(ans[j]) ){
                        if( i == j ) a++;
                        else b++;
                    }
                }
            }
            judge.remove(0);
            judge.add(0,String.valueOf(a));
            judge.remove(2);
            judge.add(2,String.valueOf(b));

            if( a == 4 ){
                isGameOver = true;
            }

            updatePlayerInfo();
            if(!(isGameOver)) input = new ArrayList<>();
            isJudge = true;
            remaining = 10;
            timer = new Timer(1,new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if( remaining >=0 ) remaining -- ;
                    else{
                        timer.stop();
                        isJudge = false;
                    }
                }
            });
            timer.start();
        }
    }

    private void updatePlayerInfo(){
        String tmp ="";
        for( int i = 0 ; i<4 ; i++ ){
            tmp += input.get(i);
        }
        String text = String.valueOf(a) + "A" + String.valueOf(b) + "B";

        if( currentPlayer == 1 ){
            if( 45 + 40*player1.getGuess().size() >720 ){
                player1.setGuess( new ArrayList<>() );
                player1.setJudge( new ArrayList<>() );
            }
            player1.addGuess(tmp);
            player1.addJudge(text);
            if( !(isGameOver) ) currentPlayer = 2;
        }
        else if( currentPlayer == 2 ){
            if( 45 + 40*player2.getGuess().size() >720 ){
                player2.setGuess( new ArrayList<>() );
                player2.setJudge( new ArrayList<>() );
            }
            player2.addGuess(tmp);
            player2.addJudge(text);
            if( !(isGameOver) ) currentPlayer = 1;
        }

    }

    public void paintComponent(Graphics g2) {
		super.paintComponent(g2);

		Graphics2D g = ((Graphics2D) g2); 

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		
        drawGameBoard(g);
        drawCurrentPlayerBoard(g);
        drawCurrentPlayer(g);
        drawCurrentPlayerText(g);

        for( int i = 0 ; i<4 ; i++ ){
            drawLine(g, i);
        }

        if( isJudge && !(isGameOver) ){
            for( int i = 0 ; i<4 ; i++ ){
                drawText(g, i, judge.get(i) );
            }
        }
        else{
            for( int i = 0 ; i<input.size() ; i++ ){
                drawText(g, i, input.get(i) );
            }
        }

        for( int i = 0 ; i<player1.getGuess().size() ; i++ ){
            String text = player1.getGuess().get(i) + " | " + player1.getJudge().get(i);

            drawPlayer(g, text, i , 1);
        }
        for( int i = 0 ; i<player2.getGuess().size() ; i++ ){
            String text = player2.getGuess().get(i) + " | " + player2.getJudge().get(i);
            drawPlayer(g, text, i , 2);
        }

        g.dispose();
	}

    private static void drawGameBoard(Graphics g) {
        g.setColor(Color.decode("#CDC5BF"));
        g.fillRect(0, 0, 1280, 720);
	}

    private void drawLine(Graphics2D g , int x ){
        g.setColor(Color.decode("#8B7D7B"));
        g.setStroke( new BasicStroke(5) );
        g.drawLine(200 + x*250, 450, 350+x*250, 450);
    }
    
    private void drawText(Graphics g , int x , String text){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial" , Font.BOLD , 100));
        g.drawString(text , 275 + 250*x - (int)(g.getFontMetrics().stringWidth(text)/2)  , 420);
    }

    private void drawPlayer(Graphics g , String text , int i , int num ){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial" , Font.BOLD , 35));
        if( num == 1 ) g.drawString(text , 30  , 45 + 40*i);
        else g.drawString(text , 1280-30-(int)(g.getFontMetrics().stringWidth(text))  , 45 +40*i);
    }

    private void drawCurrentPlayerBoard(Graphics g) {
        g.setColor(Color.decode("#8B8B83"));
        g.fillRect(1280/2-300/2, 30, 300, 120);
	}
    
    private void drawCurrentPlayerText(Graphics g){
        String text = "Now Round" ;
        g.setFont(new Font("Arial" , Font.BOLD , 40));
        g.setColor(Color.WHITE);
        g.drawString(text , 1280/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 70 );
    }

    private void drawCurrentPlayer(Graphics g){
        String text = "player "+String.valueOf(currentPlayer);
        g.setFont(new Font("Arial" , Font.BOLD , 45));
        g.setColor(Color.WHITE);
        g.drawString(text , 1280/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 130 );
    }

    private void drawGameOver(Graphics g){
        String text = "Game Over !";
        g.setColor( new Color( 	139 ,131 , 120, 120 ));  		 
        g.fillRect(0 , 0 , 1280 , 720 );
        g.setColor(Color.decode("#EE4000"));
        g.setFont(new Font("Arial" , Font.BOLD , 100));
        g.drawString(text, 1280/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 720/2);
    }
    

    @Override
    public void paint(Graphics g){
        super.paint(g);
        drawCurrentPlayerText(g);
        if( isJudge && !(isGameOver) && !(isGameOver)){
            for( int i = 0 ; i<4 ; i++ ){
                drawText(g, i, judge.get(i) );
            }
        }
        else{
            for( int i = 0 ; i<input.size() ; i++ ){
                drawText(g, i, input.get(i) );
            }
        }

        for( int i = 0 ; i<player1.getGuess().size() ; i++ ){
            String text = player1.getGuess().get(i) + " | " + player1.getJudge().get(i);

            drawPlayer(g, text, i , 1);
        }
        for( int i = 0 ; i<player2.getGuess().size() ; i++ ){
            String text = player2.getGuess().get(i) + " | " + player2.getJudge().get(i);
            drawPlayer(g, text, i , 2);
        }

        if( isGameOver ){
            drawGameOver(g);
            repaint();
        }
    }

}
