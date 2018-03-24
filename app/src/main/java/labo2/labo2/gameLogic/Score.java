package labo2.labo2.gameLogic;

import android.widget.TextView;

import java.sql.SQLOutput;

/**
 * Created by UCA on 23/3/2018.
 */

public class Score {

    public void updateGame(Player player, Player otherPlayer, TextView gameBox, TextView scoreBox, TextView scoreBox2){
        //Revisa si hay game
        if(player.getScore() == 40 && (otherPlayer.getScore() == 0 || otherPlayer.getScore() == 15 || otherPlayer.getScore() == 30 )){
            player.addGame();
            gameBox.setText(Integer.toString(player.getGame()));
            player.resetScore(scoreBox);
            otherPlayer.resetScore(scoreBox2);
        }
    }
    public void updateSet(Player player, Player otherPlayer, TextView setBox, TextView gameBox, TextView gameBox2){
        //Revisa si hay game
        if(player.getGame() >=6 && (player.getGame() - otherPlayer.getGame() >= 2)){
            player.addSet();
            setBox.setText(Integer.toString(player.getSet()));
            player.resetGame(gameBox);
            otherPlayer.resetGame(gameBox2);

        }
    }
    public void updateScore(Player player, TextView scoreBox){
        scoreBox.setText(Integer.toString(player.getScore()));
    }

    public void deuceProc(Player player, Player otherPlayer, TextView scoreBox, TextView scoreBox2){
        player.addDeucept();
        if(player.getDeucept()- otherPlayer.getDeucept() == 1){
            scoreBox.setText("AD");
        }else if(player.getDeucept()-otherPlayer.getDeucept() == 2) {
            player.addPt();
            player.addPt();
            player.addPt();
            player.addPt();
        }
        else {
            scoreBox.setText("0");
            scoreBox2.setText("0");
        }

    }
}