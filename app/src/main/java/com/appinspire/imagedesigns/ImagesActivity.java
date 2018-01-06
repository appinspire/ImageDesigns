package com.appinspire.imagedesigns;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.stfalcon.frescoimageviewer.ImageViewer;

public class ImagesActivity extends AppCompatActivity {
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
    }
    protected void showPicker(int startPosition) {

        new ImageViewer.Builder<>(this, posters)
                .setStartPosition(startPosition).setImageChangeListener(new ImageViewer.OnImageChangeListener() {
            @Override
            public void onImageChange(int position) {
                if(position % 3 == 0) {
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    mHandler.postDelayed(mRunnableStart, 200);
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
