package com.example.ajay.animationswithopengl.Interpolators;

import android.graphics.Interpolator;

/**
 * Created by ajay on 28/2/16.
 */
public class CustomInterpolator implements android.view.animation.Interpolator {

    public CustomInterpolator(){
    }

    @Override
    public float getInterpolation(float input) {
        float x = 2.0f * input - 1.0f;
        return 0.5f * (x*x*x + 1.0f);
    }
}