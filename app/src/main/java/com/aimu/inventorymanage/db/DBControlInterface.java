package com.aimu.inventorymanage.db;

public interface DBControlInterface {

    /***
     * 注册
     * @return 注册情况
     */
    boolean signUp();

    /***
     * 登陆
     * @return
     */
    boolean singIn();

    /**
     * 修改用户信息
     * @return
     */
    boolean modifyUser();

    /**
     * 库存录入
     * @return
     */
    boolean inventoryEntry();

    /***
     * 销库存
     */
    boolean sellStock();

    /***
     * 修改库存
     * @return
     */
    boolean modifyInventory();
}
