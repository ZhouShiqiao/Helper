package com.fjnu.edu.helper.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.fjnu.edu.helper.recipe.Recipe;

import java.util.ArrayList;

/**
 * Created by ZhouShiqiao on 2017/6/18 0018.
 */

public class RecipeListAdapter extends BaseAdapter {
    private ArrayList<Recipe> list;
    private Context context;

    public RecipeListAdapter(ArrayList<Recipe> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
