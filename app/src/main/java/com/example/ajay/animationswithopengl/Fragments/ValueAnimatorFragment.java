package com.example.ajay.animationswithopengl.Fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ajay.animationswithopengl.R;

/**
 * Created by ajay on 27/2/16.
 */
public class ValueAnimatorFragment extends Fragment implements View.OnClickListener{

    private LinearLayout mBallLayout;
    private ImageView mBall;
    private Button mAlpha;
    private Button mScale;
    private int mInterpolatorFlag = 0;
    private Button mLinearInterpolator;
    private Button mAccelerateDecelerateInterpolator;
    private ValueAnimator mAnimator;
    private final int DURATION = 3000;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.value_animator_fragment,null);

        initializeViews(view);
        addListeners();

        return view;
    }

    /**
     * Bind views to objects
     * @param view
     */
    private void initializeViews(View view){
        mInterpolatorFlag = 0;
        mBallLayout = (LinearLayout) view.findViewById(R.id.ball_layout);
        mBall = (ImageView) view.findViewById(R.id.ball);
        mAlpha = (Button) view.findViewById(R.id.alpha);
        mScale = (Button) view.findViewById(R.id.scale);
        mLinearInterpolator = (Button) view.findViewById(R.id.linear_interpolator);
        mAccelerateDecelerateInterpolator = (Button) view
                .findViewById(R.id.accelerate_decelerate_interpolator);
    }

    /**
     * Add listeners to clickable views
     */
    private void addListeners(){
        mAlpha.setOnClickListener(this);
        mScale.setOnClickListener(this);
        mLinearInterpolator.setOnClickListener(this);
        mAccelerateDecelerateInterpolator.setOnClickListener(this);
    }

    /**
     * OnClickListener implementation
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.alpha:
                animateAlpha(mBall);
                break;

            case R.id.scale:
                animateScale(mBallLayout);
                break;

            case R.id.linear_interpolator:
                mInterpolatorFlag = 0;
                Toast.makeText(getActivity(),"Linear Interpolator set",
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.accelerate_decelerate_interpolator:
                mInterpolatorFlag = 1;
                Toast.makeText(getActivity(),"Accelerate/Decelerate Interpolator set",
                        Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    /**
     * Method to animate alpha value of ball
     * @param view
     */
    private void animateAlpha(final View view){

        mAnimator = ValueAnimator.ofFloat(1, 0);
        mAnimator.setRepeatCount(0);
        setInterpolator();
        mAnimator.setDuration(DURATION);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                view.setAlpha((Float) animation.getAnimatedValue());
                view.requestLayout();
            }
        });
        setOnAnimationEnd("alpha",view);
        mAnimator.start();
    }

    /**
     * Method to animate scale of the view
     * @param view
     */
    private void animateScale(final View view){

        mAnimator = ValueAnimator.ofInt(0,500);
        mAnimator.setRepeatCount(0);
        setInterpolator();
        mAnimator.setDuration(DURATION);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                view.getLayoutParams().height = (int) animation.getAnimatedValue();
                view.getLayoutParams().width = (int) animation.getAnimatedValue();
                view.requestLayout();
            }
        });
        setOnAnimationEnd("scale", view);
        mAnimator.start();
    }

    /**
     * Method to set the interpolator
     */
    private void setInterpolator(){
        switch(mInterpolatorFlag){

            case 0:
                mAnimator.setInterpolator(new LinearInterpolator());
                break;

            case 1:
                mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                break;

            default:
                break;
        }
    }

    /**
     * Add listener on animation end
     */
    private void setOnAnimationEnd(final String pType,final View view){
        mAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {

                switch(pType){
                    case "alpha":
                        view.setVisibility(View.VISIBLE);
                        view.setAlpha(1);
                        break;

                    case "scale":
                        view.setVisibility(View.VISIBLE);
                        view.getLayoutParams().height =
                                (int) getResources().getDimension(R.dimen.dp_50);
                        view.getLayoutParams().width =
                                (int) getResources().getDimension(R.dimen.dp_50);
                        break;

                    default:
                        break;
                }

                super.onAnimationEnd(animation);
            }
        });
    }
}
