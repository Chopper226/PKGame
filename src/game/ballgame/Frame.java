package game.ballgame;

import javax.swing.JFrame;

public class Frame extends JFrame{
    GamePanel gamepanel;

    public Frame(){
        gamepanel = new GamePanel();    //創建Game類的實例（game是一個JPanel）
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(gamepanel);
        this.pack();    //JFrame根據JPanel大小改變
        this.setLocationRelativeTo(null);    //將JFrame設定在螢幕中間
        this.setVisible(false);
    }
}