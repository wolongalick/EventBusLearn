package com.alick.eventbuslearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alick.eventbuslearn.function.FunctionManager;
import com.alick.eventbuslearn.utils.ToastUtil;

public class Test1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
    }

    public void invokeFun1(View view) {
        FunctionManager.getInstance().invokeFunctionNoResultNoParam(Constant.fun1);
    }

    public void invokeFun2(View view) {
        String result = FunctionManager.getInstance().invokeFunctionHasResultNo(Constant.fun2);
        ToastUtil.show(Constant.fun2+"返回值:"+result);
    }

    public void invokeFun3(View view) {
        FunctionManager.getInstance().invokeFunctionNoResultHasParam(Constant.fun3,"我是"+Constant.fun3+"的参数");
    }

    public void invokeFun4(View view) {
        String result = FunctionManager.getInstance().invokeFunctionHasResultHasParam(Constant.fun4, "我是" + Constant.fun4 + "的参数");
        ToastUtil.show(Constant.fun4+"返回值:"+result);

    }
}