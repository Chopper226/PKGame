package game.balloon;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Needle {
    private Image needle;
    private int x;
    private int y;
    private int originalY;
    private Timer timer;

    public Needle(Image needle, int x, int y) {
        this.needle = needle;
        this.x = x;
        this.y = y;
        this.originalY = y;
        this.timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetPosition();
            }
        });
        timer.setRepeats(false);
    }

    public void moveUp() {
        y -= 30;
        timer.start();
    }

    private void resetPosition() {
        y = originalY;
        timer.stop();
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(needle, x, y, null);
    }
}
