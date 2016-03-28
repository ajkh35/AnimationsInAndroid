package com.example.ajay.animationswithopengl.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajay.animationswithopengl.Fragments.TransitionsFragment;
import com.example.ajay.animationswithopengl.R;

/**
 * Created by ajay on 22/3/16.
 */
public class CustomAnimationsAdapter extends BaseAdapter {

    private String[] mDataList;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private FrameLayout mFrame;

    public CustomAnimationsAdapter(Context context,String[] dataList,
                                   FragmentManager pFragmentManager,FrameLayout pFrame){
        mContext = context;
        mDataList = dataList;
        mFragmentManager = pFragmentManager;
        mFrame = pFrame;
    }

    /**
     * RowHolder class
     */
    private class RowHolder{

        LinearLayout mLayout;
        TextView mText;

        public RowHolder(View convertView){
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

        RowHolder holder;

        if(convertView == null){

            convertView = LayoutInflater.from(mContext).inflate(R.layout.row_custom_animations,null);
            holder = new RowHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (RowHolder) convertView.getTag();
        }

        holder.mText.setText(mDataList[position]);
        holder.mLayout.setBackgroundColor(getColor());
        setOnClickListenerForRow(holder, position);
        return convertView;
    }

    /**
     * Method to set on click listener for row click
     * @param holder
     */
    private void setOnClickListenerForRow(RowHolder holder, final int position){

        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = null;

                switch(position){
                    case 0:
                        fragment = new TransitionsFragment();
                        break;

                    case 1:
                        break;

                    default:
                        break;
                }

                mFragmentManager.beginTransaction()
                        .replace(mFrame.getId(), fragment)
                        .commit();
            }
        });
    }

    /**
     * Method to fetch color for row
     * @return
     */
    private int getColor(){
        return R.color.colorPrimary;
    }
}
