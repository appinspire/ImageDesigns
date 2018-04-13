package com.appinspire.imagedesigns;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by Bilal Rashid on 3/31/2018.
 */

public class ImageOverlayView extends RelativeLayout {

    private AdView mAdView;
    private AdView mAdView2;

    public ImageOverlayView(Context context) {
        super(context);
        init();
    }

    public ImageOverlayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImageOverlayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = inflate(getContext(), R.layout.view_image_overlay, this);
        mAdView = (AdView) view.findViewById(R.id.adView_top);
        mAdView2 = (AdView) view.findViewById(R.id.adView_bottom);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView2.loadAd(adRequest);
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                Log.d("TAAAG","jjjjjjjjjjjjjjjjjjj");
            }
        });
    }
}