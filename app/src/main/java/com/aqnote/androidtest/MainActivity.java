package com.aqnote.androidtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText      logET;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        logET = (EditText) this.findViewById(R.id.android_log_et);
    }

    public void displayAboutActivity(View view) {
        this.startActivity(new Intent(this, AboutActivity.class));
    }

    public void displayTestActivity(View view) {
        this.startActivity(new Intent(this, TestActivity.class));
    }

    public void displayLog(View view) {
        logET.setText(view.getClass().getDeclaredClasses().toString());
    }

    public void exit(View view) {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
