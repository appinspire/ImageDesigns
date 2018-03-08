package com.appinspire.imagedesigns;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.stfalcon.frescoimageviewer.ImageViewer;

public class ImagesActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    AdView mAdView;
    AdView mAdView1;
    AdView mAdView2;
    AdView mAdView3;
    AdView mAdView4;
    AdView mAdView5;
    AdView mAdView6;
    AdView mAdView7;
    AdView mAdView8;
    AdView mAdView9;
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

    private FirebaseAnalytics mFirebaseAnalytics;
    private static final int[] ids = new int[]{
            R.id.image_1,
            R.id.image_2,
            R.id.image_3,
            R.id.image_4,
            R.id.image_5,
            R.id.image_6,
            R.id.image_7,
            R.id.image_8,
            R.id.image_9,
            R.id.image_10,
            R.id.image_11,
            R.id.image_12,
            R.id.image_13,
            R.id.image_14,
            R.id.image_15,
            R.id.image_16,
            R.id.image_17,
            R.id.image_18,
            R.id.image_19,
            R.id.image_20,
            R.id.image_21,
            R.id.image_22,
            R.id.image_23,
            R.id.image_24,
            R.id.image_25,
            R.id.image_26,
            R.id.image_27,
            R.id.image_28,
            R.id.image_29,
            R.id.image_30,
            R.id.image_31,
            R.id.image_32,
            R.id.image_33,
            R.id.image_34,
            R.id.image_35,
            R.id.image_36,
            R.id.image_37,
            R.id.image_38,
            R.id.image_39,
            R.id.image_40,
            R.id.image_41,
            R.id.image_42,
            R.id.image_43,
            R.id.image_44,
            R.id.image_45,
            R.id.image_46,
            R.id.image_47,
            R.id.image_48,
            R.id.image_49,
            R.id.image_50,
            R.id.image_51,
            R.id.image_52,
            R.id.image_53,
            R.id.image_54,
    };

    protected String[] posters, descriptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        init();
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.admob_interstitial));
        mHandler = new Handler();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "ImageActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        mAdView = (AdView) findViewById(R.id.adView);
        mAdView.setVisibility(View.GONE);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
            }
        });

        mAdView1 = (AdView) findViewById(R.id.adView_1);
        mAdView2 = (AdView) findViewById(R.id.adView_2);
        mAdView3 = (AdView) findViewById(R.id.adView_3);
        mAdView4 = (AdView) findViewById(R.id.adView_4);
        mAdView5 = (AdView) findViewById(R.id.adView_5);
        mAdView6 = (AdView) findViewById(R.id.adView_6);
        mAdView7 = (AdView) findViewById(R.id.adView_7);
        mAdView8 = (AdView) findViewById(R.id.adView_8);
        mAdView9 = (AdView) findViewById(R.id.adView_9);
        mAdView1.setVisibility(View.GONE);
        mAdView2.setVisibility(View.GONE);
        mAdView3.setVisibility(View.GONE);
        mAdView4.setVisibility(View.GONE);
        mAdView5.setVisibility(View.GONE);
        mAdView6.setVisibility(View.GONE);
        mAdView7.setVisibility(View.GONE);
        mAdView8.setVisibility(View.GONE);
        mAdView9.setVisibility(View.GONE);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        AdRequest adRequest2 = new AdRequest.Builder().build();
        AdRequest adRequest3 = new AdRequest.Builder().build();
        AdRequest adRequest4 = new AdRequest.Builder().build();
        AdRequest adRequest5 = new AdRequest.Builder().build();
        AdRequest adRequest6 = new AdRequest.Builder().build();
        AdRequest adRequest7 = new AdRequest.Builder().build();
        AdRequest adRequest8 = new AdRequest.Builder().build();
        AdRequest adRequest9 = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest1);
        mAdView2.loadAd(adRequest2);
        mAdView3.loadAd(adRequest3);
        mAdView4.loadAd(adRequest4);
        mAdView5.loadAd(adRequest5);
        mAdView6.loadAd(adRequest6);
        mAdView7.loadAd(adRequest7);
        mAdView8.loadAd(adRequest8);
        mAdView9.loadAd(adRequest9);

        mAdView1.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mAdView1.setVisibility(View.VISIBLE);
            }
        });
        mAdView2.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mAdView2.setVisibility(View.VISIBLE);
            }
        });
        mAdView3.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mAdView3.setVisibility(View.VISIBLE);
            }
        });
        mAdView4.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mAdView4.setVisibility(View.VISIBLE);
            }
        });
        mAdView5.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mAdView5.setVisibility(View.VISIBLE);
            }
        });
        mAdView6.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mAdView6.setVisibility(View.VISIBLE);
            }
        });
        mAdView7.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mAdView7.setVisibility(View.VISIBLE);
            }
        });
        mAdView8.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mAdView8.setVisibility(View.VISIBLE);
            }
        });
        mAdView9.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mAdView9.setVisibility(View.VISIBLE);
            }
        });
    }
    protected void showPicker(int startPosition) {

        new ImageViewer.Builder<>(this, posters)
                .setStartPosition(startPosition).setImageChangeListener(new ImageViewer.OnImageChangeListener() {
            @Override
            public void onImageChange(int position) {
                if(position % 3 == 0) {
//                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
//                    mHandler.postDelayed(mRunnableStart, 200);
                }
            }
        })
                .show();
    }
    protected void init() {
        posters = Demo.getPosters();
        descriptions = Demo.getDescriptions();

        for (int i = 0; i < ids.length; i++) {
            SimpleDraweeView drawee = (SimpleDraweeView) findViewById(ids[i]);
            initDrawee(drawee, i);
        }
    }
    private void initDrawee(SimpleDraweeView drawee, final int startPosition) {
        drawee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPicker(startPosition);
            }
        });
        drawee.setImageURI(posters[startPosition]);
    }
}
