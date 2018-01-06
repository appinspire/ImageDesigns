package com.appinspire.imagedesigns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.util.Random;

public class AdActivity extends AppCompatActivity {
    WebView webView;
    TextView textProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);

        webView = (WebView) findViewById(R.id.webview1);
        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        textProduct = (TextView) findViewById(R.id.text_product);
        webView.setInitialScale(1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        Random r = new Random();
        int random = r.nextInt(40);
        Products product = Products.getProducts()[random];
        String clickaddress = product.click_link;
        String imageaddress= product.image_link;
        textProduct.setText(product.product_name);
//        webView.loadUrl("http://www.resource.com.br/");
//        webView.setWebChromeClient(new WebChromeClient());
//        webView.getSettings().setAllowFileAccess(true);
//        webView.setWebViewClient(new WebViewClient());
//        String clickaddress = "http://s.click.aliexpress.com/e/2zJuRzR";
//        String imageaddress = "https://ae01.alicdn.com/kf/HTB1_70ORXXXXXXQapXXq6xXFXXXz/8-PCS-2017-New-Safe-Bowknot-Rabbit-Head-Hairpins-Ornaments-Hair-Jewelry-Girls-Accessories-Children-Hair.jpg_220x220.jpg";
        String html = "";
        html += "<html><body>";
        html += "<a href=\""+clickaddress+"\" target=\"_parent\"><img width=\"320\" height=\"430\" src=\""+imageaddress+"\"/></a>";
        html += "</body></html>";
        webView.loadData( html, "text/html", null);
//        webView.loadUrl(src);
        webView.setInitialScale(AppUtils.dpToPx(110));
//        webView.setInitialScale(1);

    }
    public void onclick(View view){
        finish();
    }
}
