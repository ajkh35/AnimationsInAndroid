package com.example.ajay.animationswithopengl.Fragments;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ajay.animationswithopengl.R;

/**
 * Created by ajay on 29/2/16.
 */
public class AnimatorSetFragment extends Fragment {

    private LinearLayout mBallLayout;
    private ImageView mBall;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.animator_set_fragment,null);

        mBall = (ImageView) view.findViewById(R.id.ball);
        mBallLayout = (LinearLayout) view.findViewById(R.id.ball_layout);

        AnimatorSet set = new AnimatorSet();
        Animator animator = ObjectAnimator.ofFloat(mBall,"alpha",1,0,1)
                            .setDuration(1000);
        Animator animator2 = ObjectAnimator.ofFloat(mBall,"scaleX",0,0.5f,1)
                            .setDuration(1000);
        set.play(animator).with(animator2);
        set.start();

        return view;
    }
}
