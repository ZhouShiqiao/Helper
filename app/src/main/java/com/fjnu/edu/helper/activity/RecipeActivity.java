package com.fjnu.edu.helper.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fjnu.edu.helper.R;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
        }
    };

    class SearchRecipeThread{
        public SearchRecipeThread(){}

    }
}
