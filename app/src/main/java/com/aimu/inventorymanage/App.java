package com.aimu.inventorymanage;

import android.app.Application;

import com.aimu.inventorymanage.Const.Const;

import cn.bmob.v3.Bmob;

/**
 * Created by JaneV on 2018/8/26.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        init();
    }

    private void init() {
        Bmob.initialize(this, Const.BMOB_APPID);
    }
}
