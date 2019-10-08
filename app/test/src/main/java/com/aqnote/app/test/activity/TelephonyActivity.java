package com.aqnote.app.test.activity;

import android.Manifest;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aqnote.module.container.Callbackable;
import com.aqnote.module.hardware.cellular.SimStateReceiver;
import com.aqnote.module.hardware.cellular.CellularInstance;
import com.aqnote.module.container.util.PermissionUtil;

/**
 * Created by "Peng Li"<aqnote@aqnote.com> on 5/25/17.
 * <p>
 * 获取电话信息例子
 *
 * @author "Peng Li"<aqnote@aqnote.com>
 */
public class TelephonyActivity extends AQNoteActivity {

    private static final String TAG = TelephonyActivity.class.getSimpleName();

    private final static String ACTION_SIM_STATE_CHANGED = "android.intent.action.SIM_STATE_CHANGED";


    private IntentFilter     mIntentFilter;
    private SimStateReceiver mSimStateReceiver;
    private Callbackable     mSimStateCallbackable;

    private TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // java.lang.SecurityException: getDeviceId: The user 10181 does not meet the requirements to access device identifiers.
        boolean hasPermission = PermissionUtil.checkPermission(this, Manifest.permission.READ_PHONE_STATE, CellularInstance.PERMISSION_READ_PHONE_STATE);
        if (!hasPermission) {
            this.finish();
            return;
        }

        mTextView = new TextView(TelephonyActivity.this);
        alayout.addView(mTextView, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        addBroadcastReceiver();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(mSimStateReceiver);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        PermissionUtil.onRequestPermissionsResult(requestCode, grantResults, CellularInstance.PERMISSION_READ_PHONE_STATE, this);
    }

    private void addBroadcastReceiver() {
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(ACTION_SIM_STATE_CHANGED);

        mSimStateCallbackable = new Callbackable() {
            @Override
            public void run(Object obj) {
                String info = CellularInstance.getInstance(TelephonyActivity.this).getCellularInfo();
                mTextView.setText(info);
            }
        };
        mSimStateReceiver = new SimStateReceiver(mSimStateCallbackable);
        this.registerReceiver(mSimStateReceiver, mIntentFilter);
    }


}
