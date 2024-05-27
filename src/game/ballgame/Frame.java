import javax.swing.JFrame;

class Frame extends JFrame{
    GamePanel gamepanel;

    Frame(){
        gamepanel = new GamePanel();    //�Ы�Game������ҡ]game�O�@��JPanel�^
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(gamepanel);
        this.pack();    //JFrame�ھ�JPanel�j�p����
        this.setLocationRelativeTo(null);    //�NJFrame�]�w�b�ù�����
        this.setVisible(true);
    }
}