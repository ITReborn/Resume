package com.itheima.resume;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.itheima.resume.activity.BaseActivity;
import com.itheima.resume.fragment.FragmentFactory;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements OnTabSelectListener {

    @Bind(R.id.bottomBar)
    BottomBar mBottomBar;
    private FragmentManager mManager;

    @Override
    public int getView() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        super.init();

       /* ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Resume");*/
        mManager = getSupportFragmentManager();

        mBottomBar.setOnTabSelectListener(this);
        mBottomBar.setDefaultTab(R.id.my);

    }


    @Override
    public void onTabSelected(@IdRes int tabId) {
        FragmentTransaction transaction = mManager.beginTransaction();
        FragmentTransaction replace = transaction.replace(R.id.contentContainer, FragmentFactory.getFragmentFactory().getFragment(tabId));
        replace.commit();
    }
}
