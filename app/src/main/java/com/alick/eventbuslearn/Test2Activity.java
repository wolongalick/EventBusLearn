package com.alick.eventbuslearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alick.eventbus_lib.EventBusUtil;
import com.alick.eventbuslearn.bean.User;

public class Test2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
    }

    public void sendEventBus(View view) {
        EventBusUtil.getInstance().post(new User("崔兴旺",28));
    }


}
