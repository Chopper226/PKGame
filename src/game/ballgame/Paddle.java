package game.ballgame;

import java.awt.*;

class Paddle extends GameObject {
    private int speed = 30;

    public Paddle(int x,int y,int width,int height) {
        super(x, y,width,height);
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x,y,width,height);
    }

}
