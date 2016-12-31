package com.itheima.resume.fragment;

import android.support.v4.app.Fragment;

import com.itheima.resume.R;


/*
 *  @项目名：  MVPlayer 
 *  @包名：    com.itheima.mvplayer.factory
 *  @文件名:   FragmentFactory
 *  @创建者:   Administrator
 *  @创建时间:  2016/12/19 21:17
 *  @描述：    TODO
 */
public class FragmentFactory {
    private static final String TAG = "FragmentFactory";

    public static FragmentFactory sFragmentFactory;
    private Fragment mHomeFragment;
    private Fragment mProjectFragment;
    private Fragment mMyFragment;


    private FragmentFactory(){}

    public static FragmentFactory getFragmentFactory(){
        if (sFragmentFactory==null){
            sFragmentFactory=new FragmentFactory();
        }
        return sFragmentFactory;
    }

    public Fragment getFragment(int tabId) {
        switch (tabId) {
            case R.id.tab_home:
                return getHomeFragment();
            case R.id.project:
                return getProjectFragment();
            case R.id.my:
                return getMyFragment();

        }
        return null;
    }

    public Fragment getHomeFragment() {
        if (mHomeFragment==null){
            mHomeFragment=new HomeFragment();
        }
        return mHomeFragment;
    }

    public Fragment getProjectFragment() {
        if (mProjectFragment==null){
            mProjectFragment=new ProjectFragment();
        }
        return mProjectFragment;
    }

    public Fragment getMyFragment() {
        if (mMyFragment==null){
            mMyFragment=new MyFragment();
        }
        return mMyFragment;
    }
}
