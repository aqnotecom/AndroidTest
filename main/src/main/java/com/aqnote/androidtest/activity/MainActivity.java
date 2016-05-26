package com.aqnote.androidtest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.aqnote.androidtest.R;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText logET;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        initialize();

//        SSLContext sslContext = null;
//
//        try {
//            sslContext = SSLContext.getInstance("TLS");
//            sslContext.init(null, new TrustManager[]{new AliTrustManager()}, null);
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
    }

    private void initialize() {
        logET = (EditText) this.findViewById(R.id.main_log_textview);
    }

    public void displayAboutActivity(View view) {
        this.startActivity(new Intent(this, AboutActivity.class));
    }

    public void displaySysWebViewActivity(View view) {
        this.startActivity(new Intent(this, SysWebViewActivity.class));
    }

    public void displayUCWebViewActivity(View view) {
        this.startActivity(new Intent(this, UCWebViewActivity.class));
    }

    public void displayLog(View view) {
        logET.setText(view.getClass().getDeclaredClasses().toString());
    }

    public void exit(View view) {
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
