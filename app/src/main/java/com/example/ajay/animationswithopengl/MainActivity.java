package com.example.ajay.animationswithopengl;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import com.example.ajay.animationswithopengl.Adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView mList;
    private String[] mData;
    private final int COUNT = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mData = getResources().getStringArray(R.array.list_elements);
        mList = (ListView) findViewById(R.id.list);

        MyAdapter lAdapter = new MyAdapter(this,mData);
        mList.setAdapter(lAdapter);

    }

}