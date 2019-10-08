package com.aqnote.app.test.activity;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aqnote.module.container.Callbackable;
import com.aqnote.module.container.thread.Executor;
import com.aqnote.module.hardware.wifi.WiFiInstance;

public class DeviceActivity extends AQNoteActivity {
    private static final String TAG = DeviceActivity.class.getSimpleName();

    protected TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textView = new TextView(DeviceActivity.this);
        alayout.addView(textView, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        addAndroidID();
        addIpAddress();
        addWifiMacAddress();
        addBluetoothMacAddress();
    }

    public void addAndroidID() {
        Callbackable<String> callback = new Callbackable<String>() {
          public void run(final String androidID) {
                Executor.runOnMain(new Runnable() {
                    @Override
                    public void run() {
                        StringBuilder sb = new StringBuilder(textView.getText());
                        sb.append("Settings.Secure#ANDROID_ID: ").append(androidID).append("\n");
                        DeviceActivity.this.textView.setText(sb.toString());
                    }
                });
            }
        };
        Executor.runOnMain(new Action(DeviceActivity.this, callback));
    }

    public void addIpAddress() {
        String ipAddress = WiFiInstance.getIPAddress(true);
        StringBuilder sb = new StringBuilder(textView.getText());
        sb.append("IP Address: ").append(ipAddress).append("\n");
        textView.setText(sb.toString());
    }

    public void addWifiMacAddress() {
        String macAddress = WiFiInstance.getMACAddress("wlan0");
        StringBuilder sb = new StringBuilder(textView.getText());
        sb.append("MAC Address: ").append(macAddress).append("\n");
        textView.setText(sb.toString());
    }

    public void addBluetoothMacAddress() {

    }

    private class Action implements Runnable {

        private Context context;
        private Callbackable<String> callback;

        public Action(Context context, Callbackable<String> callback) {
            this.context = context;
            this.callback = callback;
        }

        public void run() {
            String androidID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            if(TextUtils.isEmpty(androidID)) {
                androidID = "-1";
            }
            if(callback != null) {
                callback.run(androidID);
            }
        }
    }
}

