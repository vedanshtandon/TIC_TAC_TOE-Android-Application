package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameactive=true;
     // player representations
     // 0-X
     // 1-0
    int activePlayer=0;
    int[] gamestate={2, 2, 2, 2, 2, 2, 2, 2, 2};
    // 0-X
    // 1-0
    // 2==null

    int [][] winpositions={ {0,1,2} , {3,4,5} , {6,7,8} , {0,3,6} , {1,4,7} , {2,5,8} , {0,4,8}  , {2,4,6} };


    public void playerTap(View view)
    {
        ImageView img = (ImageView) view;
        int tappedImage=Integer.parseInt(img.getTag().toString());


        if(!gameactive) {
            gamereset(view);
        }
        if(gamestate[tappedImage]==2 && gameactive)
        {
            gamestate[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0)
            {
                img.setImageResource(R.drawable.cross);
                TextView status=findViewById(R.id.status);
                activePlayer=1;
                status.setText("O's Turn Tap To Play");
            }
            else
            {
                img.setImageResource(R.drawable.o);
                activePlayer=0;
                TextView status=findViewById(R.id.status);
                status.setText("X's Turn Tap To Play");
            }
            img.animate().translationYBy(1000f).setDuration(100);
        }
        // check if player has won or not

        for(int[] winposition: winpositions)
        {
            if(gamestate[winposition[0]]==gamestate[winposition[1]] && gamestate[winposition[1]]==gamestate[winposition[2]] && gamestate[winposition[1]]!=2)
            {
                gameactive=false;
                if(gamestate[winposition[0]]==0)
                {
                    TextView status=findViewById(R.id.status);
                    status.setText("X player has won");
                }
                else
                {
                    TextView status=findViewById(R.id.status);
                    status.setText("O player has won");
                }
            }
        }
    }

    public void gamereset(View view)
    {
        gameactive=true;
        activePlayer=0;
        for(int i=0;i<9;i++)
        {
            gamestate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status=findViewById(R.id.status);
        status.setText("X's Turn Tap To Play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}