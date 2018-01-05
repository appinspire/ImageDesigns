package com.appinspire.imagedesigns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AdActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);

        webView = (WebView) findViewById(R.id.webview1);
        webView.setInitialScale(1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);
//        webView.loadUrl("http://www.resource.com.br/");
//        webView.setWebChromeClient(new WebChromeClient());
//        webView.getSettings().setAllowFileAccess(true);
//        webView.setWebViewClient(new WebViewClient());

        String html = "";
        html += "<html><body>";
        html += "<a href=\"http://s.click.aliexpress.com/e/BUjeuJQ?bz=320*480\" target=\"_parent\"><img width=\"320\" height=\"480\" src=\"https://ae01.alicdn.com/kf/HTB1dPhvKpXXXXXpXpXXq6xXFXXXe/100g-Dried-Rose-Petals-Bath-Tools-Natural-Dry-Flower-Petal-Spa-Whitening-Shower-Aromatherapy-Bathing-Beauty.jpg_220x220.jpg\"/></a>";
        html += "</body></html>";
        webView.loadData( html, "text/html", null);
//        webView.loadUrl(src);
        webView.setInitialScale(AppUtils.dpToPx(120));
//        webView.setInitialScale(1);

    }
    public void onclick(View view){
        finish();
    }
}
