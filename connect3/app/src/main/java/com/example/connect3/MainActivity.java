package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
int active=0;
boolean isactive=true;
int[] tagcount={2,2,2,2,2,2,2,2,2};
int [][] winpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void dropin(View view) {
        ImageView img = (ImageView) view;
        int tt = Integer.parseInt(img.getTag().toString());
        if (tagcount[tt] == 2 && isactive) {
            tagcount[tt]=active;
            img.setTranslationY(-1000f);
            if (active == 0) {
                img.setImageResource(R.drawable.yellow);
                active = 1;
            } else {
                img.setImageResource(R.drawable.red);
                active = 0;
            }
            img.animate().translationYBy(1000f).setDuration(300);
            for(int[] wp :winpos){
                if(tagcount[wp[0]]==tagcount[wp[1]] && tagcount[wp[1]]==tagcount[wp[2]] && tagcount[wp[0]]!=2){
                    isactive=false;
                    String winn="Red";
                    if(tagcount[wp[0]]==0){
                        winn="Yellow";
                    }
                    TextView txt = (TextView)findViewById(R.id.txt);
                    txt.setText(winn +" HAS WON!");
                    LinearLayout layout = (LinearLayout)findViewById(R.id.layout);

                        layout.setVisibility(View.VISIBLE);
                    }else{
                    boolean isover=true;
                    for(int i:tagcount){
                        if(i==2) isover=false;
                    }
                    if(isover){
                        TextView txt = (TextView)findViewById(R.id.txt);
                        txt.setText("ITS A DRAW");
                        LinearLayout layout = (LinearLayout)findViewById(R.id.layout);

                        layout.setVisibility(View.VISIBLE);
                    }
                }

            }
        }
    }
    public void again(View view){
        isactive=true;
        LinearLayout layout = (LinearLayout)findViewById(R.id.layout);
        layout.setVisibility(View.INVISIBLE);
        active=0;
        for(int i=0;i<tagcount.length;i++){
            tagcount[i]=2;
        }
        GridLayout gg=(GridLayout)findViewById(R.id.grid);
        for(int i=0;i<gg.getChildCount();i++){
            ((ImageView) gg.getChildAt(i)).setImageResource(0);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
