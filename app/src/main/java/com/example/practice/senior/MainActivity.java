package com.example.practice.senior;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Switch myswitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
        setTheme(R.style.newtheme);
        }
        else{
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myswitch=(Switch) findViewById(R.id.switch1);

        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            myswitch.setChecked(true);
        }
        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartApp();
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartApp();
                }
            }
        });


       final ImageView one=(ImageView) findViewById(R.id.imageView3);
       final ImageView two=(ImageView) findViewById(R.id.two);

       final Button button2=(Button) findViewById(R.id.button2);

       final int dicearr[]={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six};
       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Random rand=new Random();
               int num=rand.nextInt(6);
               one.setImageResource(dicearr[num]);
               num=rand.nextInt(6);
               two.setImageResource(dicearr[num]);
           }
       });
    }
    public void restartApp(){
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }

}
