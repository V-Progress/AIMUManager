package com.aimu.inventorymanage.utils;

import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 李超
 * @DateTime 2017/8/29
 * @Version V1.0.0
 * @Description:
 */

public class DateTimeUtil {

    /**
     * 得到14位日期时间字符串
     * @return
     */
    public static String dateTime(){
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date());
    }

    /**
     * 得到8位日期字符串
     *
     * @return
     */
    public static String date8() {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(new Date());
    }

    /**
     * 得到6位时间字符串
     *
     * @return
     */
    public static String time6 (){
        DateFormat df = new SimpleDateFormat("HHmmss");
        return df.format(new Date());
    }

    public static String formatTime(String srcTime){
        if (TextUtils.isEmpty(srcTime)) {
            return "";
        }
        try {
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            DateFormat parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = df.parse(srcTime);
            return parse.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 得到下拉刷新用的时间格式
     * @return
     */
    public static String getRefreshTime(){
        SimpleDateFormat mDateFormat = new SimpleDateFormat("MM-dd HH:mm");

        return mDateFormat.format(new Date(System.currentTimeMillis()));
    }

    /**
     * 当前年
     * @return
     */
    public static String nowYear() {
        return date8().substring(0, 4);
    }

    /**
     * 当前月
     * @return
     */
    public static String nowMonth() {
        return date8().substring(4, 6);
    }

}
