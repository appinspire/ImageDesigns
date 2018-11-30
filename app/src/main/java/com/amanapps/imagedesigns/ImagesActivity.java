package com.amanapps.imagedesigns;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.amanapps.imagedesigns.models.Configuration;
import com.amanapps.imagedesigns.utils.Constants;
import com.amanapps.imagedesigns.utils.PrefUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.stfalcon.frescoimageviewer.ImageViewer;

import java.util.ArrayList;
import java.util.List;

public class ImagesActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    Configuration mConfiguration;
    private DatabaseReference mDatabase;
    LinearLayout layoutParent,adContainerBottom;
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

    ValueEventListener valueEventListener;
    protected String[] posters, descriptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        layoutParent = (LinearLayout) findViewById(R.id.parent_layout);
        adContainerBottom = (LinearLayout) findViewById(R.id.ad_container_bottom);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mConfiguration = dataSnapshot.getValue(Configuration.class);
                PrefUtils.persistString(ImagesActivity.this, Constants.BANNER_ID,mConfiguration.admob_banner_id);
                setupMainAds();
                init();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDatabase.child("ringdesigns").addValueEventListener(valueEventListener);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "ImageActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

    }
    public void setupMainAds(){
        if(mConfiguration.interstitial_enable) {
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId(mConfiguration.admob_interstitial_id);
            mHandler = new Handler();
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
            mHandler.postDelayed(mRunnableStart, 2000);
        }
        ViewGroup.LayoutParams wrapParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final AdView adViewBottom;
        adViewBottom = new AdView(this);
        adViewBottom.setLayoutParams(wrapParams);
        adViewBottom.setAdUnitId(mConfiguration.admob_banner_id);
        adViewBottom.setAdSize(AdSize.BANNER);
        adViewBottom.setVisibility(View.GONE);
        AdRequest adRequestBottom = new AdRequest.Builder().build();
        adContainerBottom.addView(adViewBottom);

        adViewBottom.loadAd(adRequestBottom);
        adViewBottom.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                adViewBottom.setVisibility(View.VISIBLE);
            }
        });
    }
    private ImageOverlayView overlayView;
    protected void showPicker(int startPosition) {
        overlayView = new ImageOverlayView(this);

        new ImageViewer.Builder<>(this, posters)
                .setStartPosition(startPosition).setOverlayView(overlayView)
                .setImageChangeListener(new ImageViewer.OnImageChangeListener() {
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
    List<AdView> adViewList;
    public void initAds(){
        int total_ads = mConfiguration.total_pictures/mConfiguration.interval_ad;
        total_ads=total_ads-1;
        ViewGroup.LayoutParams wrapParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        adViewList = new ArrayList<>();
        AdView tempAdview;
        for(int i=0;i<total_ads;i++){
            tempAdview=new AdView(this);
            tempAdview.setLayoutParams(wrapParams);
            tempAdview.setAdUnitId(mConfiguration.admob_banner_id);
            tempAdview.setAdSize(AdSize.MEDIUM_RECTANGLE);
            tempAdview.setVisibility(View.GONE);
            adViewList.add(tempAdview);

        }
        for (int i=0;i<total_ads;i++){
            final int position = i;
            adViewList.get(position).setAdListener(new AdListener(){
                @Override
                public void onAdLoaded() {
                    adViewList.get(position).setVisibility(View.VISIBLE);
                }
            });
        }


    }
    protected void init() {
        initAds();
        ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, AppUtils.dpToPx(300));


        posters = Demo.getPosters();
        descriptions = Demo.getDescriptions();
        int adPosition = 0;

        for (int i = 0; i < mConfiguration.total_pictures; i++) {
            SimpleDraweeView simpleDraweeView =new SimpleDraweeView(this);

            simpleDraweeView.setBackgroundResource(R.drawable.placeholder);
            simpleDraweeView.setLayoutParams(lparams);
            this.layoutParent.addView(simpleDraweeView);
            AdRequest adRequestBanner;
            if((i+1)%mConfiguration.interval_ad==0 && (i+1) !=mConfiguration.total_pictures){
                adRequestBanner = new AdRequest.Builder().build();
                this.layoutParent.addView(adViewList.get(adPosition));
                adViewList.get(adPosition).loadAd(adRequestBanner);
                adPosition++;

            }
//            SimpleDraweeView drawee = (SimpleDraweeView) findViewById(ids[i]);
            initDrawee(simpleDraweeView, i);
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

    @Override
    protected void onPause() {
        super.onPause();
        mDatabase.child("ringdesigns").removeEventListener(valueEventListener);
    }
}
