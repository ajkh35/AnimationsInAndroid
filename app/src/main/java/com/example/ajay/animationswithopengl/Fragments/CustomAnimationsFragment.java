package com.example.ajay.animationswithopengl.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ajay.animationswithopengl.Adapter.CustomAnimationsFragmentAdapter;
import com.example.ajay.animationswithopengl.R;

/**
 * Created by ajay on 30/3/16.
 */
public class CustomAnimationsFragment extends Fragment {

    private ListView mList;
    private String[] mDataList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.custom_animations_fragment,container,false);
        mList = (ListView) view.findViewById(R.id.custom_animations);
        mDataList = getResources().getStringArray(R.array.custom_animations_fragment_elements);

        CustomAnimationsFragmentAdapter adapter =
                new CustomAnimationsFragmentAdapter(getActivity(),mDataList);
        mList.setAdapter(adapter);

        return view;
    }
}
