package game.speedyArrows;

import javax.swing.JPanel;


public class PlayerSetting extends JPanel{
    
    private GameBoard gameBoard;
    private ScoreBoard scoreBoard;
    private TimeBoard timeBoard;
    private ComboBoard comboBoard;
    private int playerNumber;
    
    PlayerSetting( int gbx , int gby , int tbx , int sbx , int cbx  , int y , int playerNumber){
        this.playerNumber = playerNumber;

        this.gameBoard = new GameBoard(playerNumber);
        gameBoard.setBounds(gbx, gby, 610 , 570 );
        this.timeBoard = gameBoard.getTimeBoard();
        timeBoard.setBounds( tbx , y , 190 , 120 );
        this.scoreBoard = gameBoard.getScoreBoard();
        scoreBoard.setBounds(sbx, y , 200 , 120 );
        this.comboBoard = gameBoard.getComboBoard();
        comboBoard.setBounds( cbx , y , 200 , 120 );
        
    }

    public GameBoard getGameBoard(){
        return gameBoard;
    }

    
    public ScoreBoard getScoreBoard(){
        return scoreBoard;
    }

    public TimeBoard getTimeBoard(){
        return timeBoard;
    }

    public ComboBoard getComboBoard(){
        return comboBoard;
    }

}

