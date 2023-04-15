package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
TextView t1;
int mseconds=0;
boolean isRunning;
int toggle=0;
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.timertext);
        starttimer();
    }
    public void onclickstart(View view){

        if(toggle==0){
            isRunning=true;
            toggle=1;
        }else if(toggle==1){
            isRunning=false;
            toggle=0;
        }
    }

    public void onclickreset(View view){
     isRunning=false;
     mseconds=0;
     a=0;
     toggle=0;

    }

    public void starttimer(){
        Handler handler =new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                int ms=mseconds%60;
                int s=(mseconds/60)%60;

                if(s==59){
                    a++;
                }
                int min=a/60;
                if(isRunning){
                mseconds++;}
                String formatstring=String.format(Locale.getDefault(),"%02d:%02d:%02d",min,s,ms);
                t1.setText(formatstring);
                handler.postDelayed(this,10);
            }
        };
        handler.post(runnable);
    }
}