package com.example.ajay.animationswithopengl.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajay.animationswithopengl.Activities.ViewAnimations;
import com.example.ajay.animationswithopengl.R;

/**
 * Created by ajay on 31/1/16.
 */
public class MyAdapter extends BaseAdapter{

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
    public View getView(final int position, View convertView, ViewGroup parent) {

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

        setOnClickListenerForCard(convertView,position);
        return convertView;
    }

    private void setOnClickListenerForCard(View convertView, final int position){

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                switch (position) {

                    case 0:
                        new AsyncTask<String,String,String>(){
                            @Override
                            protected void onPreExecute() {
                                Animation lAnimation = AnimationUtils.loadAnimation(mContext,R.anim.tween);
                                v.startAnimation(lAnimation);
                                super.onPreExecute();
                            }

                            @Override
                            protected String doInBackground(String... params) {
                                try {
                                    Thread.sleep(400);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                return null;
                            }

                            @Override
                            protected void onPostExecute(String s) {
                                Intent intent = new Intent(mContext, ViewAnimations.class);
                                mContext.startActivity(intent);
                                super.onPostExecute(s);
                            }
                        }.execute();
                        break;

                    case 1:
                        Toast.makeText(mContext,mContext.getString(R.string.property_animations),
                                Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        Toast.makeText(mContext,mContext.getString(R.string.drawable_animations),
                                Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        Toast.makeText(mContext,mContext.getString(R.string.custom_animations),
                                Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        break;
                }
            }
        });
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

                case 3:
                    color = ContextCompat.getColor(mContext,android.R.color.holo_orange_dark);
                    break;

                default:
                    break;
            }

        return color;
    }
}