package com.aimu.inventorymanage.db;

import android.content.Context;
import android.os.AsyncTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.bmob.v3.BmobQuery;

public class DBController implements DBControlInterface {

    /**
     * 创建一个单线程的线程池
     */
    private static final ExecutorService SINGLE_TASK_EXECUTOR = (ExecutorService) Executors.newSingleThreadExecutor();
    /**
     * android上下文对象
     */
    private Context mContext;
    /**
     * apdu执行器监听器
     */
    private DBCallback callback;
    BmobQuery bmobQuery;
    private RunApduTask mRunApduTask;

    public DBController(Context mContext, DBCallback callback) {

        if(mContext == null){
            throw new IllegalArgumentException("context can not null");
        }

        if(callback == null){
            throw new IllegalArgumentException("callback can not null");
        }
        this.mContext = mContext;
        this.callback = callback;
    }

    private class RunApduTask extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... params) {
            bmobQuery = new BmobQuery();

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

    public void run(){
        if (mRunApduTask != null && !mRunApduTask.isCancelled()) {
            mRunApduTask.cancel(true);
        }
//        mRunApduTask = new RunApduTask();
//        mRunApduTask.executeOnExecutor(SINGLE_TASK_EXECUTOR, req);
    }


    @Override
    public boolean signUp() {
        return false;
    }

    @Override
    public boolean singIn() {
        return false;
    }

    @Override
    public boolean modifyUser() {
        return false;
    }

    @Override
    public boolean inventoryEntry() {
        return false;
    }

    @Override
    public boolean sellStock() {
        return false;
    }

    @Override
    public boolean modifyInventory() {
        return false;
    }
}
