package com.example.ajay.animationswithopengl.Adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ajay.animationswithopengl.R;
import com.example.ajay.animationswithopengl.RowClickListener;

import java.util.ArrayList;

/**
 * Created by ajay on 31/1/16.
 */
public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private String[] mDataList;

    private class MyViewHolder{
        private TextView mTitle;

        public MyViewHolder(View pConvertView){
            mTitle = (TextView) pConvertView.findViewById(R.id.title);
        }
    }

    public MyAdapter(Context pContext,String[] pDataList){
        mContext = pContext;
        mDataList = pDataList;
    }

    @Override
    public int getCount() {
        return mDataList.length;
    }

    @Override
    public Object getItem(int position) {
        return mDataList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder lHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_row,null);
            lHolder = new MyViewHolder(convertView);
            convertView.setTag(lHolder);
        }else{
            lHolder = (MyViewHolder) convertView.getTag();
        }

        lHolder.mTitle.setText(mDataList[position]);
        convertView.setBackgroundColor(getViewColor(position));
        return convertView;
    }

    private int getViewColor(int position){
        int color = 0x000;

            switch (position){

                case 0:
                    color = ContextCompat.getColor(mContext,R.color.colorAccent);

                    break;
                case 1:
                    color = ContextCompat.getColor(mContext,android.R.color.holo_purple);
                    break;
                case 2:
                    color = ContextCompat.getColor(mContext,R.color.colorPrimary);

                    break;
                default:
                    break;
            }

        return color;
    }
}