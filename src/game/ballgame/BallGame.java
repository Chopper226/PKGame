package game.ballgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallGame extends JPanel implements ActionListener, KeyListener {
    private final int WIDTH = 1280, HEIGHT = 720; 
    private final int PLAYER_WIDTH = 25, PLAYER_HEIGHT = 85;  //板子的大小
    private final int BALL_SIZE = 25;  //球的大小
    private int player1X = 50, player1Y = HEIGHT / 2 - PLAYER_HEIGHT / 2;  //左邊板子位置
    private int player2X = WIDTH - 50-PLAYER_WIDTH, player2Y = HEIGHT / 2 - PLAYER_HEIGHT / 2;  //右邊板子位置
    private int ballX = WIDTH / 2 - BALL_SIZE / 2, ballY = HEIGHT / 2 - BALL_SIZE / 2;
    private int ballDX = 3, ballDY = 3;
    private boolean up1 = false, down1 = false, up2 = false, down2 = false;
    private Timer timer;

    public BallGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        setFocusable(true);  //讓Panel接受鍵盤輸入
        addKeyListener(this);
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  //消除鋸齒
        g2d.setColor(Color.BLUE);
        g2d.fillRect(player1X, player1Y, PLAYER_WIDTH, PLAYER_HEIGHT);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(player2X, player2Y, PLAYER_WIDTH, PLAYER_HEIGHT);
        g2d.setColor(Color.RED);
        g2d.fillOval(ballX, ballY,BALL_SIZE,BALL_SIZE);
        g2d.setColor(Color.GRAY);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (up1 && player1Y > 0) {
            player1Y -= 5;
        }
        if (down1 && player1Y < HEIGHT - PLAYER_HEIGHT) {
            player1Y += 5;
        }
        if (up2 && player2Y > 0) {
            player2Y -= 5;
        }
        if (down2 && player2Y < HEIGHT - PLAYER_HEIGHT) {
            player2Y += 5;
        }

        ballX += ballDX;
        ballY += ballDY;

        if (ballY <= 0 || ballY >= HEIGHT - BALL_SIZE) {
            ballDY = -ballDY;
        }

        if (new Rectangle(player1X, player1Y, PLAYER_WIDTH, PLAYER_HEIGHT).intersects(new Rectangle(ballX, ballY, BALL_SIZE, BALL_SIZE))) {
            ballDX = -ballDX;
        }

        if (new Rectangle(player2X, player2Y, PLAYER_WIDTH, PLAYER_HEIGHT).intersects(new Rectangle(ballX, ballY, BALL_SIZE, BALL_SIZE))) {
            ballDX = -ballDX;
        }

        if (ballX <= 0 || ballX >= WIDTH - BALL_SIZE) {
            ballX = WIDTH / 2 - BALL_SIZE / 2;
            ballY = HEIGHT / 2 - BALL_SIZE / 2;
            ballDX = 3;
            ballDY = 3;
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            up1 = true;
        }
        if (key == KeyEvent.VK_S) {
            down1 = true;
        }
        if (key == KeyEvent.VK_UP) {
            up2 = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            down2 = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            up1 = false;
        }
        if (key == KeyEvent.VK_S) {
            down1 = false;
        }
        if (key == KeyEvent.VK_UP) {
            up2 = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            down2 = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Stickman Badminton");
        BallGame game = new BallGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
