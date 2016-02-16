package com.example.ajay.animationswithopengl.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.ajay.animationswithopengl.Adapter.ViewAnimationsAdapter;
import com.example.ajay.animationswithopengl.R;

public class ViewAnimations extends AppCompatActivity {

    private ListView mListView;
    private String[] mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mListView = (ListView) findViewById(R.id.view_animations_list);
        mDataList = getResources().getStringArray(R.array.view_animation_elements);
        ViewAnimationsAdapter lAdapter = new ViewAnimationsAdapter(this,mDataList);
        mListView.setAdapter(lAdapter);
    }

}
