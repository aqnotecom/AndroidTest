package com.aqnote.app.test.activity.task;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.aqnote.app.test.R;

/**
 * Created by madding on 6/30/16.
 */
public class ClearTopActivity extends Activity {
    private static final String TAG = ClearTopActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setTitle(TAG);
        setContentView(R.layout.activity_task_clean_top);
    }
}
