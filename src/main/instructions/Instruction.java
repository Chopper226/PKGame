package main.instructions;

import main.Panel;
import main.Frame;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instruction extends Panel{
    private Frame frame;
    private JButton startButton;

    private Instruction_1A2B _1A2B;
    private Instruction_2048 _2048;
    private Instruction_ballGame ballGame;
    private Instruction_greedySnake greedySnake;
    private Instruction_minesweeper minesweeper;
    private Instruction_speedyArrows speedyArrows;
    private Instruction_whackAMole whackAMole;
    
    

    public Instruction(Frame frame){
        this.frame = frame;
        initStartButton();

        _1A2B = new Instruction_1A2B();
        _2048 = new Instruction_2048();
        ballGame = new Instruction_ballGame();
        greedySnake = new Instruction_greedySnake();
        minesweeper = new Instruction_minesweeper();
        speedyArrows = new Instruction_speedyArrows();
        whackAMole = new Instruction_whackAMole();

        _1A2B.setBounds(0, 0 , 1280, 720);
        _2048.setBounds(0, 0 , 1280, 720);
        ballGame.setBounds(0,0,1280,720);
        greedySnake.setBounds(0, 0 , 1280, 720);
        minesweeper.setBounds(0, 0 , 1280, 720);
        speedyArrows.setBounds(0, 0 , 1280, 720);
        whackAMole.setBounds(0, 0 , 1280, 720);

    }
    
    public void instruction( String now ){
        reset(now);
        startButton.repaint();
    }
    
    private void initStartButton(){
        startButton = new JButton("start");
        startButton.setFont( new Font("Arial" , Font.BOLD , 25) );
        startButton.setForeground(Color.WHITE);
        startButton.setBackground(Color.GRAY);
        startButton.setBounds(490, 500, 300, 120);
        startButton.setFocusPainted(false);
        startButton.setBorder(BorderFactory.createEmptyBorder());
        startButton.setOpaque(true);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchToStart();
            }
        });
    }

    private void reset( String now ){
        this.removeAll();
        this.add(startButton);
        switch ( now ) {
            case "1":
                this.add(_1A2B);
                break;
            case "2":
                this.add(_2048);
                break;
            case "3":
                this.add(ballGame);
                break;
            case "4":
                this.add(greedySnake);
                break;
            case "5":
                this.add(minesweeper);
                break;
            case "6":
                this.add(speedyArrows);
                break;
            case "7":
                this.add(whackAMole);
                break;   
            default:
                break;
        }  
    }


}
