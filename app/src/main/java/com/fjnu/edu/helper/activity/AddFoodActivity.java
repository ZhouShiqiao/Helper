package com.fjnu.edu.helper.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.fjnu.edu.helper.R;
import com.fjnu.edu.helper.adapter.AddFoodGridAdapter;
import com.fjnu.edu.helper.datebase.DBManager;
import com.fjnu.edu.helper.food.AddFoodInformation;

import java.util.ArrayList;

public class AddFoodActivity extends AppCompatActivity {
    private SearchView search;
    private GridView grid;

    private AddFoodGridAdapter adapter;

    private DBManager mgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        mgr = new DBManager(this);

        findview();
        initview();
    }

    private void findview() {
        search = (SearchView) findViewById(R.id.addfood_textview_search);
        grid = (GridView) findViewById(R.id.addfood_gridview_list);
    }

    private void initview() {
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                setgrid(newText);
                return false;
            }
        });
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AddFoodInformation afi = (AddFoodInformation) adapter.getItem(position);

            }
        });
    }

    private void setgrid(String str) {
        if (str.length() > 0)
            adapter = new AddFoodGridAdapter(this, mgr.queryaddfoodinformation(str));
        else
            adapter = new AddFoodGridAdapter(this, new ArrayList<AddFoodInformation>());
        grid.setAdapter(adapter);
    }
}

