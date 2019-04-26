package com.alick.eventbuslearn.utils;

import android.widget.Toast;

import com.alick.eventbuslearn.base.BaseApplication;

/**
 * @author 崔兴旺
 * @package com.alick.eventbuslearn.utils
 * @title:
 * @description:
 * @date 2019/4/27 4:58
 */
public class ToastUtil {
    public static void show(String msg) {
        Toast.makeText(BaseApplication.getApp(), msg, Toast.LENGTH_SHORT).show();
    }
}
