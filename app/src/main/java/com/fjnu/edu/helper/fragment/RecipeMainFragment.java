package com.fjnu.edu.helper.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.fjnu.edu.helper.R;
import com.fjnu.edu.helper.activity.RecipeActivity;

/**
 * Created by ZhouShiqiao on 2017/6/2 0002.
 */

public class RecipeMainFragment extends Fragment implements View.OnClickListener {
    private ImageButton search;

    private Context context;
    private View view;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        view = inflater.inflate(R.layout.fragment_recipe_main, container, false);
        findview();
        initview();
        return view;
    }

    private void findview(){
        search=(ImageButton)view.findViewById(R.id.recipemain_button_search);
    }
    private void initview(){
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.recipemain_button_search:
                Intent intent = new Intent(context,RecipeActivity.class);
                context.startActivity(intent);
                break;
        }
    }
}
