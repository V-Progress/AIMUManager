package com.aimu.inventorymanage.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aimu.inventorymanage.R;


/**
 * Toast工具类
 *
 * @author 李超
 * @datetime 2017/5/21 0:39
 */
public class ToastUtil {

    private static Toast mToast;

    /**
     * 弹出一个6s显示的toast框
     */
    public static void showLong(Context context, String msg) {
        showToastLong(context, msg, false);
    }

    /**
     * 弹出一个3s显示的toast框
     */
    public static void showShort(Context context, String msg) {
        showToastLong(context, msg, true);
    }

    /**
     * @描述: 显示自定义Toast
     * @时间：16/7/14 下午5:17
     * @作者: 白辰曦
     */
    private static void showToastLong(Context context, String msg, boolean isShort) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.layout_toast, null);
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(msg);

        if (mToast == null) {
            mToast = new Toast(context);
        }
        // 设置Toast的位置
//        mToast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, xOffset, yOffset);

        if (isShort) {
            //设置显示时间
            mToast.setDuration(Toast.LENGTH_SHORT);
        } else {
            mToast.setDuration(Toast.LENGTH_LONG);
        }

        // 将自定义的界面设置到Toast里
        mToast.setView(layout);
        mToast.show();
    }

}
