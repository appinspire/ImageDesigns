package com.amanapps.imagedesigns;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.amanapps.imagedesigns.R;
import com.amanapps.imagedesigns.models.Configuration;
import com.amanapps.imagedesigns.utils.Constants;
import com.amanapps.imagedesigns.utils.PrefUtils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CategoryActivity extends AppCompatActivity {

    LinearLayout adContainerBottom, adContainerTop;
    String banner_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        banner_id = PrefUtils.getString(this,Constants.BANNER_ID);
        adContainerTop = (LinearLayout) findViewById(R.id.ad_container_top);
        adContainerBottom = (LinearLayout) findViewById(R.id.ad_container_bottom);
        if(banner_id!=null){
            setupMainAds();
        }
    }

    public void setupMainAds(){
        ViewGroup.LayoutParams wrapParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final AdView adViewBottom;
        adViewBottom = new AdView(this);
        adViewBottom.setLayoutParams(wrapParams);
        adViewBottom.setAdUnitId(banner_id);
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

        final AdView adViewTop;
        adViewTop = new AdView(this);
        adViewTop.setLayoutParams(wrapParams);
        adViewTop.setAdUnitId(banner_id);
        adViewTop.setAdSize(AdSize.BANNER);
        adViewTop.setVisibility(View.GONE);
        AdRequest adRequestTop = new AdRequest.Builder().build();
        adContainerTop.addView(adViewTop);

        adViewTop.loadAd(adRequestTop);
        adViewTop.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                adViewTop.setVisibility(View.VISIBLE);
            }
        });
    }
}
