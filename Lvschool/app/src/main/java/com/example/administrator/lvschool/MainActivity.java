package com.example.administrator.lvschool;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2017/2/7.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,"ba12afc2cc3c6e959aa2f5f8efc8dd7e");
        setContentView(R.layout.activity_main);
        //初始化
        Toolbar toolbar = (Toolbar)findViewById()
    }
}
