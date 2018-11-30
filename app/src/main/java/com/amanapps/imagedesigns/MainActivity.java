package com.amanapps.imagedesigns;

import android.app.ActivityManager;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.amanapps.imagedesigns.dialog.SimpleDialog;
import com.amanapps.imagedesigns.models.Configuration;
import com.amanapps.imagedesigns.utils.Constants;
import com.amanapps.imagedesigns.utils.PrefUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kobakei.ratethisapp.RateThisApp;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAnalytics mFirebaseAnalytics;
    LinearLayout adContainerTop;
    LinearLayout adContainerBottom;
    private DatabaseReference mDatabase;
//    private InterstitialAd mInterstitialAd;
//    private final int REFRESH_TIME_SECONDS = 1 * 1000;
//    private Handler mHandler;
//    private Runnable mRunnableStart = new Runnable() {
//        @Override
//        public void run() {
//            try {
//                mHandler.removeCallbacks(mRunnableStart);
//                if (mInterstitialAd.isLoaded()) {
//                    mInterstitialAd.show();
//                } else {
//                    if (AppUtils.isInternetAvailable(getApplicationContext()))
//                        mHandler.postDelayed(mRunnableStart, REFRESH_TIME_SECONDS);
//                }
//            } catch (Exception e) {
//            }
//
//        }
//    };
    CardView share_app_card;
    CardView rate_app_card;
    CardView more_apps_card;
    CardView about_us_card;
    CardView more_prods_card;
    ImageView copyrights;
    CardView designs_card;
    SimpleDialog mSimpleDialog;
    Configuration mConfiguration;
    ValueEventListener valueEventListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mConfiguration = dataSnapshot.getValue(Configuration.class);
                setupAds();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDatabase.child("ringdesigns").addValueEventListener(valueEventListener);
        designs_card = (CardView) findViewById(R.id.designs);
        share_app_card = (CardView) findViewById(R.id.share_app);
        more_apps_card = (CardView) findViewById(R.id.more_apps);
        more_prods_card = (CardView) findViewById(R.id.more_prods);
        rate_app_card = (CardView) findViewById(R.id.rate_app);
        about_us_card = (CardView) findViewById(R.id.about_us);
        copyrights = (ImageView) findViewById(R.id.imageView7);
        designs_card.setOnClickListener(this);
        share_app_card.setOnClickListener(this);
        more_apps_card.setOnClickListener(this);
//        quiz_app_card.setOnClickListener(this);
        rate_app_card.setOnClickListener(this);
        about_us_card.setOnClickListener(this);
        copyrights.setOnClickListener(this);
        initFresco();
        RateThisApp.onCreate(this);
        // If the condition is satisfied, "Rate this app" dialog will be shown
        RateThisApp.Config config = new RateThisApp.Config(2, 2);
        RateThisApp.init(config);
        RateThisApp.showRateDialogIfNeeded(this);
        if(!PrefUtils.getBoolean(this, Constants.FIRST_RUN,false)){
            showDisclaimer();
            PrefUtils.persistBoolean(this,Constants.FIRST_RUN,true);
        }
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "MainActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
//        mInterstitialAd = new InterstitialAd(this);
//        mInterstitialAd.setAdUnitId(getString(R.string.admob_interstitial));
//        mHandler = new Handler();
//        mInterstitialAd.loadAd(new AdRequest.Builder().build());
//        mHandler.postDelayed(mRunnableStart, 2000);
    }
    public void setupAds(){
        MobileAds.initialize(this, mConfiguration.admob_app_id);
        adContainerTop = (LinearLayout) findViewById(R.id.ad_container_top);
        adContainerBottom = (LinearLayout) findViewById(R.id.ad_container_bottom);
        ViewGroup.LayoutParams wrapParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final AdView adViewTop,adViewBottom;
        adViewTop = new AdView(this);
        adViewBottom = new AdView(this);

        adViewTop.setLayoutParams(wrapParams);
        adViewTop.setAdUnitId(mConfiguration.admob_banner_id);
        adViewTop.setAdSize(AdSize.LARGE_BANNER);
        adViewTop.setVisibility(View.GONE);

        adViewBottom.setLayoutParams(wrapParams);
        adViewBottom.setAdUnitId(mConfiguration.admob_banner_id);
        adViewBottom.setAdSize(AdSize.BANNER);
        adViewBottom.setVisibility(View.GONE);

        AdRequest adRequestTop = new AdRequest.Builder().build();
        AdRequest adRequestBottom = new AdRequest.Builder().build();

        adContainerTop.addView(adViewTop);
        adContainerBottom.addView(adViewBottom);

        adViewTop.loadAd(adRequestTop);
        adViewBottom.loadAd(adRequestBottom);
        adViewTop.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                adViewTop.setVisibility(View.VISIBLE);
            }
        });
        adViewBottom.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                adViewBottom.setVisibility(View.VISIBLE);
            }
        });
    }
    private void initFresco() {
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig
                .newBuilder(getApplicationContext())
                .setBitmapMemoryCacheParamsSupplier(new LollipopBitmapMemoryCacheParamsSupplier(activityManager))
                .build();

        Fresco.initialize(getApplicationContext(), imagePipelineConfig);
    }
    public void showDisclaimer(){
        showSimpleDialog("Disclaimer",getString(R.string.disclaimer));
    }

    private void showSimpleDialog(String title, String content) {
        mSimpleDialog = new SimpleDialog(this, title, content,null,"Ok"
                , new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_positive:
                        mSimpleDialog.dismiss();
                        break;
                    case R.id.button_negative:
                        mSimpleDialog.dismiss();
                        break;
                }
            }
        });
        mSimpleDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mInterstitialAd.loadAd(new AdRequest.Builder().build());
//        mHandler.postDelayed(mRunnableStart, 1000);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDatabase.child("ringdesigns").removeEventListener(valueEventListener);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.more_apps:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://search?q=pub:Mob Studios")));
                } catch (android.content.ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/search?q=pub:Mob Studios")));
                }
                break;
            case R.id.imageView7:
                showDisclaimer();
                break;
            case R.id.rate_app:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + this.getPackageName())));
                } catch (android.content.ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
                }
                break;
            case R.id.about_us:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + "com.appinspire.fingermehandidesigns")));
                } catch (android.content.ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + "com.appinspire.fingermehandidesigns")));
                }
                break;
            case R.id.share_app:
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
                    String sAux = "\nLet me recommend you this application\n\n";
                    sAux = sAux + "https://play.google.com/store/apps/details?id="+this.getPackageName()+"\n\n";
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "Choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
                break;
            case R.id.designs:
                startActivity(new Intent(this,ImagesActivity.class));
                break;
        }

    }
}
