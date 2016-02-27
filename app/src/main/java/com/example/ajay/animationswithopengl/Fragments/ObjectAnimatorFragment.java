package com.example.ajay.animationswithopengl.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by ajay on 28/2/16.
 */
public class ObjectAnimatorFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Toast.makeText(getActivity(),"In Object Animator Fragment",Toast.LENGTH_SHORT).show();

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
