package main;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mode extends Panel {
    private JButton randomButton;
    private JButton chooseButton;

    Mode( Frame frame ){
        super();

        initRandomButton(frame);
        initChooseButton(frame);   

    }

    private void initRandomButton(Frame frame){
        randomButton = new JButton("Random");
        randomButton.setFont( new Font("Arial" , Font.BOLD , 25) );
        randomButton.setForeground(Color.WHITE);
        randomButton.setBackground(Color.GRAY);
        randomButton.setBounds(490, 300, 300, 120);
        randomButton.setFocusPainted(false);
        randomButton.setBorder(BorderFactory.createEmptyBorder());
        randomButton.setOpaque(true);
        this.add(randomButton);

        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setMode("Random");
                frame.switchToChooseLevel();
            }
        });
    }

    private void initChooseButton(Frame frame){
        chooseButton = new JButton("Customize");
        chooseButton.setFont( new Font("Arial" , Font.BOLD , 25) );
        chooseButton.setForeground(Color.WHITE);
        chooseButton.setBackground(Color.GRAY);
        chooseButton.setBounds(490, 500, 300, 120);
        chooseButton.setFocusPainted(false);
        chooseButton.setBorder(BorderFactory.createEmptyBorder());
        chooseButton.setOpaque(true);
        this.add(chooseButton);

        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setMode("Choose");
                frame.switchToChooseLevel();
            }
        });
    }
    
}