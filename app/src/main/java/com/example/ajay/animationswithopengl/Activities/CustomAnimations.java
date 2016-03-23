package com.example.ajay.animationswithopengl.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ajay.animationswithopengl.Adapter.CustomAnimationsAdapter;
import com.example.ajay.animationswithopengl.R;

public class CustomAnimations extends AppCompatActivity {

    private String[] mDataList;
    private ListView mList;
    private LinearLayout mBallLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_animations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.rsz_ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mDataList = getResources().getStringArray(R.array.custom_animation_elements);
        mList = (ListView) findViewById(R.id.custom_animation_list);
        mBallLayout = (LinearLayout) findViewById(R.id.ball_layout);


        CustomAnimationsAdapter adapter = new CustomAnimationsAdapter(this,mDataList);
        mList.setAdapter(adapter);
    }

}