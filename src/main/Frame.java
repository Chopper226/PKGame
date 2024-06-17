package main;

import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class Frame extends JFrame implements GameOverListener{
    private String mode;
    private int version;
    private Timer startimer;
    private Timer timer;
    private ArrayList<String> level;
    private int currentGameIndex;
    private int countDown;

    private Interface interfacePanel;
    private Mode modePanel;
    private Setting settingPanel;
    private Choose choosePanel;
    private ScoreBoard scoreBoard;
    private GameOver gameOverPanel;
    private CardLayout cardLayout;

    private main.countdown.CountDown1 countPanel_1;
    private main.countdown.CountDown2 countPanel_2;
    private main.countdown.CountDown3 countPanel_3;

    private main.instructions.Instruction instruction ;

    private game._1A2B.GamePanel gamePanel_1A2B;
    private game._2048.GamePanel gamePanel_2048;
    private game.ballgame.GamePanel gamePanel_ballGame;
    private game.greedySnake.GamePanel gamePanel_greedySnake;
    private game.minesweeper.GamePanel gamePanel_minesweeper;
    private game.paper_scissors_stone.GamePanel gamePanel_paper_scissors_stone;
    private game.speedyArrows.GamePanel gamePanel_speedyArrows;
    private game.tug_of_war.GamePanel gamePanel_tug_of_war;
    private game.whackAMole.GamePanel gamePanel_whackAMole;

    private Music backgroundMusic;


    public Frame() {
        setTitle("PKGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backgroundMusic = new Music("/music/POL-chubby-cat-short.wav"); 
        backgroundMusic.play();

        interfacePanel = new Interface(this);
        modePanel = new Mode(this);
         settingPanel = new Setting(this, backgroundMusic);
        choosePanel = new Choose(this);
        scoreBoard = new ScoreBoard(this);
        gameOverPanel = new GameOver(this);

        countPanel_1 = new main.countdown.CountDown1();
        countPanel_2 = new main.countdown.CountDown2();
        countPanel_3 = new main.countdown.CountDown3();
        
        instruction = new main.instructions.Instruction(this);

        gamePanel_1A2B = new game._1A2B.GamePanel();
        gamePanel_2048 = new game._2048.GamePanel();
        gamePanel_ballGame = new game.ballgame.GamePanel();
        gamePanel_greedySnake = new game.greedySnake.GamePanel();
        gamePanel_minesweeper = new game.minesweeper.GamePanel();
        gamePanel_paper_scissors_stone = new game.paper_scissors_stone.GamePanel();
        gamePanel_speedyArrows = new game.speedyArrows.GamePanel();
        gamePanel_tug_of_war = new game.tug_of_war.GamePanel();
        gamePanel_whackAMole = new game.whackAMole.GamePanel();
        
        cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);
        getContentPane().add(interfacePanel, "interface");
        getContentPane().add(modePanel , "mode");
        getContentPane().add(settingPanel, "setting");
        getContentPane().add(choosePanel , "level");
        getContentPane().add(instruction , "instruction");
        getContentPane().add(scoreBoard , "score");
        getContentPane().add(gameOverPanel , "gameover");
        getContentPane().add(countPanel_1 , "1");
        getContentPane().add(countPanel_2 , "2");
        getContentPane().add(countPanel_3 , "3");
        getContentPane().add(gamePanel_1A2B , "1A2B");
        getContentPane().add(gamePanel_2048 , "2048");
        getContentPane().add(gamePanel_ballGame , "ballGame");
        getContentPane().add(gamePanel_greedySnake , "greedySnake");
        getContentPane().add(gamePanel_minesweeper , "minesweeper");
        getContentPane().add(gamePanel_paper_scissors_stone , "paper_scissors_stone");
        getContentPane().add(gamePanel_speedyArrows , "speedyArrows");
        getContentPane().add(gamePanel_tug_of_war , "tug_of_war");
        getContentPane().add(gamePanel_whackAMole , "whackAMole");

        init();
    }

    public void GameOver(String winner) {
        countDown = 3;
        timer = new Timer(300,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if( countDown > 0 ){
                    countDown -- ;
                }
                else{
                    timer.stop();
                    scoreBoard.updateScore(winner);
                    score();
                    currentGameIndex ++;
                }
            }
        });
        timer.start();
    }
    
    public String getMode(){
        return mode;
    }

    public int getVersion(){
        return version;
    }

    public int getCurrentGameIndex(){
        return currentGameIndex;
    }

    public void setMode( String mode ){
        this.mode = mode;
    }

    public void setVersion( int version ){
        this.version = version;
    }

    public void setLevel( ArrayList <String> level ){
        this.level = level;
    }

    public void switchToGameInterface(){
        gameInterface();
    }

    public void switchToMode(){
        mode();
    }

    public void switchToSetting(){
        setting();
    }

    public void switchToChooseLevel(){
        chooseLevel();
    }

    public void switchToInstruction(){
        gameInstruction();
    }

    public void switchToStart(){
        start();
    }

    public void switchToGameOver( String winner ){
        gameover(winner);
    }

    public void restart(){
        init();
    }

    private void gameInterface(){
        cardLayout.show(getContentPane(), "interface");
        interfacePanel.setFocusable(true);
        interfacePanel.requestFocusInWindow();
    }

    private void mode(){
        cardLayout.show(getContentPane(), "mode");
        modePanel.setFocusable(true);
        modePanel.requestFocusInWindow();
    }

    private void setting() {
        cardLayout.show(getContentPane(), "setting");
        settingPanel.setFocusable(true);
        settingPanel.requestFocusInWindow();
    }

    private void chooseLevel() {
        cardLayout.show(getContentPane(), "level");
        choosePanel.resetSetting();
        choosePanel.setFocusable(true);
        choosePanel.requestFocusInWindow();
    }

    private void gameInstruction(){
        instruction.instruction(level.get(currentGameIndex));
        cardLayout.show(getContentPane(), "instruction");
        instruction.setFocusable(true);
        instruction.requestFocusInWindow();
    }

    private void score() {
        cardLayout.show(getContentPane(), "score");
        scoreBoard.setFocusable(true);
        scoreBoard.requestFocusInWindow();
    }

    private void gameover( String winner ){
        gameOverPanel.setWinner(winner);
        cardLayout.show(getContentPane(), "gameover");
        gameOverPanel.setFocusable(true);
        gameOverPanel.requestFocusInWindow();
    }

    private void start(){
        countDown = 3;
        startimer = new Timer(1000,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if( countDown > 0 ){
                    cardLayout.show(getContentPane(), String.valueOf(countDown));
                    countDown -- ;
                }
                else{
                    startimer.stop();
                    game();
                }
            }
        });
        startimer.start();
    }

    private void init(){
        this.mode = "";
        this.version = 0;
        this.countDown = 0;
        this.currentGameIndex = 0;

        scoreBoard.setPlayer1(0);
        scoreBoard.setPlayer2(0);

        gameInterface();

    }

    private void game(){
        switch (level.get(currentGameIndex)) {
            case "1":
                _1A2B();
                break;
            case "2":
                ballGame();
                break;
            case "3":
                _2048();
                break;
            case "4":
                tug_of_war();
                break;
            case "5":
                greedySnake();
                break;
            case "6":
                whackAMole();
                break;
            case "7":
                speedyArrows();
                break;
            case "8":
                minesweeper();
                break; 
            case "9":
                paper_scissors_stone();
                break;  
            default:
                break;
        }
    }

    private void _1A2B() {
        gamePanel_1A2B.setStart(true);
        cardLayout.show(getContentPane(), "1A2B");
        gamePanel_1A2B.setGameOverListener(this);
        gamePanel_1A2B.setFocusable(true);
        gamePanel_1A2B.requestFocusInWindow();
    }

    private void _2048() {
        gamePanel_2048.setStart(true);
        cardLayout.show(getContentPane(), "2048");
        gamePanel_2048.setGameOverListener(this);
        gamePanel_2048.setFocusable(true);
        gamePanel_2048.requestFocusInWindow();
    }

    private void ballGame() {
        gamePanel_ballGame.setStart(true);
        cardLayout.show(getContentPane(), "ballGame");
        gamePanel_ballGame.setGameOverListener(this);
        gamePanel_ballGame.setFocusable(true);
        gamePanel_ballGame.requestFocusInWindow();
    }

    private void greedySnake() {
        gamePanel_greedySnake.setStart(true);
        cardLayout.show(getContentPane(), "greedySnake");
        gamePanel_greedySnake.setGameOverListener(this);
        gamePanel_greedySnake.setFocusable(true);
        gamePanel_greedySnake.requestFocusInWindow();
    }

    private void minesweeper() {
        gamePanel_minesweeper.setStart(true);
        cardLayout.show(getContentPane(), "minesweeper");
        gamePanel_minesweeper.setGameOverListener(this);
        gamePanel_minesweeper.setFocusable(true);
        gamePanel_minesweeper.requestFocusInWindow();
    }

    private void paper_scissors_stone() {
        gamePanel_paper_scissors_stone.setStart(true);
        cardLayout.show(getContentPane(), "paper_scissors_stone");
        gamePanel_paper_scissors_stone.setGameOverListener(this);
        gamePanel_paper_scissors_stone.setFocusable(true);
        gamePanel_paper_scissors_stone.requestFocusInWindow();
    }

    private void speedyArrows() {
        gamePanel_speedyArrows.setStart(true);
        cardLayout.show(getContentPane(), "speedyArrows");
        gamePanel_speedyArrows.setGameOverListener(this);
        gamePanel_speedyArrows.setFocusable(true);
        gamePanel_speedyArrows.requestFocusInWindow();
    }

    private void tug_of_war() {
        gamePanel_tug_of_war.setStart(true);
        cardLayout.show(getContentPane(), "tug_of_war");
        gamePanel_tug_of_war.setGameOverListener(this);
        gamePanel_tug_of_war.setFocusable(true);
        gamePanel_tug_of_war.requestFocusInWindow();
    }

    private void whackAMole() {
        gamePanel_whackAMole.setStart(true);
        cardLayout.show(getContentPane(), "whackAMole");
        gamePanel_whackAMole.setGameOverListener(this);
        gamePanel_whackAMole.setFocusable(true);
        gamePanel_whackAMole.requestFocusInWindow();
    }
}
