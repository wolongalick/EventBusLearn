package com.alick.eventbuslearn.base;

import android.app.Application;

/**
 * @author 崔兴旺
 * @package com.alick.eventbuslearn.base
 * @title:
 * @description:
 * @date 2019/4/27 4:57
 */
public class BaseApplication extends Application {
    private static BaseApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }

    public static BaseApplication getApp() {
        return app;
    }
}
