package com.example.ajay.animationswithopengl.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.ajay.animationswithopengl.Adapter.PropertyAnimationsAdapter;
import com.example.ajay.animationswithopengl.R;

public class PropertyAnimations extends AppCompatActivity {

    private ListView mListView;
    private String[] mDataList;
    private FrameLayout mFrame;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.rsz_ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mFrame.getVisibility()==View.VISIBLE){
                    mFrame.setVisibility(View.GONE);
                    mListView.setVisibility(View.VISIBLE);
                    return;
                }
                finish();
            }
        });

        mListView = (ListView) findViewById(R.id.property_animations_list);
        mFrame = (FrameLayout) findViewById(R.id.content_fragment);
        mFragmentManager = getSupportFragmentManager();
        mDataList = getResources().getStringArray(R.array.property_animation_elements);
        PropertyAnimationsAdapter adapter = new PropertyAnimationsAdapter(
                PropertyAnimations.this,mDataList,mFrame,mListView,mFragmentManager);
        mListView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {

        if(mFrame.getVisibility()==View.VISIBLE){
            mFrame.setVisibility(View.GONE);
            mListView.setVisibility(View.VISIBLE);
            return;
        }
        super.onBackPressed();
    }
}