package com.aimu.inventorymanage.db;

/**
 * Created by JaneV on 2018/8/26.
 */

public interface DBCallback {
    void onDBStart();
    void onDBGetData();
    void onDBFinish();
    void onDBError();
}
