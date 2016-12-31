package com.itheima.resume.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/*
 *  @项目名：  Resume 
 *  @包名：    com.itheima.resume.activity
 *  @文件名:   BaseActivity
 *  @创建者:   Administrator
 *  @创建时间:  2016/12/25 19:36
 *  @描述：    TODO
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        ButterKnife.bind(this);
        init();
    }

    public void init() {

    }

    public void goTo(Class clazz){
        goTo(clazz,false);
    }
    public void goTo(Class clazz,boolean finish){
        startActivity(new Intent(this, clazz));
        if (finish) {
            finish();
        }
    }

    public abstract int getView();
}
