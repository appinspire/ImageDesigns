package com.appinspire.imagedesigns;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private final int REFRESH_TIME_SECONDS = 1 * 1000;
    private Handler mHandler;
    private Runnable mRunnableStart = new Runnable() {
        @Override
        public void run() {
            try {
                mHandler.removeCallbacks(mRunnableStart);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    if (AppUtils.isInternetAvailable(getApplicationContext()))
                        mHandler.postDelayed(mRunnableStart, REFRESH_TIME_SECONDS);
                }
            } catch (Exception e) {
            }

        }
    };
    CardView share_app_card;
    CardView rate_app_card;
    CardView more_apps_card;
    CardView about_us_card;
    CardView more_prods_card;
    CardView designs_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, getString(R.string.admob_app_id));
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.admob_interstitial));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mHandler = new Handler();
        mHandler.postDelayed(mRunnableStart, 2000);
        mAdView = (AdView) findViewById(R.id.adView_main);
        mAdView.setVisibility(View.GONE);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
            }
        });
        designs_card = (CardView) findViewById(R.id.designs);
        share_app_card = (CardView) findViewById(R.id.share_app);
        more_apps_card = (CardView) findViewById(R.id.more_apps);
        more_prods_card = (CardView) findViewById(R.id.more_prods);
        rate_app_card = (CardView) findViewById(R.id.rate_app);
        about_us_card = (CardView) findViewById(R.id.about_us);
        designs_card.setOnClickListener(this);
        share_app_card.setOnClickListener(this);
        more_apps_card.setOnClickListener(this);
        more_prods_card.setOnClickListener(this);
        rate_app_card.setOnClickListener(this);
        about_us_card.setOnClickListener(this);
        Fresco.initialize(getApplicationContext());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mHandler.postDelayed(mRunnableStart, 1000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.more_apps:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://search?q=pub:AppInspire")));
                } catch (android.content.ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/search?q=pub:AppInspire")));
                }
                break;
            case R.id.more_prods:
                break;
            case R.id.rate_app:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + this.getPackageName())));
                } catch (android.content.ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
                }
                break;
            case R.id.about_us:
                break;
            case R.id.share_app:
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
                    String sAux = "\nLet me recommend you this application\n\n";
                    sAux = sAux + "https://play.google.com/store/apps/details?id="+this.getPackageName()+"\n\n";
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "Choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
                break;
            case R.id.designs:
                startActivity(new Intent(this,ImagesActivity.class));
                break;
        }

    }
}
