package com.alick.eventbus_lib;

import java.lang.reflect.Method;

/**
 * @author 崔兴旺
 * @package com.alick.eventbus_lib
 * @title:
 * @description:
 * @date 2019/4/28 16:30
 */
public class SubscriberMethod {
    private Method method;
    private ThreadMode threadMode;
    private Class<?> eventType;

    public SubscriberMethod(Method method, ThreadMode threadMode, Class<?> eventType) {
        this.method = method;
        this.threadMode = threadMode;
        this.eventType = eventType;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public ThreadMode getThreadMode() {
        return threadMode;
    }

    public void setThreadMode(ThreadMode threadMode) {
        this.threadMode = threadMode;
    }

    public Class<?> getEventType() {
        return eventType;
    }

    public void setEventType(Class<?> eventType) {
        this.eventType = eventType;
    }
}
