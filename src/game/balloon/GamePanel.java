import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel {
    static final int WIDTH = 1280, HEIGHT = 720;
    private Map<Integer, Needle> needles;
    private Balloon balloon;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        setFocusable(true);

        needles = new HashMap<>();
        int[] keys = {'A', 'S', 'D', KeyEvent.VK_LEFT, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT};
        int[] xPositions = {80,266, 452, 730,916,1102};

        try {
            File needleImageFile = new File("C:\\Users\\User\\Desktop\\jump\\needle.png");
            BufferedImage originalImage = ImageIO.read(needleImageFile);
            int originalWidth = originalImage.getWidth();
            int originalHeight = originalImage.getHeight();
            int scaledWidth = (int) (originalWidth * 0.4);
            int scaledHeight = (int) (originalHeight * 0.4);
            Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            
            for (int i = 0; i < keys.length; i++) {
                needles.put(keys[i], new Needle(scaledImage, xPositions[i], HEIGHT-scaledHeight-15));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        balloon = new Balloon(); // 初始化气球?象
        addKeyListener(new KeyHandler(needles, this));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(640, 20, 640, 700);
    
        for (Needle needle : needles.values()) {
            needle.draw(g2d);
        }

        balloon.drawPink(g2d, 100, 100); // ?制粉色气球
        balloon.drawYellow(g2d, 300, 100); // ?制?色气球
        balloon.drawGreen(g2d, 500, 100); // ?制?色气球

        
    }
}