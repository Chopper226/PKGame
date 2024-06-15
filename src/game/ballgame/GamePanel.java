package game.ballgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.GameOverListener;
import main.Panel;

public class GamePanel extends Panel implements ActionListener {
    private int WIDTH = 1280, HEIGHT = 720;
    private Paddle player1, player2;
    private Ball ball;
    private Timer timer;
    private InputHandler inputHandler;
    private ScoreBoard scoreBoard;
    private boolean gameRunning;
    private GameOverListener gameOverListener;
    private boolean start;
    private String winner;

    private long lastReverseXTime = 0;

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
        gameRunning=true;

        setBackground(new Color(226, 209, 212));
        setFocusable(true);

        player1 = new Paddle(50, HEIGHT / 2 - 55, 25, 110);
        player2 = new Paddle(WIDTH - 75, HEIGHT / 2 - 55, 25, 110);
        ball = new Ball(WIDTH / 2 - 15, HEIGHT / 2 - 15, 30);
        inputHandler = new InputHandler(player1, player2);
        scoreBoard = new ScoreBoard();

        addKeyListener(inputHandler);

        timer = new Timer(10, this);
        timer.start();

        lastReverseXTime = System.currentTimeMillis();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        player1.draw(g2d);
        player2.draw(g2d);
        ball.draw(g2d);

        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(6));
        g2d.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);

        scoreBoard.draw(g2d, 100, 100);

        if (!gameRunning) {
            drawGameOver(g2d);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameRunning) {
            ball.update();
            checkCollisions();
            repaint();
        }
    }

    private void checkCollisions() {
        if (ball.getY() <= 0 || ball.getY() >= HEIGHT - ball.getHeight()) {
            ball.reverseY();
        }

        if (ball.getX() <= 0) {
            scoreBoard.increaseScorePlayer2();
            checkGameOver();
            ball.reset(WIDTH / 2 - ball.getWidth() / 2, HEIGHT / 2 - ball.getHeight() / 2);
        } else if (ball.getX() >= WIDTH - ball.getWidth()) {
            scoreBoard.increaseScorePlayer1();
            checkGameOver();
            ball.reset(WIDTH / 2 - ball.getWidth() / 2, HEIGHT / 2 - ball.getHeight() / 2);
        }

        Rectangle ballBounds = ball.getBounds();
        Rectangle player1Bounds = player1.getBounds();
        Rectangle player2Bounds = player2.getBounds();

        if (player1Bounds.contains(ballBounds.getMinX(), ballBounds.getCenterY())
                || player2Bounds.contains(ballBounds.getMaxX(), ballBounds.getCenterY())) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastReverseXTime >= 500) {
                ball.reverseX();
                lastReverseXTime = currentTime;
            }
        }
    }

    private void drawGameOver(Graphics g) {
        String text = "Game Over!";
        g.setColor(new Color(255, 255, 255,120));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.decode("#EE6A50"));
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString(text, WIDTH / 2 - g.getFontMetrics().stringWidth(text) / 2, HEIGHT / 2);
    }

    private void checkGameOver() {
        if (scoreBoard.getScorePlayer1() >= 7) {
            gameRunning = false;
            winner="Player1";

        }else if(scoreBoard.getScorePlayer2() >= 7){
            gameRunning = false;
            winner="Player2";
        }
        
        if(gameRunning==false){
            timer.stop();
            start = false;
            removeAll();
            gameOverListener.GameOver(winner);
        }
    }
}
