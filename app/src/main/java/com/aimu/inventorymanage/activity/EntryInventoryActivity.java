package com.aimu.inventorymanage.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aimu.inventorymanage.R;
import com.aimu.inventorymanage.activity.base.BaseActivity;

public class EntryInventoryActivity extends BaseActivity {

    @Override
    protected void setActTitle() {
        setTitleBar(R.string.inven_lentry_title);
    }

    @Override
    protected void setRootView() {
        setContentView(R.layout.activity_entry_inventory);
    }

    @Override
    protected void initView() {
        //打开扫描界面扫描条形码或二维码
    }
}
