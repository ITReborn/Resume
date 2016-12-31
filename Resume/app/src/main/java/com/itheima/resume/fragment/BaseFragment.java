package com.itheima.resume.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.resume.R;

import butterknife.ButterKnife;

/*
 *  @项目名：  MVPlayer 
 *  @包名：    com.itheima.mvplayer.fragment
 *  @文件名:   BaseFragment
 *  @创建者:   Administrator
 *  @创建时间:  2016/12/19 21:31
 *  @描述：    TODO
 */
public abstract class BaseFragment extends Fragment {
    private static final String TAG = "BaseFragment";

   public int[] icon={R.mipmap.a1,R.mipmap.a2,R.mipmap.a3,R.mipmap.a4,R.mipmap.a5,R.mipmap.a6,R.mipmap.a7,R.mipmap.a8,R.mipmap.a9,R.mipmap.a10,R.mipmap.a11,R.mipmap.a12,R.mipmap.a13,R.mipmap.a14,R.mipmap.a15,
            R.mipmap.a16,R.mipmap.a17,R.mipmap.a18,R.mipmap.a19,R.mipmap.a20,R.mipmap.a21,R.mipmap.a22,R.mipmap.a23,R.mipmap.a24,R.mipmap.a25,R.mipmap.a26,R.mipmap.a27,R.mipmap.a28};

    public String url[]={"http://blog.csdn.net/xie115626895/article/details/51356050","http://blog.csdn.net/mynameishuangshuai/article/details/51783303",
            "http://blog.csdn.net/lmj623565791/article/details/47911083","http://blog.csdn.net/lmj623565791/article/details/45059587",
            "http://blog.csdn.net/lmj623565791/article/details/45460089","http://blog.csdn.net/fenghai22/article/details/44061307",
            "http://blog.csdn.net/tianxiangshan/article/details/7871667","http://blog.csdn.net/sinat_29255093/article/details/51817278",
            "http://blog.csdn.net/lmj623565791/article/details/47079737","http://blog.csdn.net/tskyfree/article/details/46877671",

            "http://blog.csdn.net/lmj623565791/article/details/52761658","http://blog.csdn.net/xu_fu/article/details/8262153",
            "http://www.cnblogs.com/0616--ataozhijia/p/4003380.html","http://blog.csdn.net/maoxiao1229/article/details/22886337",
            "http://blog.csdn.net/fisher0113/article/details/51362719","http://blog.csdn.net/u013435893/article/details/50608190",
            "http://blog.csdn.net/languodongs/article/details/53435844","http://blog.csdn.net/u013101864/article/details/51500136",
            "http://blog.csdn.net/u011726984/article/details/49456287","http://blog.csdn.net/lmj623565791/article/details/37970961/",

            "http://blog.csdn.net/lmj623565791/article/details/39102591","http://blog.csdn.net/lmj623565791/article/details/40481055",
            "http://blog.csdn.net/lmj623565791/article/details/38614699","http://blog.csdn.net/lmj623565791/article/details/38461079",
            "http://blog.csdn.net/lmj623565791/article/details/51304204","http://blog.csdn.net/lmj623565791/article/details/49883661",
            "http://blog.csdn.net/lmj623565791/article/details/46596109","http://blog.csdn.net/lmj623565791/article/details/40794879",
            "http://blog.csdn.net/lmj623565791/article/details/38799363","http://blog.csdn.net/zuolongsnail/article/details/6373051"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutResId(), null);
        ButterKnife.bind(this, root);
        init();
        return root;
    }

    protected void init() {

    }

    public abstract int getLayoutResId();
}
