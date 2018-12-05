package com.amanapps.imagedesigns;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.amanapps.imagedesigns.R;
import com.amanapps.imagedesigns.enums.CategoryEnum;
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

public class CategoryActivity extends AppCompatActivity  implements View.OnClickListener{

    LinearLayout adContainerBottom, adContainerTop;
    String banner_id;
    Button buttonNew,buttonJewelry,buttonPromise,buttonDiamond,buttonCouple,buttonWedding,buttonUnique,buttonEngagement;
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
        buttonCouple = (Button) findViewById(R.id.btn_couple);
        buttonDiamond = (Button) findViewById(R.id.btn_diamond);
        buttonEngagement = (Button) findViewById(R.id.btn_engagement);
        buttonNew = (Button) findViewById(R.id.btn_new);
        buttonPromise = (Button) findViewById(R.id.btn_promise);
        buttonUnique = (Button) findViewById(R.id.btn_unique);
        buttonWedding = (Button) findViewById(R.id.btn_wedding);
        buttonJewelry = (Button) findViewById(R.id.btn_jewellery);

        buttonCouple.setOnClickListener(this);
        buttonDiamond.setOnClickListener(this);
        buttonEngagement.setOnClickListener(this);
        buttonNew.setOnClickListener(this);
        buttonPromise.setOnClickListener(this);
        buttonUnique.setOnClickListener(this);
        buttonWedding.setOnClickListener(this);
        buttonJewelry.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = new Intent(this,ImagesActivity.class);
        switch (id) {
            case R.id.btn_couple:
                intent.putExtra(Constants.DATA, CategoryEnum.COUPLE.getValue());
                startActivity(intent);
                break;
            case R.id.btn_diamond:
                intent.putExtra(Constants.DATA, CategoryEnum.DIAMOND.getValue());
                startActivity(intent);
                break;
            case R.id.btn_engagement:
                intent.putExtra(Constants.DATA, CategoryEnum.ENGAGEMENT.getValue());
                startActivity(intent);
                break;
            case R.id.btn_new:
                intent.putExtra(Constants.DATA, CategoryEnum.NEW.getValue());
                startActivity(intent);
                break;
            case R.id.btn_promise:
                intent.putExtra(Constants.DATA, CategoryEnum.PROMISE.getValue());
                startActivity(intent);
                break;
            case R.id.btn_unique:
                intent.putExtra(Constants.DATA, CategoryEnum.UNIQUE.getValue());
                startActivity(intent);
                break;
            case R.id.btn_wedding:
                intent.putExtra(Constants.DATA, CategoryEnum.WEDDING.getValue());
                startActivity(intent);
                break;
            case R.id.btn_jewellery:
                intent.putExtra(Constants.DATA, CategoryEnum.JEWELLERY.getValue());
                startActivity(intent);
                break;
        }
    }
}
