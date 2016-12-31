package com.itheima.resume.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.itheima.resume.R;
import com.itheima.resume.bean.FragmentBean;
import com.itheima.resume.view.GameEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/*
 *  @项目名：  Resume 
 *  @包名：    com.itheima.resume.activity
 *  @文件名:   DetailsActivity
 *  @创建者:   Administrator
 *  @创建时间:  2016/12/30 19:22
 *  @描述：    TODO
 */
public class DetailsActivity extends BaseActivity {
    private static final String TAG = "DetailsActivity";
    @Bind(R.id.details_background_image)
    ImageView mDetailsBackgroundImage;
 /*   @Bind(R.id.details_album_image)
    ImageView mDetailsAlbumImage;*/
    @Bind(R.id.name)
    TextView mName;
    @Bind(R.id.time)
    TextView mTime;
    @Bind(R.id.environment)
    TextView mEnvironment;
    @Bind(R.id.project)
    TextView mProject;
    @Bind(R.id.responsibility)
    LinearLayout mResponsibility;
    @Bind(R.id.describe)
    LinearLayout mDescribe;

    private ArrayList<GameEntity> mData = new ArrayList<>(0);

    @Override
    public int getView() {
        return R.layout.activity_details;
    }

    @Override
    public void init() {
        super.init();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("项目详情");

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        position=position%4;
        Gson gson = new Gson();
        FragmentBean bean = gson.fromJson(getString(R.string.bean), FragmentBean.class);

        FragmentBean.ListBean listBean = bean.getList().get(position);


        mData.add(new GameEntity(R.drawable.image_1, R.string.title1));
        mData.add(new GameEntity(R.drawable.image_2, R.string.title2));
        mData.add(new GameEntity(R.drawable.image_3, R.string.title3));
        mData.add(new GameEntity(R.drawable.image_4, R.string.title4));

        mDetailsBackgroundImage.setImageResource(mData.get(position).imageResId);

        mName.setText(listBean.getName());
        mTime.setText(listBean.getTime());
        mEnvironment.setText(listBean.getEnvironment());
        mProject.setText(listBean.getProject());

        List<String> responsibility = listBean.getResponsibility();
        for (int i=0;i<listBean.getResponsibility().size();i++){
            TextView text=new TextView(this);
            text.setText(responsibility.get(i));
            text.setTextSize(16);
            mResponsibility.addView(text);

        }

        List<String> describe = listBean.getDescribe();
        for (int i=0;i<listBean.getDescribe().size();i++){
            TextView text=new TextView(this);
            text.setText(describe.get(i));
            text.setTextSize(16);
            mDescribe.addView(text);

        }



    }


}
