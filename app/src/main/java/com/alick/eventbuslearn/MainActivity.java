package com.alick.eventbuslearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alick.eventbuslearn.function.FunctionHasResultHasParam;
import com.alick.eventbuslearn.function.FunctionHasResultNoParam;
import com.alick.eventbuslearn.function.FunctionManager;
import com.alick.eventbuslearn.function.FunctionNoResultHasParam;
import com.alick.eventbuslearn.function.FunctionNoResultNoParam;
import com.alick.eventbuslearn.utils.ToastUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FunctionManager.getInstance().registFunction(new FunctionNoResultNoParam(Constant.fun1) {
            @Override
            public void execute() {
                ToastUtil.show(Constant.fun1 + "被调用");
            }
        });

        FunctionManager.getInstance().registFunction(new FunctionHasResultNoParam<String>(Constant.fun2) {
            @Override
            public String execute() {
                ToastUtil.show(Constant.fun2 + "被调用");
                return "我是" + Constant.fun2 + "函数返回信息";
            }
        });

        FunctionManager.getInstance().registFunction(new FunctionNoResultHasParam<String>(Constant.fun3) {
            @Override
            public void execute(String param) {
                ToastUtil.show(Constant.fun3 + "被调用,参数:"+param);
            }
        });

        FunctionManager.getInstance().registFunction(new FunctionHasResultHasParam<String, String>(Constant.fun4) {
            @Override
            public String execute(String param) {
                ToastUtil.show(Constant.fun4 + "被调用,参数:"+param);
                return "我是" + Constant.fun4 + "函数返回信息,参数:"+param;
            }
        });



    }

    public void goTest1(View view) {
        startActivity(new Intent(this, Test1Activity.class));
    }
}
