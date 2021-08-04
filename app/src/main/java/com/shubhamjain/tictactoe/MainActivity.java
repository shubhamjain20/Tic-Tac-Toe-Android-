package com.shubhamjain.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int gameFinish=0;
    boolean isGameActive=true;


    public void gameFinished(String s){

        LinearLayout scoreView=(LinearLayout) findViewById(R.id.scoreView);
        TextView textView=(TextView)findViewById(R.id.textView);

        scoreView.setAlpha(1f);
        textView.setText(s);
        isGameActive=false;

    }

    public void clickFunc(View view){

        gameFinish++;

        ImageView e=(ImageView)view;



        int activePlayerState=Integer.parseInt(e.getTag().toString());

        if(gameState[activePlayerState]==2 && isGameActive) {

             gameState[activePlayerState]=activePlayer;
             e.setTranslationY(-1000f);
             if (activePlayer == 0) {
                e.setImageResource(R.drawable.circle);
                activePlayer = 1;
             } else {
                e.setImageResource(R.drawable.cross);
                activePlayer = 0;
             }


            e.animate().translationYBy(1000f).setDuration(200);

        }


        //Winning algorithm

        if(     (gameState[0]==1 && gameState[1]==1 && gameState[2]==1) ||
                (gameState[3]==1 && gameState[4]==1 && gameState[5]==1) ||
                (gameState[6]==1 && gameState[7]==1 && gameState[8]==1) ||
                (gameState[0]==1 && gameState[3]==1 && gameState[6]==1) ||
                (gameState[1]==1 && gameState[4]==1 && gameState[7]==1) ||
                (gameState[2]==1 && gameState[5]==1 && gameState[8]==1) ||
                (gameState[1]==1 && gameState[4]==1 && gameState[8]==1) ||
                (gameState[2]==1 && gameState[4]==1 && gameState[6]==1) )
        {
             gameFinished("X Won!");
        }

        else if((gameState[0]==0 && gameState[1]==0 && gameState[2]==0) ||
                (gameState[3]==0 && gameState[4]==0 && gameState[5]==0) ||
                (gameState[6]==0 && gameState[7]==0 && gameState[8]==0) ||
                (gameState[0]==0 && gameState[3]==0 && gameState[6]==0) ||
                (gameState[1]==0 && gameState[4]==0 && gameState[7]==0) ||
                (gameState[2]==0 && gameState[5]==0 && gameState[8]==0) ||
                (gameState[0]==0 && gameState[4]==0 && gameState[8]==0) ||
                (gameState[2]==0 && gameState[4]==0 && gameState[6]==0) )
        {
            gameFinished("O Won!");
        }

        else if(gameFinish==9) {

            gameFinished("Draw!");

        }




    }

    public void playAgain(View view){
        isGameActive=true;
         LinearLayout scoreView=(LinearLayout) findViewById(R.id.scoreView);
         scoreView.setAlpha(0f);
         activePlayer=0;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }

        gameFinish=0;


        GridLayout board=(GridLayout)findViewById(R.id.board);
        for(int i=0;i<board.getChildCount();i++){
            ((ImageView)board.getChildAt(i)).setImageDrawable(null);
        }





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}