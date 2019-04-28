package com.alick.eventbus_lib;

/**
 * @author 崔兴旺
 * @package com.alick.eventbus_lib
 * @title:
 * @description:
 * @date 2019/4/28 10:26
 */
public class Subscription {
    private Object subscriber;
    private SubscriberMethod subscriberMethod;

    public Subscription(Object subscriber, SubscriberMethod subscriberMethod) {
        this.subscriber = subscriber;
        this.subscriberMethod = subscriberMethod;
    }

    public Object getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Object subscriber) {
        this.subscriber = subscriber;
    }

    public SubscriberMethod getSubscriberMethod() {
        return subscriberMethod;
    }

    public void setSubscriberMethod(SubscriberMethod subscriberMethod) {
        this.subscriberMethod = subscriberMethod;
    }


}
