package com.example.tictacgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity  {

    Boolean gameActive = true;
    int activePlayer = 1;//X starts always
    int stepsCounter = 0;

    ImageView imgPlayer;
    View restartBtn;

    //0-O
    //1-X
    //2-null

    int[] gridPosition = {2,2,2,2,2,2,2,2,2};//zero to make idx easier

    int[][] winningSequences = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restartBtn = findViewById(R.id.main_play_again_btn);
        restartBtn.setVisibility(View.GONE);

       // restartBtn.setOnClickListener(this);
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });




    }

    public Boolean checkWin(int activePlayer){
        return true;
    }

    public void resetGame(){
        ImageView empty1 = findViewById(R.id.main_empty_1);
        ImageView empty2 = findViewById(R.id.main_empty_2);
        ImageView empty3 = findViewById(R.id.main_empty_3);
        ImageView empty4 = findViewById(R.id.main_empty_4);
        ImageView empty5 = findViewById(R.id.main_empty_5);
        ImageView empty6 = findViewById(R.id.main_empty_6);
        ImageView empty7 = findViewById(R.id.main_empty_7);
        ImageView empty8 = findViewById(R.id.main_empty_8);
        ImageView empty9 = findViewById(R.id.main_empty_9);

        empty1.setImageResource(R.drawable.empty);
        empty2.setImageResource(R.drawable.empty);
        empty3.setImageResource(R.drawable.empty);
        empty4.setImageResource(R.drawable.empty);
        empty5.setImageResource(R.drawable.empty);
        empty6.setImageResource(R.drawable.empty);
        empty7.setImageResource(R.drawable.empty);
        empty8.setImageResource(R.drawable.empty);
        empty9.setImageResource(R.drawable.empty);

        imgPlayer =  findViewById(R.id.main_X_play);
        restartBtn.setVisibility(View.GONE);

        gameActive = true;
        stepsCounter = 0;
        activePlayer = 1;//X start
        Arrays.fill(gridPosition, 2);
    }

    public void playerTap(View view){
        imgPlayer =  findViewById(R.id.main_X_play);
        ImageView imgIndex =  (ImageView) view;
        int tappedImg = Integer.parseInt(imgIndex.getTag().toString());
        Log.d("TAG" , "location in grid: " + tappedImg);

        if(stepsCounter==9){
            gameActive = false;
        }
        else if(activePlayer == 0 && gridPosition[tappedImg-1]==2){
            if(stepsCounter == 8){
                restartBtn.setVisibility(View.VISIBLE);
            }
            gridPosition[tappedImg-1] = 0;
            imgIndex.setImageResource(R.drawable.o);
            //checkWin(activePlayer)
            stepsCounter++;
            activePlayer = 1;
            imgPlayer.setImageResource(R.drawable.xplay);
            System.out.println(Arrays.toString(gridPosition));

        }
        else if(activePlayer == 1 && gridPosition[tappedImg-1]==2){
            if(stepsCounter == 8){
                restartBtn.setVisibility(View.VISIBLE);
            }
            gridPosition[tappedImg-1] = 1;
            imgIndex.setImageResource(R.drawable.x);
            //checkWin(activePlayer)-->if win -->r.draw.Xwins...
            stepsCounter++;
            activePlayer = 0;
            imgPlayer.setImageResource(R.drawable.oplay);
            System.out.println(Arrays.toString(gridPosition));
        }
    }

}