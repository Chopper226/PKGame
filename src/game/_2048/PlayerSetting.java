package game._2048;

import javax.swing.JPanel;

public class PlayerSetting extends JPanel{
    
    private GameBoard gameBoard;
    private ScoreBoard scoreBoard;
    private int playerNumber;
    
    PlayerSetting( int gbx , int gby , int sbx , int sby , int playerNumber){
        this.playerNumber = playerNumber;

        this.gameBoard = new GameBoard(playerNumber);
        gameBoard.setBounds(gbx, gby, 550 , 550 );
        this.scoreBoard = new ScoreBoard(gameBoard);
        scoreBoard.setBounds(sbx, sby , 250 , 120 );
        
        //this.addKeyListener(gameBoard.getKeyBoard());
        //this.setFocusable(true);
        //this.requestFocusInWindow();
    }

    public GameBoard getGameBoard(){
        return gameBoard;
    }

    public ScoreBoard getScoreBoard(){
        return scoreBoard;
    }



}

