package com.itheima.resume.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.itheima.resume.R;
import com.itheima.resume.activity.AboutActivity;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/*
 *  @项目名：  Resume 
 *  @包名：    com.itheima.resume.fragment
 *  @文件名:   MyFragment
 *  @创建者:   Administrator
 *  @创建时间:  2016/12/25 20:27
 *  @描述：    TODO
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "MyFragment";
    @Bind(R.id.iv_icon)
    ImageView mIvIcon;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void init() {
        super.init();

        Picasso.with(getContext()).load(R.mipmap.icon).transform(new CropCircleTransformation()).into(mIvIcon);

        mIvIcon.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(getContext(), AboutActivity.class));
    }
}
