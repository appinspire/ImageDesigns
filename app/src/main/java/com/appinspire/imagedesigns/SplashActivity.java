package com.appinspire.imagedesigns;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Bilal Rashid on 12/28/2017.
 */

public class SplashActivity extends AppCompatActivity {
    private Handler mHandler;
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            ActivityUtils.startActivity(SplashActivity.this, MainActivity.class, true);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandler = new Handler();
        mHandler.postDelayed(mRunnable, 1000);

    }

    @Override
    public void onBackPressed() {
        if (mHandler != null) {
            mHandler.removeCallbacks(mRunnable);
        }
        super.onBackPressed();
    }

}
