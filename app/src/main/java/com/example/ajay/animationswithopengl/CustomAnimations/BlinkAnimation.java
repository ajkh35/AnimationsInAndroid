package com.example.ajay.animationswithopengl.CustomAnimations;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by ajay on 30/3/16.
 */
public class BlinkAnimation extends Animation{

    private View mView;
    private boolean isVisible = false;
    private int mBlinkCount = 10;

    public BlinkAnimation(View view){
        mView = view;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
    }
}
