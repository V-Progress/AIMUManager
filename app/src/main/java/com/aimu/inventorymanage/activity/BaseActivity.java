package com.aimu.inventorymanage.activity;

import android.app.Activity;
import android.os.Bundle;

import com.aimu.inventorymanage.Const.Const;

import cn.bmob.v3.Bmob;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Bmob.initialize(this,Const.BMOB_APPID);
        setView();
        initView();
    }

    protected abstract void setView();

    protected abstract void initView();

}
