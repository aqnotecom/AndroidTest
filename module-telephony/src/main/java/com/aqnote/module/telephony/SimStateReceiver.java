package com.aqnote.module.telephony;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.aqnote.module.container.Callbackable;

/**
 * Created by aqnote on 5/26/17.
 *
 * @author "Peng Li"<aqnote.com@gmail.com>
 */

public class SimStateReceiver extends BroadcastReceiver {

    public final static String ACTION_SIM_STATE_CHANGED = "android.intent.action.SIM_STATE_CHANGED";

    private static final String TAG = SimStateReceiver.class.getSimpleName();

    private Callbackable callbackable;

    private SimStateReceiver() {}

    public SimStateReceiver(Callbackable callbackable) {
        this.callbackable = callbackable;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "sim state changed");

        if (TextUtils.equals(intent.getAction(), ACTION_SIM_STATE_CHANGED)) {
            if (callbackable != null) {
                callbackable.run();
            }
        }
    }
}
