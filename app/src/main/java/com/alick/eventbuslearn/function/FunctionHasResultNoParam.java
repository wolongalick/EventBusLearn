package com.alick.eventbuslearn.function;

/**
 * @author 崔兴旺
 * @package com.alick.eventbuslearn
 * @title:
 * @description:
 * @date 2019/4/27 4:53
 */
public abstract class FunctionHasResultNoParam<Result> extends Function {
    public FunctionHasResultNoParam(String functionName) {
        super(functionName);
    }

    public abstract Result execute();
}
