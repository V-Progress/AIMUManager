package com.aimu.inventorymanage.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by JaneV on 2018/8/26.
 */

public class User extends BmobObject {

    private String user_phoneNum;
    private String user_password;
    private String user_jurisdiction;
    private String sign_time;
    private String id_number;

    public String getUser_phoneNum() {
        return user_phoneNum;
    }

    public void setUser_phoneNum(String user_phoneNum) {
        this.user_phoneNum = user_phoneNum;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_jurisdiction() {
        return user_jurisdiction;
    }

    public void setUser_jurisdiction(String user_jurisdiction) {
        this.user_jurisdiction = user_jurisdiction;
    }

    public String getSign_time() {
        return sign_time;
    }

    public void setSign_time(String sign_time) {
        this.sign_time = sign_time;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_phoneNum='" + user_phoneNum + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_jurisdiction='" + user_jurisdiction + '\'' +
                ", sign_time='" + sign_time + '\'' +
                ", id_number='" + id_number + '\'' +
                '}';
    }
}
