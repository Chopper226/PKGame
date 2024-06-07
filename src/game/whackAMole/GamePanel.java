package game.whackAMole;

import main.GameOverListener;
import main.Panel;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends Panel{
    
    private GameBoard gb;
    private StatusBoard sb;
    private Timer checkGameOverTimer;
    private GameOverListener gameOverListener;
    private String winner;
    private boolean start;

    public GamePanel(){
        super();
        
        this.start = false;
    }

    public void setStart( boolean start ){
        this.start = start;
        if( start ) init();
    }

    public void setGameOverListener(GameOverListener listener) {
        this.gameOverListener = listener;
    }

    private void init(){
        gb = new GameBoard();
        gb.setBounds(35, 150 , 1210, 550);
        this.add(gb);

        this.addKeyListener(gb.getKeyBoard());
        this.setFocusable(true);

        sb = gb.getStatusBoard();
        sb.setBounds(35, 15, 1210 , 120);
        this.add(sb);
        
        checkGameOverTimer = new Timer(100,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if( gb.getGameOver() ) {
                    winner = "Player2";
                    gameOverListener.GameOver(winner);
                    checkGameOverTimer.stop();
                }
            }
        });
        checkGameOverTimer.start();
    }
}