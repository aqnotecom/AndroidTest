package com.aqnote.app.test.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aqnote.module.container.util.IpAddressUtil;

/**
 *
 * @author "Peng Li"<aqnote.com@gmail.com>
 */
public class AboutActivity extends AQNoteActivity {

    private static final String TAG = AboutActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(AboutActivity.this);
        StringBuilder sb = new StringBuilder();
        sb.append("ip address: ").append(IpAddressUtil.getIPAddress(true)).append("\n");
        sb.append("mac address: ").append(IpAddressUtil.getMACAddress("eth0")).append("\n");
        textView.setText(sb.toString());
        alayout.addView(textView, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

    }
}