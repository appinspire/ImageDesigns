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
    Button buttonBeautiful,buttonJewelry,buttonlatest,buttonModern,buttonNewDiamond,
            buttonSilkThread,buttonTrendy,buttonWomen;
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
        buttonBeautiful = (Button) findViewById(R.id.btn_beautiful);
        buttonlatest = (Button) findViewById(R.id.btn_latest);
        buttonModern = (Button) findViewById(R.id.btn_modern);
        buttonNewDiamond = (Button) findViewById(R.id.btn_diamond);
        buttonSilkThread = (Button) findViewById(R.id.btn_silk);
        buttonTrendy = (Button) findViewById(R.id.btn_trendy);
        buttonWomen = (Button) findViewById(R.id.btn_women);
        buttonJewelry = (Button) findViewById(R.id.btn_jewellery);

        buttonBeautiful.setOnClickListener(this);
        buttonlatest.setOnClickListener(this);
        buttonModern.setOnClickListener(this);
        buttonNewDiamond.setOnClickListener(this);
        buttonSilkThread.setOnClickListener(this);
        buttonTrendy.setOnClickListener(this);
        buttonWomen.setOnClickListener(this);
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
            case R.id.btn_beautiful:
                intent.putExtra(Constants.DATA, CategoryEnum.BEAUTIFUL.getValue());
                startActivity(intent);
                break;
            case R.id.btn_diamond:
                intent.putExtra(Constants.DATA, CategoryEnum.NEW_DIAMOND.getValue());
                startActivity(intent);
                break;
            case R.id.btn_jewellery:
                intent.putExtra(Constants.DATA, CategoryEnum.JEWELLERY.getValue());
                startActivity(intent);
                break;
            case R.id.btn_latest:
                intent.putExtra(Constants.DATA, CategoryEnum.LATEST.getValue());
                startActivity(intent);
                break;
            case R.id.btn_modern:
                intent.putExtra(Constants.DATA, CategoryEnum.MODERN.getValue());
                startActivity(intent);
                break;
            case R.id.btn_silk:
                intent.putExtra(Constants.DATA, CategoryEnum.SILK.getValue());
                startActivity(intent);
                break;
            case R.id.btn_trendy:
                intent.putExtra(Constants.DATA, CategoryEnum.TRENDY.getValue());
                startActivity(intent);
                break;
            case R.id.btn_women:
                intent.putExtra(Constants.DATA, CategoryEnum.JEWELLERY.getValue());
                startActivity(intent);
                break;
        }
    }
}
