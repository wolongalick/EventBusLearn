package com.alick.eventbuslearn.function;

/**
 * @author 崔兴旺
 * @package com.alick.eventbuslearn
 * @title:
 * @description:
 * @date 2019/4/27 4:39
 */
public class Function {
    private String functionName;

    public Function(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
}
