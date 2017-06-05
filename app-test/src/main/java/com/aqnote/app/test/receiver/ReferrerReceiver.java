package com.aqnote.app.test.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.os.Bundle;

import android.content.IntentFilter;

/**
 * Created by aqnote on 6/5/17.
 *
 * adb shell
 *
 * am broadcast -a com.android.vending.INSTALL_REFERRER -n com.aqnote.app.test/com.aqnote.app.test.receiver.ReferrerReceiver --es "referrer" "http://www.aqnote.com?token=xxxxxxxxx"
 *
 * @author "Peng LI"<aqnote@qq.com>
 */
public class ReferrerReceiver extends BroadcastReceiver {

    private static final String TAG = ReferrerReceiver.class.getSimpleName();

    private static final String ACTION_INSTALL_REFERRER = "com.android.vending.INSTALL_REFERRER";

    @Override
    public void onReceive(Context context, Intent intent)  {
        Bundle extras = intent.getExtras();
        String referrerString = extras.getString("referrer");

        Log.w(TAG, "Referrer is: " + referrerString);
    }

//    static class Util {
//
//        public static final void register(Activity activity) {
//            IntentFilter intentFilter = new IntentFilter();
//            intentFilter.addAction(ACTION_INSTALL_REFERRER);
//            activity.registerReceiver(new ReferrerReceiver(), mIntentFilter);
//        }
//    }
}
