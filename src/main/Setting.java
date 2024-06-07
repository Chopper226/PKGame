package main;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Setting extends Panel {
    private JButton backButton;

    public Setting( Frame frame){
        super();
        initBackButton(frame);
    }

    private void initBackButton(Frame frame){
        backButton = new JButton("Back");
        backButton.setFont( new Font("Arial" , Font.BOLD , 25) );
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.GRAY);
        backButton.setBounds(540, 500, 200, 100);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setOpaque(true);
        this.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchToGameInterface();
            }
        });
    }

}
