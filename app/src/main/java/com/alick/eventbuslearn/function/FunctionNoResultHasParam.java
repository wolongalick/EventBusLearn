package com.alick.eventbuslearn.function;

/**
 * @author 崔兴旺
 * @package com.alick.eventbuslearn
 * @title:
 * @description:
 * @date 2019/4/27 4:53
 */
public abstract class FunctionNoResultHasParam<Param> extends Function {
    public FunctionNoResultHasParam(String functionName) {
        super(functionName);
    }

    public abstract void execute(Param param);
}
