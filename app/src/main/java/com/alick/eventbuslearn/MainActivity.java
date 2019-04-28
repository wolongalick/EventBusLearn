package com.alick.eventbuslearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alick.eventbus_lib.EventBusUtil;
import com.alick.eventbus_lib.ThreadMode;
import com.alick.eventbus_lib.annotation.Subscribe;
import com.alick.eventbuslearn.bean.User;
import com.alick.eventbuslearn.function.FunctionHasResultHasParam;
import com.alick.eventbuslearn.function.FunctionHasResultNoParam;
import com.alick.eventbuslearn.function.FunctionManager;
import com.alick.eventbuslearn.function.FunctionNoResultHasParam;
import com.alick.eventbuslearn.function.FunctionNoResultNoParam;
import com.alick.eventbuslearn.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;

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

        EventBusUtil.getInstance().register(this);
        EventBusUtil.getInstance().printAllSubscriptions();

        EventBus.getDefault().register(this);
    }

    public void goTest1(View view) {
        startActivity(new Intent(this, Test1Activity.class));
    }


    @Subscribe(threadMode = ThreadMode.MainThread)
    public void eventFun1(User user){
        ToastUtil.show(user.toString());
    }

    @org.greenrobot.eventbus.Subscribe()
    public void eventFun2(User user){
        ToastUtil.show(user.toString());
    }

    private void fun1(){

    }

    protected void fun2(){

    }

    void fun3(){

    }

    public void goTest2(View view) {
        startActivity(new Intent(this, Test2Activity.class));
    }
}
