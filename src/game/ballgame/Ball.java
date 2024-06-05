package game.ballgame;

import java.awt.*;

class Ball extends GameObject {
    private int dx = 5,dy = 5;

    public Ball(int x,int y,int size) {
        super(x,y,size,size);
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public void reverseX() {
        dx = -dx;
    }

    public void reverseY() {
        dy = -dy;
    }

    public void reset(int startX, int startY) {
        x = startX;
        y = startY;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    @Override
    public void update() {
        move();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x,y,width,height);
    }

}
