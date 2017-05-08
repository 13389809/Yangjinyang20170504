package com.example.administrator.yangjinyang20170504;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
//当前时间为 10:30，我正在做月考B卷。 我是杨金阳，专业：移动互联，班级：10A
public class MainActivity extends Activity {
    private TextView mtext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtext = (TextView) findViewById(R.id.main_text);
        //动画
        Animation animation = new ScaleAnimation(1.5f,0.2f,1.5f,0.2f);
        animation.setDuration(2000);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(MainActivity.this,TwoActivity.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mtext.setAnimation(animation);
        animation.start();



    }
}
