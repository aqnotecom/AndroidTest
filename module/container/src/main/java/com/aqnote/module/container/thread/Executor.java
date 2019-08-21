package com.aqnote.module.container.thread;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.concurrent.Executors;

/**
 * Created by "Peng Li"<aqnote@aqnote.com> on 11/29/17.
 */

public class Executor {
    private static java.util.concurrent.Executor executor = Executors.newCachedThreadPool();
    private static Handler                       mHandler = new Handler(Looper.getMainLooper());

    public static void runOnBackgroud(Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            Log.e("com.aqnote.Executor", "Executor.runOnBackgroud failed.", e);
            e.printStackTrace();
        }
    }

    public static void runOnMain(Runnable runnable) {
        try {
            mHandler.post(runnable);
        } catch (Exception e) {
            Log.e("com.aqnote.Executor", "Executor.runOnMain failed.", e);
            e.printStackTrace();
        }
    }
}
