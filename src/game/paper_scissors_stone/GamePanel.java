package game.paper_scissors_stone;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private static final int WIDTH = 1280, HEIGHT = 720;
    private TimeBoard timeBoard;
    private JLabel player1ChoiceLabel;
    private JLabel player2ChoiceLabel;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        setLayout(null);

        timeBoard = new TimeBoard();
        timeBoard.setBounds(640 - 360 / 2, 50, 360, 150);
        add(timeBoard);

        player1ChoiceLabel = new JLabel();
        player1ChoiceLabel.setBounds(200, 300, 300, 300);
        add(player1ChoiceLabel);

        player2ChoiceLabel = new JLabel();
        player2ChoiceLabel.setBounds(750, 300, 300, 300);
        add(player2ChoiceLabel);

        addKeyListener(new KeyHandler(this, timeBoard, new Player()));
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(639, 230, 639, 690);

        g2d.dispose();
    }

    public void updatePlayerChoices(Player player) {
        player1ChoiceLabel.setIcon(player.getPlayer1ChoiceImage());
        player2ChoiceLabel.setIcon(player.getPlayer2ChoiceImage());
        repaint();
    }
}