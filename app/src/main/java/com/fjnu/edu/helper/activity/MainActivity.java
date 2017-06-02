package com.fjnu.edu.helper.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fjnu.edu.helper.R;
import com.fjnu.edu.helper.fragment.FoodMainFragment;
import com.fjnu.edu.helper.view.SlidingMenu;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button food;
    private Button recipe;
    private Button note;
    private Button person;

    private FoodMainFragment foodmain;

    private SlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        initview();
        setDefaultFragment();
    }

    private void findview() {
        menu=(SlidingMenu)findViewById(R.id.id_menu);

    }

    private void initview() {

    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        foodmain = new FoodMainFragment();
        transaction.replace(R.id.main_content, foodmain);
        transaction.commit();
    }

    public void toggleMenu(View view)
    {
        menu.toggle();
    }
}
