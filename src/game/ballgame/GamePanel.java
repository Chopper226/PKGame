import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    private final int WIDTH = 1280,HEIGHT = 720;
    private final Paddle player1,player2;
    private final Ball ball;
    private final Timer timer;
    private final InputHandler inputHandler;
    private final ScoreBoard scoreBoard;

    public GamePanel (){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);

        player1 = new Paddle(50,HEIGHT/2-55,25,110);
        player2 = new Paddle(WIDTH-75,HEIGHT/2-55,25,110);
        ball = new Ball(WIDTH/2-15,HEIGHT/2-15,30);
        inputHandler = new InputHandler(player1,player2);
        scoreBoard = new ScoreBoard();

        addKeyListener(inputHandler);

        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        player1.draw(g2d);
        player2.draw(g2d);
        ball.draw(g2d);

        g2d.setColor(Color.GRAY);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);

        scoreBoard.draw(g2d,100,100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.update();
        checkCollisions();
        repaint();
    }

    private void checkCollisions() {
        if (ball.getY() <= 0 || ball.getY() >= HEIGHT - ball.getHeight()) {
            ball.reverseY();
        }

        if (ball.getX() <= 0) {
            scoreBoard.increaseScorePlayer2();
            ball.reset(WIDTH / 2 - ball.getWidth() / 2, HEIGHT / 2 - ball.getHeight() / 2);
        } else if (ball.getX() >= WIDTH - ball.getWidth()) {
            scoreBoard.increaseScorePlayer1();
            ball.reset(WIDTH / 2 - ball.getWidth() / 2, HEIGHT / 2 - ball.getHeight() / 2);
        }

        Rectangle ballBounds = ball.getBounds();
        Rectangle player1Bounds = player1.getBounds();
        Rectangle player2Bounds = player2.getBounds();

        if (ballBounds.intersects(player1Bounds) || ballBounds.intersects(player2Bounds)) {
            ball.reverseX();
        }
    }
}
