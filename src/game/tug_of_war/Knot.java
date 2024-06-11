package game.tug_of_war;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Knot {
    public static final int WIDTH = 191;
    private Image image;
    private int x;
    private int y;
    private boolean player1AKeyPressed = false;
    private boolean player2RIGHTKeyPressed = false;

    public Knot(String imagePath, int x, int y) throws IOException {
        this.image = ImageIO.read(new File(imagePath));
        this.x = x;
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPlayer1AKeyPressed() {
        return player1AKeyPressed;
    }

    public void setPlayer1AKeyPressed(boolean player1AKeyPressed) {
        this.player1AKeyPressed = player1AKeyPressed;
    }

    public boolean isPlayer2RIGHTKeyPressed() {
        return player2RIGHTKeyPressed;
    }

    public void setPlayer2RIGHTKeyPressed(boolean player2RIGHTKeyPressed) {
        this.player2RIGHTKeyPressed = player2RIGHTKeyPressed;
    }

    public void moveLeft() {
        x -= 15;
    }

    public void moveRight() {
        x += 15;
    }
}