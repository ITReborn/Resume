package com.itheima.resume.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.itheima.resume.R;

import butterknife.Bind;

/*
 *  @项目名：  Resume 
 *  @包名：    com.itheima.resume.activity
 *  @文件名:   WebViewActivity
 *  @创建者:   Administrator
 *  @创建时间:  2016/12/26 20:54
 *  @描述：    TODO
 */
public class WebViewActivity extends BaseActivity {
    private static final String TAG = "WebViewActivity";
    @Bind(R.id.webview)
    WebView mWebview;
    @Bind(R.id.myProgressBar)
    ProgressBar mMyProgressBar;

    @Override
    public int getView() {
        return R.layout.activity_web_view;
    }

    @Override
    public void init() {
        super.init();

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);



        WebSettings settings = mWebview.getSettings();

        //支持javascript
        settings.setJavaScriptEnabled(true);
        // 设置可以支持缩放
        settings.setSupportZoom(true);
        // 设置出现缩放工具
        settings.setBuiltInZoomControls(true);
        //扩大比例的缩放
        settings.setUseWideViewPort(true);
        //自适应屏幕
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);


        //如果不设置WebViewClient，请求会跳转系统浏览器
        mWebview.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //该方法在Build.VERSION_CODES.LOLLIPOP以前有效，从Build.VERSION_CODES.LOLLIPOP起，建议使用shouldOverrideUrlLoading(WebView, WebResourceRequest)} instead
                //返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址），均交给webView自己处理，这也是此方法的默认处理
                //返回true，说明你自己想根据url，做新的跳转，比如在判断url符合条件的情况下，我想让webView加载http://ask.csdn.net/questions/178242
/*
                if (url.toString().contains("sina.cn")){
                    view.loadUrl("http://ask.csdn.net/questions/178242");
                    return true;
                }*/

                return false;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request)
            {
                //返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址），均交给webView自己处理，这也是此方法的默认处理
                //返回true，说明你自己想根据url，做新的跳转，比如在判断url符合条件的情况下，我想让webView加载http://ask.csdn.net/questions/178242
               /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (request.getUrl().toString().contains("sina.cn")){
                        view.loadUrl("http://ask.csdn.net/questions/178242");
                        return true;
                    }
                }*/

                return false;
            }

        });



        mWebview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mMyProgressBar.setVisibility(View.INVISIBLE);
                } else {
                    if (View.INVISIBLE == mMyProgressBar.getVisibility()) {
                        mMyProgressBar.setVisibility(View.VISIBLE);
                    }
                    mMyProgressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

        });


        mWebview.loadUrl(url);

    }
}
