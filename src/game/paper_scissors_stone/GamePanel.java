package game.paper_scissors_stone;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Timer;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.GameOverListener;
import main.Panel;

public class GamePanel extends Panel {
    private TimeBoard timeBoard;
    private JLabel player1ChoiceLabel;
    private JLabel player2ChoiceLabel;
    private JLabel resultLabel;
    private ScoreBoard scoreBoard;
    private Timer imageTimer;
    private int roundCount = 0;
    private final int totalRounds = 5;
    private boolean gameRunning = true;
    private GameOverListener gameOverListener;
    private boolean start;
    private String winner;

    public GamePanel() {
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
        setBackground(new Color(255, 244, 228));
        setLayout(null);
    
        timeBoard = new TimeBoard(this);
        timeBoard.setBounds(640 - 360 / 2, 50, 360, 150);
        add(timeBoard);
    
        player1ChoiceLabel = new JLabel();
        player1ChoiceLabel.setBounds(170, 300, 300, 300);
        add(player1ChoiceLabel);
    
        player2ChoiceLabel = new JLabel();
        player2ChoiceLabel.setBounds(810, 300, 300, 300);
        add(player2ChoiceLabel);
    
        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setBounds(540, 600, 1280, 760);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(resultLabel);
    
        scoreBoard = new ScoreBoard();
        scoreBoard.setBounds(0, 0, 1280, 760);
        add(scoreBoard);
    
        addKeyListener(new KeyHandler(this, timeBoard, new Player()));
        setFocusable(true);
    
        imageTimer = new Timer(1000, e -> clearPlayerChoices());
        imageTimer.setRepeats(false);
    
        startNewRound();
        }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
        g2d.setColor(new Color(111, 94, 75));
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(639, 230, 639, 690);

        if(!gameRunning) {
            drawGameOver(g2d);
        }
    
        g2d.dispose();
    }
    
    public void updatePlayerChoices(Player player) {
        player1ChoiceLabel.setIcon(player.getPlayer1ChoiceImage());
        player2ChoiceLabel.setIcon(player.getPlayer2ChoiceImage());
        repaint();
    
        imageTimer.start();
    }
    
    public void clearPlayerChoices() {
        player1ChoiceLabel.setIcon(null);
        player2ChoiceLabel.setIcon(null);
        repaint();
    
        if (roundCount < totalRounds) {
            startNewRound();
        } else {
            endGame();
        }
    }
    
    public void displayResult(String result, String player1, String player2) {
        scoreBoard.updateScores(result);
        repaint();
    }
    
    public void startNewRound() {
        roundCount++;
        timeBoard.startCountdown();
    }
    
    private void drawGameOver(Graphics g) {
        String text = "Game Over!";
        int width = getWidth();
        int height = getHeight();
    
        g.setColor(new Color(255, 255, 255, 120));
        g.fillRect(0, 0, width, height);
        
        g.setColor(Color.decode("#EE6A50"));
        g.setFont(new Font("Arial", Font.BOLD, 50));
        
        int textWidth = g.getFontMetrics().stringWidth(text);
        int x = (width - textWidth) / 2;
        int y = height / 2;
    
        g.drawString(text, x, y);
    }

    public void endGame() {
        gameRunning = false;
        repaint();
        gameOverListener.GameOver(winner);
    }
}    