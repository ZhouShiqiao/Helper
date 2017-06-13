package com.fjnu.edu.helper.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

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
                showdialog();
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

    private void showdialog(){
        final Dialog dialog = new Dialog(this, R.style.Theme_Light_Dialog);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_food,null);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.dialogStyle);
        window.getDecorView().setPadding(0, 0, 0, 0);
        android.view.WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        dialog.setContentView(dialogView);
        Button confirm = (Button) dialogView.findViewById(R.id.add_food_button_confirm);
        Button cancel = (Button) dialogView.findViewById(R.id.add_food_button_cancel);
        dialog.show();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}

