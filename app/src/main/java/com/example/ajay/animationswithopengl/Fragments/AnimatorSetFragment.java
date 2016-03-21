package com.example.ajay.animationswithopengl.Fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import android.widget.RelativeLayout;

import com.example.ajay.animationswithopengl.R;

import javax.xml.datatype.Duration;

/**
 * Created by ajay on 29/2/16.
 */
public class AnimatorSetFragment extends Fragment {

    private LinearLayout mBallLayout;
    private ImageView mBall;
    private AnimatorSet mAnimatorSet;
    private ValueAnimator mTransformAnimator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.animator_set_fragment,null);

        mBall = (ImageView) view.findViewById(R.id.ball);
        mBallLayout = (LinearLayout) view.findViewById(R.id.ball_layout);

        mAnimatorSet = new AnimatorSet();

        Animator animator = ObjectAnimator.ofFloat(mBall,"alpha",1,0,1)
                            .setDuration(1000);
        Animator animator2 = ObjectAnimator.ofFloat(mBall, "scaleX", 0, 0.25f,0.5f, 0.75f, 1)
                            .setDuration(1000);
        Animator animator3 = ObjectAnimator.ofFloat(mBallLayout, "scaleY", 0, 0.25f, 0.5f, 0.75f, 1)
                            .setDuration(1000);

        //To create a transform animation
        createTransformAnimation();

        mAnimatorSet.play(animator)
                .with(animator2)
                .with(animator3)
                .after(mTransformAnimator);
        mAnimatorSet.start();
        return view;
    }

    /**
     * Method to create a transformation animation
     */
    private void createTransformAnimation(){

        final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mBallLayout.getLayoutParams();
        mTransformAnimator = ValueAnimator.ofInt(params.topMargin, params.topMargin +
                (int) getResources().getDimension(R.dimen.dp_150))
                .setDuration(1000);
        mTransformAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                params.topMargin = (int) animation.getAnimatedValue();
                mBallLayout.requestLayout();
            }
        });
    }
}