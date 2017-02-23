package com.aqnote.app.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aqnote.app.test.R;
import com.aqnote.app.test.util.IpAddressUtil;

public class AboutActivity extends Activity {

    private static final String TAG = AboutActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setTitle(TAG);

        LinearLayout layout = new LinearLayout(AboutActivity.this);
        layout.setHorizontalGravity(Gravity.FILL_HORIZONTAL);
        layout.setVerticalGravity(Gravity.FILL_VERTICAL);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        TextView textView = new TextView(AboutActivity.this);
        StringBuilder sb = new StringBuilder();
        sb.append("ip address: ").append(IpAddressUtil.getIPAddress(true)).append("\n");
        sb.append("mac address: ").append(IpAddressUtil.getMACAddress("eth0")).append("\n");
        textView.setText(sb.toString());

        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.addView(textView, textViewParams);


    }
}