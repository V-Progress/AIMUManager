package com.aimu.inventorymanage.db;

import java.util.List;

/**
 * Created by JaneV on 2018/8/26.
 */

public interface DBCallback {
    void onDBStart();
    void onDBGetData(List list,boolean b);
    void onDBFinish();
    void onDBError(Exception e);
}
