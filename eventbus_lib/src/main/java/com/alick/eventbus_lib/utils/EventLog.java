package com.alick.eventbus_lib.utils;

import android.util.Log;

/**
 * @author 崔兴旺
 * @package com.alick.eventbus_lib.utils
 * @title:
 * @description:
 * @date 2019/4/28 13:59
 */
public class EventLog {
    private static final String TAG = "EventLog";
    private static boolean DEBUG = true;

    public static void i(String msg) {
        if (DEBUG) {
            Log.i(TAG, msg);
        }
    }

    public static void e(String msg) {
        if (DEBUG) {
            Log.e(TAG, msg);
        }
    }

    public static void w(String msg) {
        if (DEBUG) {
            Log.w(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (DEBUG) {
            Log.d(TAG, msg);
        }
    }


}
