package com.aimu.inventorymanage.activity;

import android.content.Intent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import com.aimu.inventorymanage.R;
import com.aimu.inventorymanage.activity.base.BaseActivity;

import butterknife.BindView;

public class SplashActivity extends BaseActivity implements Animation.AnimationListener {

    @BindView(R.id.ll_splash)
    LinearLayout llSplash;

    @Override
    protected void setActTitle() {

    }

    @Override
    protected void setRootView() {
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void initView() {
        initAnimation();
    }

    /**
     * 初始化动画
     */
    private void initAnimation() {
        AlphaAnimation animation = new AlphaAnimation(0.3f, 1.0f);// 透明度动画
        animation.setDuration(0000);
        animation.setAnimationListener(this);
        llSplash.startAnimation(animation);
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        jumpActivity(LoginActivity.class);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }
}
