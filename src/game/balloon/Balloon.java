import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Balloon{
    private BufferedImage pinkBalloonImg, yellowBalloonImg, greenBalloonImg;
    private Image pink_scaledImage, yellow_scaledImage, green_scaledImage;

    public Balloon() {
        try {
            File pink_balloon_ImageFile = new File("pink_balloon.png");
            BufferedImage pink_originalImage = ImageIO.read(pink_balloon_ImageFile);
            int originalWidth = pink_originalImage.getWidth();
            int originalHeight = pink_originalImage.getHeight();
            int scaledWidth = (int) (originalWidth * 0.4);
            int scaledHeight = (int) (originalHeight * 0.4);
            pink_scaledImage = pink_originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            
            // ?取其他?种?色的气球?片并?放
            File yellow_balloon_ImageFile = new File("yellow_balloon.png");
            BufferedImage yellow_originalImage = ImageIO.read(yellow_balloon_ImageFile);
            yellow_scaledImage = yellow_originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);

            File green_balloon_ImageFile = new File("green_balloon.png");
            BufferedImage green_originalImage = ImageIO.read(green_balloon_ImageFile);
            green_scaledImage = green_originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawPink(Graphics2D g2d, int x, int y) {
        g2d.drawImage(pink_scaledImage, x, y, null);
    }
    
    public void drawYellow(Graphics2D g2d, int x, int y) {
        g2d.drawImage(yellow_scaledImage, x, y, null);
    }

    public void drawGreen(Graphics2D g2d, int x, int y) {
        g2d.drawImage(green_scaledImage, x, y, null);
    }
}