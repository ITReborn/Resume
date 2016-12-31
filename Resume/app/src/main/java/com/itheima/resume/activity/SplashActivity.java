package com.itheima.resume.activity;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.itheima.resume.MainActivity;
import com.itheima.resume.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/*
 *  @项目名：  Resume 
 *  @包名：    com.itheima.resume.activity
 *  @文件名:   SplashActivity
 *  @创建者:   Administrator
 *  @创建时间:  2016/12/25 19:34
 *  @描述：    TODO
 */
public class SplashActivity extends BaseActivity implements Animation.AnimationListener {
    private static final String TAG = "SplashActivity";
    @Bind(R.id.imageView)
    ImageView mImageView;


    @Override
    public int getView() {
        return R.layout.activity_splash;
    }

    @Override
    public void init() {
        super.init();
        Picasso.with(this).load(R.mipmap.icon).transform(new CropCircleTransformation()).into(mImageView);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.splash_anim);
        mImageView.startAnimation(animation);
        animation.setAnimationListener(this);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        goTo(MainActivity.class,true);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
