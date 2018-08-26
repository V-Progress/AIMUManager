package com.aimu.inventorymanage.utils;

import android.util.Log;

import com.aimu.inventorymanage.Const.Const;


/**
 * 日志工具类
 * @author 李超
 * @datetime 2017/5/16 22:14
 */
public class LogUtil {

    public static void d(String message) {
        if (Const.Config.IS_LOG) {
            Log.d(Const.LogTag.TAG_DEFAULT, getLogHead() + message);
        }
    }

    public static void d(String tag, String message) {
        if (Const.Config.IS_LOG) {
            Log.d(tag, getLogHead() + message);
        }
    }

    public static void i(String message) {
        if (Const.Config.IS_LOG) {
            Log.i(Const.LogTag.TAG_DEFAULT, getLogHead() + message);
        }
    }

    public static void i(String tag, String message) {
        if (Const.Config.IS_LOG) {
            Log.i(tag, getLogHead() + message);
        }
    }

    public static void e(String message) {
        if (Const.Config.IS_LOG) {
            Log.e(Const.LogTag.TAG_DEFAULT, getLogHead() + message);
        }
    }

    public static void e(String tag, String message) {
        if (Const.Config.IS_LOG) {
            Log.e(tag, getLogHead() + message);
        }
    }

    private static String getLogHead() {
        String[] infos = new String[] { "", "", "" };
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        if (elements.length < 5) {
            LogUtil.e(Const.LogTag.TAG_DEFAULT, "Stack is too shallow!!!");
            return "";
        } else {
            // 长类名
            String className = elements[4].getClassName();
            // 短类名
            infos[0] = className.substring(className.lastIndexOf(".") + 1);
            // 方法名
            infos[1] = elements[4].getMethodName() + "()";
            // 行号
            infos[2] = String.valueOf(elements[4].getLineNumber());
            return infos[0] + "(" + infos[2] + ") ";
        }
    }

}
