package com.aqnote.app.test.activity.task;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by madding on 6/30/16.
 */
public class DisplayActivity extends Activity {
    private static final String TAG = DisplayActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setTitle(TAG);

        LinearLayout layout = new LinearLayout(DisplayActivity.this);
        layout.setHorizontalGravity(Gravity.FILL_HORIZONTAL);
        layout.setVerticalGravity(Gravity.FILL_VERTICAL);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        TextView textView = new TextView(DisplayActivity.this);
        StringBuilder sb = new StringBuilder();
        sb.append(getIntent().getExtras().get("action"));
        textView.setText(sb.toString());
        layout.addView(textView, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
    }
}
