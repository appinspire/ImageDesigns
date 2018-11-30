package com.amanapps.imagedesigns;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/**
 * Created by Bilal Rashid on 3/31/2018.
 */

public class ImageOverlayView extends RelativeLayout {


    private LinearLayout mContainerTop,mContainerBottom;

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
        mContainerBottom = (LinearLayout) view.findViewById(R.id.ad_container_bottom);
        mContainerTop = (LinearLayout) view.findViewById(R.id.ad_container_top);
        ViewGroup.LayoutParams wrapParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        AdView adViewTop,adViewBottom;
        adViewTop = new AdView(getContext());
        adViewBottom = new AdView(getContext());

        adViewTop.setLayoutParams(wrapParams);
        adViewTop.setAdUnitId(getResources().getString(R.string.admob_banner_id));
        adViewTop.setAdSize(AdSize.BANNER);

        adViewBottom.setLayoutParams(wrapParams);
        adViewBottom.setAdUnitId(getResources().getString(R.string.admob_banner_id));
        adViewBottom.setAdSize(AdSize.BANNER);

        AdRequest adRequestTop = new AdRequest.Builder().build();
        AdRequest adRequestBottom = new AdRequest.Builder().build();

        mContainerTop.addView(adViewTop);
        mContainerBottom.addView(adViewBottom);

        adViewTop.loadAd(adRequestTop);
        adViewBottom.loadAd(adRequestBottom);

    }
}