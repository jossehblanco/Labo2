package labo2.labo2.gameLogic;

import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by UCA on 23/3/2018.
 */

public class Player {
    private int score = 0, game = 0, set = 0, deucept = 0;

    public void addPt(){
        if(score == 0) score = 15;
        else if(score == 15) score = 30;
        else if(score == 30) score = 40;

    }
    public void deucePt(){
        deucept++;
    }

    public void addDeucept() {
        deucept++;
    }
    public int getDeucept(){
        return deucept;
    }


    public void addGame(){
        game++;
    }
    public void addSet(){
        set++;
    }

    public int getScore(){
        return this.score;
    }
    public int getGame(){
        return this.game;
    }
    public int getSet(){
        return this.set;
    }
    public void resetScore(TextView txt){
        this.score = 0;
        txt.setText("0");
    }
    public void resetGame(TextView gameBox){
        this.game = 0;
        gameBox.setText("0");
    }
    public void resetSet(TextView setBox){
        this.set = 0;
        setBox.setText("0");

    }
    public void resetDeuce(){
        this.deucept = 0;
    }
}