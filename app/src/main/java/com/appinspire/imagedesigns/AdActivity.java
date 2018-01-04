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

//        String data_html = "<!DOCTYPE html><html> <head> <meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"target-densitydpi=high-dpi\" /> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> <link rel=\"stylesheet\" media=\"screen and (-webkit-device-pixel-ratio:1.5)\" href=\"hdpi.css\" /></head> <body style=\"background:black;margin:0 0 0 0; padding:0 0 0 0;\"> <iframe style=\"background:black;\" width=' "+width+"' height='"+height+"'  src=\"//ws-na.amazon-adsystem.com/widgets/q?ServiceVersion=20070822&OneJS=1&Operation=GetAdHtml&MarketPlace=US&source=ac&ref=tf_til&ad_type=product_link&tracking_id=mobstudioapps-20&marketplace=amazon&region=US&placement=B071KW9GTT&asins=B071KW9GTT&linkId=d84a893a64c95748cd1c22971b230c3f&show_border=false&link_opens_in_new_window=false&price_color=333333&title_color=0066c0&bg_color=ffffff\">\n" +
//                "    </iframe> </body> </html> ";
        String src = "http://ws-na.amazon-adsystem.com/widgets/q?ServiceVersion=20070822&OneJS=1&Operation=GetAdHtml&MarketPlace=US&source=ac&ref=tf_til&ad_type=product_link&tracking_id=mobstudioapps-20&marketplace=amazon&region=US&placement=B071KW9GTT&asins=B071KW9GTT&linkId=d84a893a64c95748cd1c22971b230c3f&show_border=false&link_opens_in_new_window=false&price_color=333333&title_color=0066c0&bg_color=ffffff";

//        String html = "";
//        html += "<html><body>";
//        html += "<iframe width=\""+width+"\" height=\""+height+"\" " +
//                "src="+src+
//                "</iframe>";
//        html += "</body></html>";
////        webView.loadData( html, "text/html", null);
        webView.loadUrl(src);
        webView.setInitialScale(AppUtils.dpToPx(200));

    }
    public void onclick(View view){
        finish();
    }
}
