package labo2.labo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import labo2.labo2.gameLogic.*;

public class MainActivity extends AppCompatActivity {

    TextView[] txt = new TextView[7];
    Player player1, player2;
    Score score;
    boolean isDeuce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1= new Player();
        player2= new Player();
        score = new Score();
        txt[0] = findViewById(R.id.S1);
        txt[1] = findViewById(R.id.G1);
        txt[2] = findViewById(R.id.ST1);
        txt[3] = findViewById(R.id.S2);
        txt[4] = findViewById(R.id.G2);
        txt[5] = findViewById(R.id.ST2);
        txt[6] = findViewById(R.id.info);
    }
    public void btClick1(View v){
        if(!isDeuce){
            if(player1.getScore() < 40 ) {

                player1.addPt();
                score.updateScore(player1, txt[0]);
            }else {

                score.updateGame(player1, player2, txt[1], txt[0], txt[3]);
            }
        }else{
            score.deuceProc(player1, player2,txt[0], txt[3]);
            score.updateGame(player1, player2, txt[1], txt[0], txt[3]);
            if(player1.getDeucept() - player2.getDeucept() == 2){
                player1.resetDeuce();
                player2.resetDeuce();
                player1.resetScore(txt[0]);
                player2.resetScore(txt[3]);
                isDeuce = false;
                txt[6].setText("");
            }
        }

        if(player1.getGame() >= 6){

            score.updateSet(player1,player2,txt[2], txt[1], txt[4]);
        }
        if((player1.getSet() == 2 && player2.getSet() ==1) || (player1.getSet() == 2 && player2.getSet() ==0) ){
            txt[6].setText("Player 1 Ha Ganado");
            Button btn = findViewById(R.id.play1);
            btn.setEnabled(false);
            btn = findViewById(R.id.play2);
            btn.setEnabled(false);
        }
        if(player1.getScore() == 40 && player2.getScore() == 40){
            isDeuce = true;
            player1.resetScore(txt[0]);
            player2.resetScore(txt[3]);
            txt[6].setText("DEUCE");
        }
    }

    public void btClick2(View v){
        if(!isDeuce) {
            if (player2.getScore() < 40) {
                player2.addPt();
                score.updateScore(player2, txt[3]);
            } else {
                score.updateGame(player2, player1, txt[4], txt[3], txt[0]);
            }
        }else{
            System.out.println(player2.getDeucept());
            score.deuceProc(player2, player1,txt[3], txt[0]);
            score.updateGame(player2, player1, txt[4], txt[3], txt[0]);
            if(player2.getDeucept() - player1.getDeucept() == 2){
                player1.resetDeuce();
                player2.resetDeuce();
                player1.resetScore(txt[0]);
                player2.resetScore(txt[3]);
                isDeuce = false;
                txt[6].setText("");
            }
        }

        if(player2.getGame() >= 6){
            score.updateSet(player2,player1,txt[5], txt[4], txt[1]);
        }
        if((player2.getSet() == 2 && player1.getSet() ==1) || (player2.getSet() == 2 && player1.getSet() ==0) ){
            txt[6].setText("Player 2 Ha Ganado");
            Button btn = findViewById(R.id.play1);
            btn.setEnabled(false);
            btn = findViewById(R.id.play2);
            btn.setEnabled(false);
        }
        if(player1.getScore() == 40 && player2.getScore() == 40){
            isDeuce = true;
            player1.resetScore(txt[0]);
            player2.resetScore(txt[3]);
            txt[6].setText("DEUCE");
        }
    }
    public void btnClick3(View v){
        player1.resetScore(txt[0]);
        player1.resetGame(txt[1]);
        player1.resetSet(txt[2]);
        player2.resetScore(txt[3]);
        player2.resetGame(txt[4]);
        player2.resetSet(txt[5]);
        txt[6].setText("");
        Button btn = findViewById(R.id.play1);
        btn.setEnabled(true);
        btn = findViewById(R.id.play2);
        btn.setEnabled(true);
        isDeuce = false;
        player1.resetDeuce();
        player2.resetDeuce();
    }
}