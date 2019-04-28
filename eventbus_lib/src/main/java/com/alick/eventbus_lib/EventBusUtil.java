package com.alick.eventbus_lib;

import android.util.Log;

import com.alick.eventbus_lib.annotation.Subscribe;
import com.alick.eventbus_lib.utils.EventLog;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 崔兴旺
 * @package com.alick.eventbus_lib
 * @title:
 * @description:
 * @date 2019/4/28 10:12
 */
public class EventBusUtil {
    private static final String TAG = "EventBusUtil";
    private static EventBusUtil instance = null;

    private Map<Class<?>, List<Subscription>> subscriptionMap;

    private EventBusUtil() {
        subscriptionMap = new HashMap<>();
    }

    public static EventBusUtil getInstance() {
        if (instance == null) {
            synchronized (EventBusUtil.class) {
                if (instance == null) {
                    instance = new EventBusUtil();
                }
            }
        }
        return instance;
    }

    public void register(Object subscriber) {
        Class<?> aClass = subscriber.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            String methodName = method.getName();
            Log.i(TAG, "方法名:" + methodName);

            Subscribe annotation = method.getAnnotation(Subscribe.class);
            if (annotation != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    Class<?> parameterType = parameterTypes[0];
                    List<Subscription> subscriptions = subscriptionMap.get(parameterType);
                    if (subscriptions == null) {
                        subscriptions = new ArrayList<>();
                        SubscriberMethod subscriberMethod=new SubscriberMethod(method,annotation.threadMode(),parameterType);

                        subscriptions.add(new Subscription(subscriber, subscriberMethod));
                        subscriptionMap.put(parameterType, subscriptions);
                    }else {
//                      subscriptions.contains();
                    }

                } else {
                    throw new EventBusException("参数个数必须是1个");
                }
                EventLog.i(annotation.toString());
                EventLog.i("线程模式:" + annotation.threadMode().name());
            } else {
                EventLog.e("注解为null");
            }
        }
    }


    public void printAllSubscriptions() {
        EventLog.i("=================全部订阅事件-begin=================");
        Set<Map.Entry<Class<?>, List<Subscription>>> entries = subscriptionMap.entrySet();
        Iterator<Map.Entry<Class<?>, List<Subscription>>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Class<?>, List<Subscription>> next = iterator.next();
            Class<?> name = next.getKey();
            List<Subscription> subscriptions = next.getValue();

            EventLog.i("事件类型:"+name);
            EventLog.i("订阅者个数:"+(subscriptions!=null ? subscriptions.size() : 0));
            if(subscriptions!=null){
                for (Subscription subscription:subscriptions) {
                    Object targetObject = subscription.getSubscriber();
                    SubscriberMethod subscriberMethod = subscription.getSubscriberMethod();
                    EventLog.i("所在类:"+targetObject+",方法:"+subscriberMethod.getMethod().toGenericString());
                }
            }
            EventLog.i("------------------");
        }

        EventLog.i("=================全部订阅事件-end=================");
    }


    public void post(Object object) {
        List<Subscription> subscriptions = subscriptionMap.get(object.getClass().getName());
        if(subscriptions!=null){
            for (Subscription subscription:subscriptions) {
                Object targetObject = subscription.getSubscriber();
                SubscriberMethod subscriberMethod = subscription.getSubscriberMethod();
                try {
                    Object invoke =  subscriberMethod.getMethod().invoke(targetObject, object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }


}
