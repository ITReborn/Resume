package com.itheima.resume.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.itheima.resume.R;
import com.itheima.resume.activity.WebViewActivity;
import com.itheima.resume.adapter.SkillAdapter;
import com.itheima.resume.bean.SkillBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/*
 *  @项目名：  Resume 
 *  @包名：    com.itheima.resume.fragment
 *  @文件名:   HomeFragment
 *  @创建者:   Administrator
 *  @创建时间:  2016/12/25 20:26
 *  @描述：    TODO
 */
public class HomeFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private static final String TAG = "HomeFragment";
    @Bind(R.id.videoplayer)
    JCVideoPlayerStandard mVideoplayer;
    @Bind(R.id.listview)
    ListView mListview;

    List<SkillBean> mList;



    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {
        super.init();

        /*mVideoplayer.setUp("http://hc.yinyuetai.com/uploads/videos/common/828901594AA84C996780493CC68C2F98.mp4"
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "大闹天竺");*/
        mVideoplayer.setUp("file:///android_asset/aaa.mp4"
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "没有谁是谁的谁");

        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean automatic = defaultSharedPreferences.getBoolean("automatic", false);
        if (automatic){
            mVideoplayer.startPlayLogic();
        }

        mList=new ArrayList<>();
        Random r=new Random();

        String[] array = getContext().getResources().getStringArray(R.array.skill);
        for (int i=0;i<array.length;i++) {
            SkillBean bean = new SkillBean();
            bean.titile=array[i];
            bean.url=url[i];
            int j = r.nextInt(icon.length);
            bean.icon=icon[j];
            mList.add(bean);

        }

        SkillAdapter adapter=new SkillAdapter(getContext(),mList);

        mListview.setAdapter(adapter);
        mListview.setOnItemClickListener(this);

    }


    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent=new Intent(getContext(), WebViewActivity.class);
        intent.putExtra("url",mList.get(position).url);
        intent.putExtra("title",R.string.activitybar);
        startActivity(intent);
    }
}
