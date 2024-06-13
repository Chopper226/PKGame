package game.ballgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class InputHandler extends KeyAdapter {
    private final Paddle player1, player2;
    private boolean up1 = false, down1 = false, up2 = false, down2 = false;

    private Thread inputHandlerThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                updatePaddles();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    public InputHandler(Paddle player1, Paddle player2) {
        this.player1 = player1;
        this.player2 = player2;
        inputHandlerThread.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            up1 = true;
        }
        if (key == KeyEvent.VK_S) {
            down1 = true;
        }
        if (key == KeyEvent.VK_UP) {
            up2 = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            down2 = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            up1 = false;
        }
        if (key == KeyEvent.VK_S) {
            down1 = false;
        }
        if (key == KeyEvent.VK_UP) {
            up2 = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            down2 = false;
        }
    }

    private void updatePaddles() {
        if (up1 && player1.getY() > 0) {
            player1.moveUp();
        }
        if (down1 && player1.getY() < 1280-player1.getHeight()) {
            player1.moveDown();
        }
        if (up2 && player2.getY() > 0) {
            player2.moveUp();
        }
        if (down2 && player2.getY() < 1280-player2.getHeight()) {
            player2.moveDown();
        }
    }
}
