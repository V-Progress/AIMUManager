package com.aimu.inventorymanage.activity;

import com.aimu.inventorymanage.R;
import com.aimu.inventorymanage.activity.base.BaseActivity;
import com.aimu.inventorymanage.model.User;
import com.aimu.inventorymanage.utils.LogUtil;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class MainActivity extends BaseActivity {

    @Override
    protected void setActTitle() {

    }

    @Override
    protected void setRootView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        BmobQuery<User> bmobQuery = new BmobQuery<>();

        bmobQuery.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                LogUtil.e(list ==null?e.getMessage():list.toString());
            }
        });
    }
}
