package game.balloon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;

public class KeyHandler extends KeyAdapter {
    private Map<Integer, Needle> needles;
    private GamePanel panel;

    public KeyHandler(Map<Integer, Needle> needles, GamePanel panel) {
        this.needles = needles;
        this.panel = panel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (needles.containsKey(keyCode)) {
            needles.get(keyCode).moveUp();
            panel.repaint();
        }
    }
}
