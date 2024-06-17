package main.instructions;

import main.Panel;
import main.Frame;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instruction extends Panel{
    private JButton startButton;

    private Instruction_1A2B _1A2B;
    private Instruction_2048 _2048;
    private Instruction_ballGame ballGame;
    private Instruction_greedySnake greedySnake;
    private Instruction_minesweeper minesweeper;
    private Instruction_paper_scissors_stone paper_scissors_stone;
    private Instruction_speedyArrows speedyArrows;
    private Instruction_tug_of_war tug_of_war;
    private Instruction_whackAMole whackAMole;
    
    

    public Instruction(Frame frame){
        initStartButton(frame);

        _1A2B = new Instruction_1A2B();
        _2048 = new Instruction_2048();
        ballGame = new Instruction_ballGame();
        greedySnake = new Instruction_greedySnake();
        minesweeper = new Instruction_minesweeper();
        paper_scissors_stone = new Instruction_paper_scissors_stone();
        speedyArrows = new Instruction_speedyArrows();
        tug_of_war = new Instruction_tug_of_war();
        whackAMole = new Instruction_whackAMole();

        _1A2B.setBounds(0, 0 , 1280, 720);
        _2048.setBounds(0, 0 , 1280, 720);
        ballGame.setBounds(0,0,1280,720);
        greedySnake.setBounds(0, 0 , 1280, 720);
        minesweeper.setBounds(0, 0 , 1280, 720);
        paper_scissors_stone.setBounds(0, 0 , 1280, 720);
        speedyArrows.setBounds(0, 0 , 1280, 720);
        tug_of_war.setBounds(0,0, 1280, 720);
        whackAMole.setBounds(0, 0 , 1280, 720);

    }
    
    public void instruction( String now ){
        reset(now);
        startButton.repaint();
    }
    
    private void initStartButton(Frame frame){
        ImageIcon starticon = new ImageIcon("res\\instructions\\start.png");
        startButton = new JButton(starticon);
        startButton.setBounds(1080, 280, 77, 181);
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
                this.add(ballGame);
                break;
            case "3":
                this.add(_2048);
                break;
            case "4":
                this.add(tug_of_war);
                break;
            case "5":
                this.add(greedySnake);
                break;
            case "6":
                this.add(whackAMole);
                break;
            case "7":
                this.add(speedyArrows);
                break;
            case "8":
                this.add(minesweeper);
                break;
            case "9":
                this.add(paper_scissors_stone);
                break;   
            default:
                break;
        }  
    }
}
