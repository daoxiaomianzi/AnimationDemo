package com.xuyong.animationdemo;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;
    private ImageView image7;
    private ImageView image8;
    private ImageView image9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        image5 = (ImageView) findViewById(R.id.image5);
        image6 = (ImageView) findViewById(R.id.image6);
        image7 = (ImageView) findViewById(R.id.image7);
        image8 = (ImageView) findViewById(R.id.image8);
        image9 = (ImageView) findViewById(R.id.image9);
        //帧动画
        AnimationDrawable animationDrawable = (AnimationDrawable) image1.getDrawable();
        animationDrawable.start();
        //补间动画
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        //透明
        image2.startAnimation(animation);
        //位移
        image3.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate_anim));
        //缩放大小
        image4.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_anim));
        //旋转
        image5.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate_anim));
        //4种补间动画组合
        image6.startAnimation(AnimationUtils.loadAnimation(this, R.anim.set4_anim));

        //3.0后属性动画
        //用属性动画实现补间动画
        RotateAnimation();
        AlpahAnimation();
        ScaleAnimation();

        //自定义属性动画
//        Point startP = new Point(0, 0);//初始值（起点）
//        Point endP = new Point(getWidth() - RADIUS, getHeight() - RADIUS);//结束值（终点）
//        final ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointSinEvaluator(), startP, endP);
//        valueAnimator.setRepeatCount(-1);
//        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//              Point   currentPoint = (Point) animation.getAnimatedValue();
//                postInvalidate();
//            }
//
//        });

    }

    private void RotateAnimation() {//旋转
        ObjectAnimator anim = ObjectAnimator.ofFloat(image7, "rotation", 0f, 360f);
        anim.setDuration(1000);
        anim.setRepeatCount(1000);
        anim.start();
    }

    private void AlpahAnimation() {//透明
        ObjectAnimator anim = ObjectAnimator.ofFloat(image8, "alpha", 1.0f, 0.8f, 0.6f, 0.4f, 0.2f, 0.0f);
        anim.setRepeatCount(2000);
        anim.setRepeatMode(ObjectAnimator.REVERSE);
        anim.setDuration(2000);
        anim.start();
    }

    private void ScaleAnimation() {//缩放大小
        ObjectAnimator anim = ObjectAnimator.ofFloat(image9, "scaleX", 0.0f, 1.0f);
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(image9, "scaleY", 0.0f, 1.0f);
        anim.setRepeatCount(100);
        anim.setRepeatMode(ObjectAnimator.REVERSE);
        anim.setDuration(2000);
        anim.start();
        anim1.setRepeatCount(100);
        anim1.setRepeatMode(ObjectAnimator.REVERSE);
        anim1.setDuration(2000);
        anim1.start();
    }

}
