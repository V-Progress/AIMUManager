package com.aimu.inventorymanage.db;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.aimu.inventorymanage.Const.Const;
import com.aimu.inventorymanage.activity.LoginActivity;
import com.aimu.inventorymanage.activity.MainActivity;
import com.aimu.inventorymanage.model.User;
import com.aimu.inventorymanage.utils.ToastUtil;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

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
//    private RunApduTask mRunApduTask;

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

//    private class RunApduTask<T> extends AsyncTask<BmobObject,Void,User> {
//
//        @Override
//        protected User doInBackground(BmobObject... params) {
//            BmobQuery<T> bmobQuery = new BmobQuery();
//            bmobQuery.addWhereEqualTo(Const.DB_KEY.KEY_DB_WHERE,params[0]);
//
//            bmobQuery.findObjects(new FindListener<T>() {
//                @Override
//                public void done(List<T> list, BmobException e) {
//                    if(list == null || list.size()<=0){
//                        callback.onDBError();
//                    }else{
//                        callback.onDBGetData();
//                    }
//                    callback.onDBFinish();
//                }
////                @Override
////                public void done(List<User> list, BmobException e) {
////                    if(list == null || list.size()<=0){
////                        callback.onDBError();
////                    }else{
////                        callback.onDBGetData();
////                    }
////                    callback.onDBFinish();
////                }
//            });
//
//            return null;
//        }
//    }
//
//    public void runDB(BmobObject req) {
//        if (mRunApduTask != null && !mRunApduTask.isCancelled()) {
//            mRunApduTask.cancel(true);
//        }
//        RunApduTask<BmobObject> mRunApduTask = new RunApduTask<>();
//        mRunApduTask.executeOnExecutor(SINGLE_TASK_EXECUTOR, req);
//    }

    @Override
    public boolean signUp() {

        return false;
    }

    @Override
    public void singIn(final String phoneNum, final String password) {
        callback.onDBStart();
        new  AsyncTask<String,Void,Void>(){
            @Override
            protected Void doInBackground(String... params) {
                BmobQuery<User> bmobQuery = new BmobQuery<>();
                bmobQuery.addWhereEqualTo(Const.DB_KEY.KEY_DB_WHERE,phoneNum);
                bmobQuery.findObjects(new FindListener<User>() {
                    @Override
                    public void done(List<User> list, BmobException e) {
                        if(e != null){
                            callback.onDBError(e);
                        }
                        if(list == null || list.size()<=0){
                            callback.onDBError(new Exception("未查到数据"));
                            callback.onDBFinish();
                            return;
                        }

                        callback.onDBGetData(list,TextUtils.equals(password,list.get(0).getUser_password()));
                        callback.onDBFinish();
                    }
                });
                return null;
            }
        }.executeOnExecutor(SINGLE_TASK_EXECUTOR);
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
