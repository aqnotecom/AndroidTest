package com.aqnote.androidtest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.aqnote.androidtest.R;

public class AboutActivity extends Activity {

    private static final String TAG = AboutActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setTitle("Abdout Activity");
        setContentView(R.layout.activity_about);
    }
}