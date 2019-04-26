package com.alick.eventbuslearn.function;

/**
 * @author 崔兴旺
 * @package com.alick.eventbuslearn
 * @title:
 * @description:
 * @date 2019/4/27 4:40
 */
public abstract class FunctionNoResultNoParam extends Function{
    public FunctionNoResultNoParam(String functionName) {
        super(functionName);
    }

    public abstract void execute();

}
