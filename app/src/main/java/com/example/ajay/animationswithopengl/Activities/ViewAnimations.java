package com.example.ajay.animationswithopengl.Activities;

import android.os.Bundle;
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
        toolbar.setNavigationIcon(R.drawable.rsz_ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mListView = (ListView) findViewById(R.id.view_animations_list);
        mDataList = getResources().getStringArray(R.array.view_animation_elements);
        ViewAnimationsAdapter lAdapter = new ViewAnimationsAdapter(this,mDataList);
        mListView.setAdapter(lAdapter);
    }

}