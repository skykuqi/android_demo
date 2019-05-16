package com.sky.myapplication.androidword1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class WebViewActivity extends AppCompatActivity {
    private WebView web_view_webview;
    private TextView web_view_text;
    int maxWidth;
    String url = "http://m.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        web_view_webview = findViewById(R.id.web_view_webview);
        web_view_text = findViewById(R.id.web_view_text);
        maxWidth = web_view_text.getMaxWidth();
//        加载本地html
//        web_view_webview.loadUrl("file:////android_asset/web/index.html");
//        加载网络html  由于默认不提供js支持,无法打开
        web_view_webview.getSettings().setJavaScriptEnabled(true);
        //使用app打开网页
        web_view_webview.setWebViewClient(new MyWebViewClient());
        web_view_webview.setWebChromeClient(new MyWebChromeClient());
        //回调js  也可以使用web_view_webview.loadUrl();
//        web_view_webview.evaluateJavascript();
        //可以在本地写js方法    保持通信的方法
//        web_view_webview.addJavascriptInterface();
        web_view_webview.loadUrl(url);


    }

    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            ///不希望调用外部浏览器,只希望继续在当前页面加载
           /* String[] urls = request.getUrl().toString().split("://");
            if(urls.length == 2){
                view.loadUrl("http://"+urls[1]);
            }else {
                view.loadUrl(url);
            }*/
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            view.loadUrl("javascript:alert('OK')");

        }
    }

    class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            //可以得知加载进度
            web_view_text.setWidth((int)((maxWidth/100.0)*newProgress));

        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            //返回HTML title标签中的title
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && web_view_webview.canGoBack()) {
            web_view_webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
