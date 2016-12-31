package com.itheima.resume.activity;

import android.support.v7.app.ActionBar;

import com.itheima.resume.R;

/*
 *  @项目名：  Resume 
 *  @包名：    com.itheima.resume.activity
 *  @文件名:   MyAboutActivity
 *  @创建者:   Administrator
 *  @创建时间:  2016/12/26 20:42
 *  @描述：    TODO
 */
public class MyAboutActivity extends BaseActivity {
    private static final String TAG = "MyAboutActivity";

    @Override
    public int getView() {
        return R.layout.activity_about_my;
    }

    @Override
    public void init() {
        super.init();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("关于我的");
    }
}
