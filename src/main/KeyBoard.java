package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {
    private Choose choose;

    KeyBoard( Choose choose ){
        this.choose = choose;
    }


    @Override
	public void keyTyped(KeyEvent e) {}

    @Override
	public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if( keyCode >= KeyEvent.VK_1 && keyCode <= KeyEvent.VK_9 ){
            choose.addNum(String.valueOf(keyCode-48));
        }
        else if( keyCode == KeyEvent.VK_BACK_SPACE ){
            choose.deleteNum();
        }
        else if( keyCode == KeyEvent.VK_ENTER ){
            choose.startGame();
        }

        choose.repaint();
    }

}