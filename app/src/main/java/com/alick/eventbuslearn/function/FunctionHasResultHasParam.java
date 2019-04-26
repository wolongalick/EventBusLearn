package com.alick.eventbuslearn.function;

/**
 * @author 崔兴旺
 * @package com.alick.eventbuslearn
 * @title:
 * @description:
 * @date 2019/4/27 4:53
 */
public abstract class FunctionHasResultHasParam<Result, Param> extends Function {
    public FunctionHasResultHasParam(String functionName) {
        super(functionName);
    }

    public abstract Result execute(Param param);
}
