package com.appinspire.imagedesigns;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mHandler.postDelayed(mRunnableStart, 1000);
    }
}
