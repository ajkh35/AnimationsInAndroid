package com.example.ajay.animationswithopengl.Adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajay.animationswithopengl.R;

/**
 * Created by ajay on 15/2/16.
 */
public class ViewAnimationsAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflator;
    private String[] mDataList;
    private Animation mAnimation;

    public ViewAnimationsAdapter(Context pContext,String[] pDataList){
        mContext = pContext;
        mDataList = pDataList;
        mInflator = (LayoutInflater) pContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private class ViewHolder{
        public LinearLayout mLayout;
        public TextView mText;

        public ViewHolder(View convertView){
            mLayout = (LinearLayout) convertView.findViewById(R.id.animation_layout);
            mText = (TextView) convertView.findViewById(R.id.animation_name);
        }
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

        ViewHolder lHolder;

        if(convertView == null){
            convertView = mInflator.inflate(R.layout.list_view_animations,null);
            lHolder = new ViewHolder(convertView);
            convertView.setTag(lHolder);
        }else{
            lHolder = (ViewHolder) convertView.getTag();
        }

        lHolder.mText.setText(mDataList[position]);
        lHolder.mLayout.setBackgroundColor(getViewColor());
        setOnClickListenerForCard(lHolder, position);
        return convertView;
    }

    private void setOnClickListenerForCard(ViewHolder pHolder,final int position){

        pHolder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                new AsyncTask<String,String,String>(){

                    @Override
                    protected void onPreExecute() {

                        switch(position){

                            case 0:
                                mAnimation = AnimationUtils.loadAnimation(mContext,R.anim.tween);
                                break;
                            case 1:
                                mAnimation = AnimationUtils.loadAnimation(mContext,R.anim.scaling);
                                break;
                            case 2:
                                mAnimation = AnimationUtils.loadAnimation(mContext,R.anim.rotation);
                                break;
                            case 3:
                                mAnimation = AnimationUtils.loadAnimation(mContext,R.anim.transform);
                                break;
                            case 4:
                                mAnimation = AnimationUtils.loadAnimation(mContext,R.anim.custom_view_animations);
                                break;
                            default:
                                break;
                        }

                        v.startAnimation(mAnimation);
                        super.onPreExecute();
                    }

                    @Override
                    protected String doInBackground(String... params) {
                        return null;
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        Toast.makeText(mContext,R.string.notice_animation,Toast.LENGTH_SHORT).show();
                        super.onPostExecute(s);
                    }

                }.execute();
            }
        });
    }

    private int getViewColor(){
        return R.color.colorPrimary;
    }
}
