package game.ballgame;

import java.awt.*;

class Paddle extends GameObject {
    private int speed = 10;

    public Paddle(int x,int y,int width,int height) {
        super(x, y,width,height);
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    
    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(193, 162, 168));
        g.fillRect(x,y,width,height);
    }

}
