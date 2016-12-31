package com.itheima.resume.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.itheima.resume.R;
import com.itheima.resume.activity.DetailsActivity;
import com.itheima.resume.view.CoverFlowAdapter;
import com.itheima.resume.view.GameEntity;

import java.util.ArrayList;

import butterknife.Bind;
import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

/*
 *  @项目名：  Resume 
 *  @包名：    com.itheima.resume.fragment
 *  @文件名:   ProjectFragment
 *  @创建者:   Administrator
 *  @创建时间:  2016/12/25 20:27
 *  @描述：    TODO
 */
public class ProjectFragment extends BaseFragment {
    private static final String TAG = "ProjectFragment";
    @Bind(R.id.coverflow)
    FeatureCoverFlow mCoverflow;
    @Bind(R.id.title)
    TextSwitcher mTitle;


    private CoverFlowAdapter mAdapter;
    private ArrayList<GameEntity> mData = new ArrayList<>(0);


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_project;
    }

    @Override
    protected void init() {
        super.init();

        mData.add(new GameEntity(R.drawable.image_1, R.string.title1));
        mData.add(new GameEntity(R.drawable.image_2, R.string.title2));
        mData.add(new GameEntity(R.drawable.image_3, R.string.title3));
        mData.add(new GameEntity(R.drawable.image_4, R.string.title4));


        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                TextView textView = (TextView) inflater.inflate(R.layout.item_title, null);
                return textView;
            }
        });
        final Animation in = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        mAdapter = new CoverFlowAdapter(getContext());
        mAdapter.setData(mData);
        mCoverflow.setAdapter(mAdapter);

        mCoverflow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(getContext(),
                        getResources().getString(mData.get(position).titleResId),
                        Toast.LENGTH_SHORT).show();*/

                Intent intent=new Intent(getContext(), DetailsActivity.class);

                intent.putExtra("position",position);

                startActivity(intent);

            }
        });

        mCoverflow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(getResources().getString(mData.get(position).titleResId));
            }

            @Override
            public void onScrolling() {
                mTitle.setText("");
            }
        });

    }

}
