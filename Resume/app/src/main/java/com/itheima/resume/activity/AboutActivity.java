package com.itheima.resume.activity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.resume.R;

/*
 *  @项目名：  Resume 
 *  @包名：    com.itheima.resume.activity
 *  @文件名:   AboutActivity
 *  @创建者:   Administrator
 *  @创建时间:  2016/12/26 20:15
 *  @描述：    TODO
 */
public class AboutActivity extends BaseActivity {
    private static final String TAG = "AboutActivity";

    @Override
    public int getView() {
        return R.layout.activity_about;
    }

    @Override
    public void init() {
        super.init();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.my);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            addPreferencesFromResource(R.xml.settings_pref);

            return super.onCreateView(inflater, container, savedInstanceState);
        }

        @Override
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
            switch (preference.getKey()) {
                case "about":
                    startActivity(new Intent(getActivity(), MyAboutActivity.class));
                    break;
                case "github":
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("url", "https://github.com/ITReborn");
                    intent.putExtra("title","GitHub");
                    startActivity(intent);
                    break;
                case "csdn":
                    Intent intent1 = new Intent(getActivity(), WebViewActivity.class);
                    intent1.putExtra("url", "http://blog.csdn.net/languodongs");
                    intent1.putExtra("title","博客");
                    startActivity(intent1);
                    break;
                case "jianshu":
                    Intent intent2 = new Intent(getActivity(), WebViewActivity.class);
                    intent2.putExtra("url", "http://www.jianshu.com/users/3a440aae8d3c/latest_articles");
                    intent2.putExtra("title","简书");
                    startActivity(intent2);
                    break;

            }

           /* if(preference.getKey().equals("about")){
                startActivity(new Intent(getActivity(),MyAboutActivity.class));
            }*/

            return super.onPreferenceTreeClick(preferenceScreen, preference);
        }
    }

}
