package game.tug_of_war;

import main.GameOverListener;
import main.Panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import javax.swing.Timer;


public class GamePanel extends Panel implements ActionListener {
    private int WIDTH = 1280, HEIGHT = 720;
    private static boolean isGameOver = false;
    private Knot knot;
    private Timer timer;
    private InputHandler inputHandler;
    private TimeBoard timeboard;
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

    public static boolean isGameOver() {
        return isGameOver;
    }

    private void init(){
        setBackground(Color.WHITE);
        setFocusable(true);

        try {
            knot = new Knot("res\\tug_of_war\\knot.png", 640, 280);
            int knotWidth = knot.getImage().getWidth(null);
            int knotHeight = knot.getImage().getHeight(null);
            int initialX = (WIDTH - knotWidth) / 2;
            int initialY = (HEIGHT - knotHeight) / 2;
            knot.setX(initialX);
            knot.setY(initialY);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        inputHandler = new InputHandler(knot, this);
        addKeyListener(inputHandler);
        setFocusable(true);
        requestFocusInWindow();

        timer = new Timer(100, e -> repaint());
        timer.start();

        timeboard = new TimeBoard(this);
    }

    public static void endGame() {
        isGameOver = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    drawGame(g2d);

    if (isGameOver) {
        drawGameOver(g2d);
    } else {
        timeboard.paintComponent(g2d); 
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

    private void drawGame(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 340, 1280, 40);

        g.drawImage(knot.getImage(), knot.getX(), knot.getY(), null);

        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        String player1 = "P L A Y E R  1";
        String player1Text = "  p r e s s  A";
        String player2 = "P L A Y E R  2";
        String player2Text = "p r e s s  R I G H T";
        g.drawString(player1, 100, 550);
        g.drawString(player1Text, 100, 590);
        g.drawString(player2, 950, 550);
        g.drawString(player2Text, 920, 590);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!timeboard.getTimer().isRunning() || (timeboard.getRemainingTime() == 0)) {
            int knotCenterX = knot.getX() + Knot.WIDTH / 2;
            if (knotCenterX < 640) {
                winner="Player1";
                endGame();
            } else if (knotCenterX > 640) {
                endGame();
                winner="Player2";
            }
        } else {
            if (knot.getX() <= 0) {
                endGame();
                winner="Player1";
            }else if(knot.getX() >= getWidth() - Knot.WIDTH){
                endGame();
                winner="Player2";
            }
        }
        System.out.println("333");
        repaint();
        if(isGameOver == true){
            System.out.println("111");
            gameOverListener.GameOver(winner);
        }
    }
}