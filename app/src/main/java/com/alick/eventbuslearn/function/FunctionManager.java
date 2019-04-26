package com.alick.eventbuslearn.function;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 崔兴旺
 * @package com.alick.eventbuslearn
 * @title:
 * @description:
 * @date 2019/4/27 4:42
 */
public class FunctionManager {
    private static final String TAG = "FunctionManager";
    private static FunctionManager instance = null;

    private Map<String, FunctionNoResultNoParam> functionNoResultNoParamMap;
    private Map<String, FunctionHasResultNoParam> functionHasResultNoParamMap;
    private Map<String, FunctionNoResultHasParam> functionNoResultHasParamMap;
    private Map<String, FunctionHasResultHasParam> functionHasResultHasParamMap;

    private FunctionManager() {
        functionNoResultNoParamMap = new HashMap<>();
        functionHasResultNoParamMap = new HashMap<>();
        functionNoResultHasParamMap = new HashMap<>();
        functionHasResultHasParamMap = new HashMap<>();
    }

    public static FunctionManager getInstance() {
        synchronized (FunctionManager.class) {
            if (instance == null) {
                instance = new FunctionManager();
            }
        }
        return instance;
    }


    public void registFunction(FunctionNoResultNoParam function) {
        functionNoResultNoParamMap.put(function.getFunctionName(), function);
    }

    public <Result> void registFunction(FunctionHasResultNoParam<Result> function) {
        functionHasResultNoParamMap.put(function.getFunctionName(), function);
    }

    public <Param> void registFunction(FunctionNoResultHasParam<Param> function) {
        functionNoResultHasParamMap.put(function.getFunctionName(), function);
    }

    public <Result, Param> void registFunction(FunctionHasResultHasParam<Result, Param> function) {
        functionHasResultHasParamMap.put(function.getFunctionName(), function);
    }


    public void invokeFunctionNoResultNoParam(String functionName) {
        FunctionNoResultNoParam function = functionNoResultNoParamMap.get(functionName);
        if (function != null) {
            function.execute();
        } else {
            Log.i(TAG, "没找到方法:" + functionName);
        }
    }

    public <Result> Result invokeFunctionHasResultNo(String functionName) {
        FunctionHasResultNoParam<Result> function = functionHasResultNoParamMap.get(functionName);
        if (function != null) {
            return function.execute();
        } else {
            Log.i(TAG, "没找到方法:" + functionName);
            return null;
        }
    }

    public <Param> void invokeFunctionNoResultHasParam(String functionName, Param param) {
        FunctionNoResultHasParam<Param> function = functionNoResultHasParamMap.get(functionName);
        if (function != null) {
            function.execute(param);
        } else {
            Log.i(TAG, "没找到方法:" + functionName);
        }
    }

    public <Result, Param> Result invokeFunctionHasResultHasParam(String functionName, Param param) {
        FunctionHasResultHasParam<Result, Param> function = functionHasResultHasParamMap.get(functionName);
        if (function != null) {
            return function.execute(param);
        } else {
            Log.i(TAG, "没找到方法:" + functionName);
            return null;
        }
    }


}
