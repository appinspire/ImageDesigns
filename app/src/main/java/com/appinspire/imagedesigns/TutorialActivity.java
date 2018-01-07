package com.appinspire.imagedesigns;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.VideoView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by Bilal Rashid on 1/7/2018.
 */

public class TutorialActivity extends AppCompatActivity {
    WebView webView;
    private FirebaseAnalytics mFirebaseAnalytics;
    AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        webView = (WebView) findViewById(R.id.webview1);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "TutorialActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int w1 = (int) (metrics.widthPixels / metrics.density), h1 = w1 * 3 / 5;
        String frameVideo = "<html><body>Easy Mehandi design Tutorials<br>" +
                "<iframe width=\""+w1+"\" height=\""+h1+"\" src=\"https://www.youtube.com/embed/D7hxRbQCmK8\" frameborder=\"0\" allowfullscreen></iframe><hr></hr>" +
                "<iframe width=\""+w1+"\" height=\""+h1+"\" src=\"https://www.youtube.com/embed/JMtrysCElDs\" frameborder=\"0\" allowfullscreen></iframe>" +
                "</body></html>";
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadData(frameVideo, "text/html", "utf-8");
        mAdView = (AdView) findViewById(R.id.adView_tutorial);
        mAdView.setVisibility(View.GONE);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
            }
        });


    }
}
