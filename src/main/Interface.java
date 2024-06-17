package main;

import javax.swing.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends Panel {
    private JButton switch2v3Button;
    private JButton switch3v5Button;
    private JButton settingButton;
    private Image backgroundImage;

    public Interface(Frame frame) {
        super();

        this.backgroundImage = new ImageIcon("res\\interface\\ss.png").getImage();

        init2v3Button(frame);
        init3v5Button(frame);
        initSettingButton(frame);  

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this); 
        }
    }

    private void init2v3Button(Frame frame){
        ImageIcon icon2v3 = new ImageIcon("res\\interface\\JButton_BestTwoOutOfThree.png");
        switch2v3Button = new JButton(icon2v3);
        switch2v3Button.setBounds(590, 230, 558, 83);
        switch2v3Button.setFocusPainted(false);
        switch2v3Button.setBorder(BorderFactory.createEmptyBorder());
        switch2v3Button.setOpaque(true);
        this.add(switch2v3Button);

        switch2v3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVersion(3);
                frame.switchToMode();
            }
        });
    }

    private void init3v5Button(Frame frame){
        ImageIcon icon3v5 = new ImageIcon("res\\interface\\JButton_BestThreeOutOfFive.png");
        switch3v5Button = new JButton(icon3v5);
        switch3v5Button.setBounds(590, 330, 558, 84);
        switch3v5Button.setFocusPainted(false);
        switch3v5Button.setBorder(BorderFactory.createEmptyBorder());
        switch3v5Button.setOpaque(true);
        this.add(switch3v5Button);

        switch3v5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVersion(5);
                frame.switchToMode();
            }
        });
    }

    private void initSettingButton(Frame frame){
        ImageIcon settingIcon = new ImageIcon("res\\interface\\JButton_Setting.png");
        settingButton = new JButton(settingIcon);
        settingButton.setBounds(590, 430, 558, 84);
        settingButton.setFocusPainted(false);
        settingButton.setBorder(BorderFactory.createEmptyBorder());
        settingButton.setOpaque(true);
        this.add(settingButton);

        settingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchToSetting();
            }
        });
    }
}
