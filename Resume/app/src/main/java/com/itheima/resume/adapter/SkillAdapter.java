package com.itheima.resume.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.resume.R;
import com.itheima.resume.bean.SkillBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
 *  @项目名：  Resume 
 *  @包名：    com.itheima.resume.adapter
 *  @文件名:   SkillAdapter
 *  @创建者:   Administrator
 *  @创建时间:  2016/12/25 21:18
 *  @描述：    TODO
 */
public class SkillAdapter extends BaseAdapter {
    private static final String TAG = "SkillAdapter";

    Context mContext;
    List<SkillBean> mList;

    public SkillAdapter(Context context, List<SkillBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_skill, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        holder.mTvSkill.setText(mList.get(position).titile);
        holder.mIvIcon.setImageResource(mList.get(position).icon);

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_icon)
        ImageView mIvIcon;
        @Bind(R.id.tv_skill)
        TextView mTvSkill;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
