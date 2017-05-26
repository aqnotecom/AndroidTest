package com.aqnote.app.test.activity;

import android.Manifest;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aqnote.module.container.Callbackable;
import com.aqnote.module.telephony.SimStateReceiver;
import com.aqnote.module.telephony.TelephonyManager;
import com.aqnote.module.util.PermissionUtil;

/**
 * Created by aqnote on 5/25/17.
 * <p>
 * 获取电话信息例子
 *
 * @author "Peng Li"<aqnote.com@gmail.com>
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

        boolean hasPermission = PermissionUtil.checkPermission(this, Manifest.permission.READ_PHONE_STATE, TelephonyManager.PERMISSION_READ_PHONE_STATE);
        if (!hasPermission) {
            this.finish();
            return;
        }

        mTextView = new TextView(TelephonyActivity.this);
        alayout.addView(mTextView, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        mTextView.setText(getTelephonyData());

        addBroadcastReceiver();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(mSimStateReceiver);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        PermissionUtil.onRequestPermissionsResult(requestCode, grantResults, TelephonyManager.PERMISSION_READ_PHONE_STATE, this);
    }

    private void addBroadcastReceiver() {
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(ACTION_SIM_STATE_CHANGED);

        mSimStateCallbackable = new Callbackable() {
            @Override
            public void run() {
                mTextView.setText(getTelephonyData());
            }
        };
        mSimStateReceiver = new SimStateReceiver(mSimStateCallbackable);
        this.registerReceiver(mSimStateReceiver, mIntentFilter);
    }

    private TelephonyManager telephony() {
        return TelephonyManager.getInstance(this);
    }

    private String getTelephonyData() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%1$-20s %2$25s\n", "phoneNumber:", telephony().getPhoneNumber()));

        sb.append(String.format("%1$-20s %2$25s\n", "imei:", telephony().getIMEI()));

        sb.append(String.format("%1$-20s %2$25s\n", "imsi:", telephony().getIMSI()));


        sb.append(String.format("%1$-20s %2$25s\n", "simCountryIso:", telephony().getSimCountryIso()));
        sb.append(String.format("%1$-20s %2$25s\n", "simOperator:", telephony().getSimOperator()));
        sb.append(String.format("%1$-20s %2$25s\n", "simOperatorName:", telephony().getSimOperatorName()));
        sb.append(String.format("%1$-20s %2$25s\n", "simOperatorName2:", telephony().getSimOperatorName2()));
        sb.append(String.format("%1$-20s %2$25s\n", "simSerialNumber:", telephony().getSimSerialNumber()));
        sb.append(String.format("%1$-20s %2$25d\n", "simState:", telephony().getSimState()));
        sb.append(String.format("%1$-20s %2$25s\n", "simStateName:", telephony().getSimStateName()));

        return sb.toString();
    }
}
