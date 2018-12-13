package com.example.renzhili20181213;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<MyImageView> list;
    private ValueAnimator valueAnimator;
    private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyImageView image1 = findViewById(R.id.image1);
        MyImageView image2 = findViewById(R.id.image2);
        MyImageView image3 = findViewById(R.id.image3);
        MyImageView image4 = findViewById(R.id.image4);
        MyImageView image5 = findViewById(R.id.image5);
        MyImageView image6 = findViewById(R.id.image6);
        MyImageView image7 = findViewById(R.id.image7);
        MyImageView image8 = findViewById(R.id.image8);
        list=new ArrayList<>();
        list.add(image1);
        list.add(image2);
        list.add(image3);
        list.add(image4);
        list.add(image5);
        list.add(image6);
        list.add(image7);
        list.add(image8);
        setAnimation(i);

    }

    private void setAnimation(final int i) {
        valueAnimator=ValueAnimator.ofInt(Color.parseColor("#ffcc66"),Color.parseColor("#ffcc33"));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int color = (int) valueAnimator.getAnimatedValue();
                list.get(i).setBackgroundColor(color);
            }
        });
        valueAnimator.setDuration(3000);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.start();
        if (i==7){
            return;
        }
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                setAnimation(i+1);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
    }

}
