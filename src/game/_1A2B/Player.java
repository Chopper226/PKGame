package game._1A2B;

import java.util.ArrayList;

public class Player {
    private ArrayList<String> guess;
    private ArrayList<String> judge;

    public Player(){
        guess = new ArrayList<>();
        judge = new ArrayList<>();
    }    

    public void addGuess( String s ){
        guess.add(s);
    }

    public void addJudge( String s ){
        judge.add(s);
    }

    public ArrayList<String> getGuess(){
        return guess;
    }

    public ArrayList<String> getJudge(){
        return judge;
    }

    public void setGuess( ArrayList<String> guess ){
        this.guess = guess;
    }

    public void setJudge( ArrayList<String> judge ){
        this.judge = judge;
    }
}
