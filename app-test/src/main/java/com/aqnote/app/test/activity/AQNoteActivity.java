package com.aqnote.app.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;

/**
 * Created by aqnote on 5/25/17.
 *
 * activity基础页面
 *
 * @author "Peng Li"<aqnote.com@gmail.com>
 */
public class AQNoteActivity extends Activity {

    private static final String TAG = AQNoteActivity.class.getSimpleName();

    protected LinearLayout alayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setTitle(TAG);

        alayout = new LinearLayout(this);
        alayout.setHorizontalGravity(Gravity.FILL_HORIZONTAL);
        alayout.setVerticalGravity(Gravity.FILL_VERTICAL);
        alayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(alayout);

    }

}
