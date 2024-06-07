package main;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends Panel {
    private Frame frame;
    private JButton switch2v3Button;
    private JButton switch3v5Button;
    private JButton settingButton;

    public Interface(Frame frame) {
        super();

        this.frame = frame;
        init2v3Button();
        init3v5Button();
        initSettingButton();  

    }

    private void init2v3Button(){
        switch2v3Button = new JButton("best two out of three");
        switch2v3Button.setFont( new Font("Arial" , Font.BOLD , 25) );
        switch2v3Button.setForeground(Color.WHITE);
        switch2v3Button.setBackground(Color.GRAY);
        switch2v3Button.setBounds(490, 300, 300, 120);
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

    private void init3v5Button(){
        switch3v5Button = new JButton("best three out of five");
        switch3v5Button.setFont( new Font("Arial" , Font.BOLD , 25) );
        switch3v5Button.setForeground(Color.WHITE);
        switch3v5Button.setBackground(Color.GRAY);
        switch3v5Button.setBounds(490, 500, 300, 120);
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

    private void initSettingButton(){
        settingButton = new JButton("Setting");
        settingButton.setFont( new Font("Arial" , Font.BOLD , 25) );
        settingButton.setForeground(Color.WHITE);
        settingButton.setBackground(Color.GRAY);
        settingButton.setBounds(20, 600, 100, 100);
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
