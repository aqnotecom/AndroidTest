package com.aqnote.androidtest;

import android.app.Activity;
import android.os.Bundle;

public class WebViewActivity extends Activity {

    private static final String TAG = WebViewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
    }
}
