package com.amanapps.imagedesigns;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.amanapps.imagedesigns.enums.CategoryEnum;
import com.amanapps.imagedesigns.utils.Constants;
import com.amanapps.imagedesigns.utils.PrefUtils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.HashMap;

public class CategoryActivity extends AppCompatActivity  implements View.OnClickListener{

    LinearLayout adContainerBottom, adContainerTop;
    String banner_id;
    Button buttonCategory1;
    Button buttonCategory2;
    Button buttonCategory3;
    Button buttonCategory4;
//    Button buttonCategory5;
//    Button buttonCategory6;
//    Button buttonCategory7;
//    Button buttonCategory8;
    HashMap<Integer,String> categoryNames;
    HashMap<Integer,Integer> categoryIds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        createCategoriesdata();
        banner_id = PrefUtils.getString(this,Constants.BANNER_ID);
        adContainerTop = (LinearLayout) findViewById(R.id.ad_container_top);
        adContainerBottom = (LinearLayout) findViewById(R.id.ad_container_bottom);
        if(banner_id!=null){
            setupMainAds();
        }
        buttonCategory1 = (Button) findViewById(R.id.btn_category1);
        buttonCategory2 = (Button) findViewById(R.id.btn_category2);
        buttonCategory3 = (Button) findViewById(R.id.btn_category3);
        buttonCategory4 = (Button) findViewById(R.id.btn_category4);
//        buttonCategory5 = (Button) findViewById(R.id.btn_category5);
//        buttonCategory6 = (Button) findViewById(R.id.btn_category6);
//        buttonCategory7 = (Button) findViewById(R.id.btn_category7);
//        buttonCategory8 = (Button) findViewById(R.id.btn_category8);

        buttonCategory1.setText(categoryNames.get(R.id.btn_category1));
        buttonCategory2.setText(categoryNames.get(R.id.btn_category2));
        buttonCategory3.setText(categoryNames.get(R.id.btn_category3));
        buttonCategory4.setText(categoryNames.get(R.id.btn_category4));
//        buttonCategory5.setText(categoryNames.get(R.id.btn_category5));
//        buttonCategory6.setText(categoryNames.get(R.id.btn_category6));
//        buttonCategory7.setText(categoryNames.get(R.id.btn_category7));
//        buttonCategory8.setText(categoryNames.get(R.id.btn_category8));

        buttonCategory1.setOnClickListener(this);
        buttonCategory2.setOnClickListener(this);
        buttonCategory3.setOnClickListener(this);
        buttonCategory4.setOnClickListener(this);
//        buttonCategory5.setOnClickListener(this);
//        buttonCategory6.setOnClickListener(this);
//        buttonCategory7.setOnClickListener(this);
//        buttonCategory8.setOnClickListener(this);

    }

    private void createCategoriesdata() {
        categoryNames = new HashMap<>();
        categoryNames.put(R.id.btn_category1,"Fancy Mehandi Designs");
        categoryNames.put(R.id.btn_category2,"Bridal Mehandi Designs");
        categoryNames.put(R.id.btn_category3,"Indian Mehandi Designs");
        categoryNames.put(R.id.btn_category4,"Hand Mehandi Designs");
//        categoryNames.put(R.id.btn_category5,"Rubber Bracelet Designs");
//        categoryNames.put(R.id.btn_category6,"Simple Bracelet Designs");
//        categoryNames.put(R.id.btn_category7,"Women Necklace Designs");
//        categoryNames.put(R.id.btn_category8,"Women Necklace Designs");
        categoryIds = new HashMap<>();
        categoryIds.put(R.id.btn_category1,CategoryEnum.FANCY.getValue());
        categoryIds.put(R.id.btn_category2,CategoryEnum.BRIDAL.getValue());
        categoryIds.put(R.id.btn_category3,CategoryEnum.INDIAN.getValue());
        categoryIds.put(R.id.btn_category4,CategoryEnum.HAND.getValue());
//        categoryIds.put(R.id.btn_category5,CategoryEnum.RUBBER.getValue());
//        categoryIds.put(R.id.btn_category6,CategoryEnum.SIMPLE.getValue());
//        categoryIds.put(R.id.btn_category7,CategoryEnum.BEAUTIFUL.getValue());
//        categoryIds.put(R.id.btn_category8,CategoryEnum.BEAUTIFUL.getValue());
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
        intent.putExtra(Constants.DATA, categoryIds.get(id));
        startActivity(intent);
    }
}
