package com.appinspire.imagedesigns;

import android.app.ActivityManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.appinspire.imagedesigns.dialog.SimpleDialog;
import com.appinspire.imagedesigns.utils.Constants;
import com.appinspire.imagedesigns.utils.PrefUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kobakei.ratethisapp.RateThisApp;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAnalytics mFirebaseAnalytics;
    AdView mAdView;
    AdView mAdView2;
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
    CardView share_app_card;
    CardView rate_app_card;
    CardView more_apps_card;
    CardView quiz_app_card;
    CardView about_us_card;
    CardView more_prods_card;
    ImageView copyrights;
    CardView designs_card;
    SimpleDialog mSimpleDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, getString(R.string.admob_app_id));
        mAdView = (AdView) findViewById(R.id.adView_main);
        mAdView2 = (AdView) findViewById(R.id.adView_main2);
        mAdView.setVisibility(View.GONE);
        mAdView2.setVisibility(View.VISIBLE);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
            }
        });
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest2);
        designs_card = (CardView) findViewById(R.id.designs);
        share_app_card = (CardView) findViewById(R.id.share_app);
        more_apps_card = (CardView) findViewById(R.id.more_apps);
        quiz_app_card = (CardView) findViewById(R.id.quiz_app);
        more_prods_card = (CardView) findViewById(R.id.more_prods);
        rate_app_card = (CardView) findViewById(R.id.rate_app);
        about_us_card = (CardView) findViewById(R.id.about_us);
        copyrights = (ImageView) findViewById(R.id.imageView7);
        designs_card.setOnClickListener(this);
        share_app_card.setOnClickListener(this);
        more_apps_card.setOnClickListener(this);
//        quiz_app_card.setOnClickListener(this);
        quiz_app_card.setVisibility(View.GONE);
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
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.admob_interstitial));
        mHandler = new Handler();
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mHandler.postDelayed(mRunnableStart, 2000);
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
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mHandler.postDelayed(mRunnableStart, 1000);

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
//                startActivity(new Intent(this,TutorialActivity.class));
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + "com.appinspire.fingermehandidesigns")));
                } catch (android.content.ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + "com.appinspire.fingermehandidesigns")));
                }
                break;
            case R.id.quiz_app:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + "com.fuzzylogics.guess.the.flag.quiz")));
                } catch (android.content.ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + "com.fuzzylogics.guess.the.flag.quiz")));
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
