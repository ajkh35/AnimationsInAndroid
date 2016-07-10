package com.example.ajay.animationswithopengl;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CardFlip extends AppCompatActivity {

    ObjectAnimator mFlipAnimation;
    LinearLayout mLayout;
    ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_flip);

        mLayout = (LinearLayout) findViewById(R.id.layout);
        mImage = (ImageView) findViewById(R.id.image);

        mFlipAnimation = ObjectAnimator.ofInt(mLayout,"RotationX",0,360);

        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimatorSet set = (AnimatorSet) AnimatorInflater
                        .loadAnimator(CardFlip.this, R.animator.rotation);
                set.setTarget(mLayout);
                set.start();
            }
        });
    }
}