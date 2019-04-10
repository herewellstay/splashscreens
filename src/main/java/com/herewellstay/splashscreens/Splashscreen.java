package com.herewellstay.splashscreens;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;

public class Splashscreen extends AppCompatActivity {
    private final int SPLASH_DISPLAY_DURATION = 4000;
    private long start;
    private long finish;
    private long elapsedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        startLoading();
    }

    protected void startLoading() {
        start = SystemClock.currentThreadTimeMillis();
    }

    protected void finishLoading() {
        finish = SystemClock.currentThreadTimeMillis();
        elapsedTime = finish - start;
        if (elapsedTime < getSplashDisplayDuration()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    /* Create an Intent that will start the Menu-Activity. */
                    finishSplash();

                }
            }, getSplashDisplayDuration() - elapsedTime);
        } else {
            finishSplash();
        }
    }

    private void finishSplash() {
        onAfterLoading();
        this.finish();
    }

    protected long getSplashDisplayDuration() {
        return SPLASH_DISPLAY_DURATION;
    }

    protected void onAfterLoading() {

    }


}

