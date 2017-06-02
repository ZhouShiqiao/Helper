package com.fjnu.edu.helper.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fjnu.edu.helper.R;

/**
 * Created by ZhouShiqiao on 2017/5/29 0029.
 */

public class FoodMainFragment extends Fragment {
    private Context context;
    private View view;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        view = inflater.inflate(R.layout.fragment_food_main, container, false);

        return view;
    }
}
