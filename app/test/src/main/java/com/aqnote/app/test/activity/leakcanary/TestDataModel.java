package com.aqnote.app.test.activity.leakcanary;

import android.widget.TextView;

public class TestDataModel {

    private static TestDataModel sInstance;

    public static TestDataModel getInstance() {
        if (sInstance == null) {
            sInstance = new TestDataModel();
        }
        return sInstance;
    }


    private TextView mRetainedTextView;

    public void setRetainedTextView(TextView textView) {
        mRetainedTextView = textView;
    }
}