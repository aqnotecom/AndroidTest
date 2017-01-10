package com.aqnote.app.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
        setContentView(R.layout.activity_about);

        TextView textView = (TextView) findViewById(R.id.about_info_tv);
        StringBuilder sb = new StringBuilder();
        sb.append("ip address: ").append(IpAddressUtil.getIPAddress(true)).append("\n");
        sb.append("mac address: ").append(IpAddressUtil.getMACAddress("eth0")).append("\n");
        textView.setText(sb.toString());
    }
}