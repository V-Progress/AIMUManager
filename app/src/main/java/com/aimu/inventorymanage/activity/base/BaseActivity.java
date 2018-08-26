package com.aimu.inventorymanage.activity.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.aimu.inventorymanage.Const.Const;
import com.aimu.inventorymanage.R;
import com.aimu.inventorymanage.activity.MainActivity;
import com.aimu.inventorymanage.db.DBCallback;
import com.aimu.inventorymanage.db.DBController;
import com.aimu.inventorymanage.view.TitleBar;

import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;

public abstract class BaseActivity extends Activity implements DBCallback{

    protected DBController mDBController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        App.getInstance().addActivity(this);
        Bmob.initialize(this,Const.BMOB_APPID);
        setRootView();
        initDBController();
        setActTitle();
        ButterKnife.bind(this);
        initView();
    }

    protected abstract void setActTitle();

    protected abstract void setRootView();

    protected abstract void initView();

    private void initDBController(){
        mDBController = new DBController(this,this);
    }


    /**---------------------------------- 以下是关于标题栏的设置 ----------------------------------*/
    /**
     * 返回
     */
    protected void back() {
        finish();
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
    }

    /**
     * 无回退的titleBar
     *
     * @param strId
     */
    protected void setTitleBar(int strId) {
        setTitleBar("", 0, null, getResources().getString(strId), null, null, R.color.title_text, R.color.title_bg);
    }
    /**
     * 回退的titleBar
     * @param strId
     */
    protected void setBackTitleBar(int strId) {
        setBackTitleBar(getResources().getString(strId), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
    }

    /**
     * 回退的titleBar
     * @param title
     * @param listener
     */
    public void setBackTitleBar(String title, View.OnClickListener listener) {
        setTitleBar(null, R.drawable.title_back_selector, listener, title,
                null, null, R.color.title_text, R.color.title_bg);
    }

    /**
     * 初始化标题栏
     *
     * @param lText       左边的文字
     * @param lImgId      左边的图片
     * @param rListener   点击左边的事件监听
     * @param titleText   中间的文字
     * @param imageAction 右边图片相关类，初始化时需要设置图片和点击图片后的行为
     * @param textAction  右边文字相关类，初始化时需要设置文字和点击文字后的行为
     * @param textColorId 文字的颜色
     * @param bgColorId   背景颜色
     */
    protected void setTitleBar(String lText, int lImgId, View.OnClickListener rListener, String titleText,
                               TitleBar.ImageAction imageAction, TitleBar.TextAction textAction, int textColorId, int bgColorId) {
        final TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);
        if (titleBar == null) {
            return;
        }
        titleBar.setImmersive(false);  // 会加上状态栏的高度，不要去掉注释；
        titleBar.setBackgroundColor(getResources().getColor(bgColorId));
        if (lImgId != 0) {
            titleBar.setLeftImageResource(lImgId);
        }
        titleBar.setLeftText(lText);
        titleBar.setLeftTextColor(getResources().getColor(textColorId));
        if (rListener != null) {
            titleBar.setLeftClickListener(rListener);
        }
        titleBar.setTitle(titleText);
        titleBar.setTitleColor(getResources().getColor(textColorId));
        titleBar.setSubTitleColor(getResources().getColor(textColorId));

        // 分割线颜色
        titleBar.setDividerColor(getResources().getColor(bgColorId));

        titleBar.setActionTextColor(getResources().getColor(R.color.title_text));
        if (imageAction != null) {
            titleBar.addAction(imageAction);
        }
        if (textAction != null) {
            titleBar.addAction(textAction);
        }
    }
    /**---------------------------------- 以上是关于标题栏的设置 ----------------------------------*/

    /**---------------------------------- 以下是关于沉浸式状态栏的设计 -----------------------------*/
    @TargetApi(19)
    protected void initStateBar(int color) {
        if (isFullScreen(this)) {
            return;
        }
        //或者这里开始直接在activity中使用。
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        // 创建状态栏的管理实例
//        SystemBarTintManager tintManager = new SystemBarTintManager(this);
//        // 激活状态栏设置
//        tintManager.setStatusBarTintEnabled(true);
//        // 激活导航栏设置
//        tintManager.setStatusBarTintResource(color);
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();

        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
    /**
     * @param activity
     * @return 判断当前Activity是否是全屏
     */
    public static boolean isFullScreen(Activity activity) {
        int flag = activity.getWindow().getAttributes().flags;
        if((flag & WindowManager.LayoutParams.FLAG_FULLSCREEN)
                == WindowManager.LayoutParams.FLAG_FULLSCREEN) {
            return true;
        }else {
            return false;
        }
    }

    /**---------------------------------- 以上是关于沉浸式状态栏的设计 -----------------------------*/
    /**
     * 跳转Activity-无参、无返回数据
     * @param act
     */
    protected void jumpActivity(Class act) {
//        dismissProgressDialog();
//        DialogUtil.dissmissDialog();
        jumpActivity(act, null);
    }

    /**
     * 跳转Activity-传参、无返回数据
     * @param act
     * @param bundle
     */
    protected void jumpActivity(Class act, Bundle bundle) {
        jumpActivityForResult(act, bundle, -1, true);
    }

    /**
     * 跳转Activity-传参、返回数据、是否销毁
     * @param act
     * @param bundle
     * @param code
     * @param isFinish 是否销毁
     */
    protected void jumpActivityForResult(Class act, Bundle bundle, int code, boolean isFinish) {
        Intent intent = new Intent();
        intent.setClass(this, act);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (code > 0) {
            startActivityForResult(intent, code);
            overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
        } else {
            startActivity(intent);
            overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
        }
        // 主页面跳转不销毁
        if (isFinish && !(this instanceof MainActivity)) {
            finish();
        }
    }

    @Override
    public void onDBStart() {

    }

    @Override
    public void onDBGetData() {

    }

    @Override
    public void onDBFinish() {

    }

    @Override
    public void onDBError() {

    }

}
