package game.ballgame;

import java.awt.*;

class Ball extends GameObject {
    private int dx = 6,dy = 6;

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

    public void adjustVerticalSpeed(int deltaY) {
        // 根据 deltaY ?整球的垂直速度
        // 例如，根据 deltaY 的正?值??定反?或保持不?
        dy = -dy; // ?只是一?示例，根据您的游??????
    }
}
