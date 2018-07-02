package com.aqnote.app.test.activity.leakcanary;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;


public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(TestActivity.this);
        layout.setHorizontalGravity(Gravity.FILL_HORIZONTAL);
        layout.setVerticalGravity(Gravity.FILL_VERTICAL);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        TextView textView = new TextView(TestActivity.this);
        textView.setText("hello");
        layout.addView(textView, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        TestDataModel.getInstance().setRetainedTextView(textView);
    }
}