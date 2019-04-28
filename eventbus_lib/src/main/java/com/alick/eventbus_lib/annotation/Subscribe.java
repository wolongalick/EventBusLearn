package com.alick.eventbus_lib.annotation;

import com.alick.eventbus_lib.ThreadMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 崔兴旺
 * @package com.alick.eventbus_lib.annotation
 * @title:
 * @description:
 * @date 2019/4/28 10:09
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface Subscribe {

    ThreadMode threadMode() default ThreadMode.MainThread;





}
