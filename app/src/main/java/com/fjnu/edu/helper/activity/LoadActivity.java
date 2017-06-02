package com.fjnu.edu.helper.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fjnu.edu.helper.R;

import java.util.Timer;
import java.util.TimerTask;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        final Intent localIntent=new Intent(this,MainActivity.class);
        Timer timer=new Timer();
        TimerTask tast=new TimerTask()
        {
            @Override
            public void run(){
                startActivity(localIntent);
                LoadActivity.this.finish();
            }
        };
        timer.schedule(tast,3000);
    }
}
