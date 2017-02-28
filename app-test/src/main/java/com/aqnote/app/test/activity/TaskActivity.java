package com.aqnote.app.test.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.aqnote.app.test.util.AssertUtil;

/**
 * Created by madding on 6/30/16.
 */
public class TaskActivity extends Activity {

    private static final String TAG = TaskActivity.class.getSimpleName();
    private static final String _ACTIVITY = "_activity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");

        this.setTitle(TAG);

        LinearLayout layout = new LinearLayout(TaskActivity.this);
        layout.setHorizontalGravity(Gravity.FILL_HORIZONTAL);
        layout.setVerticalGravity(Gravity.FILL_VERTICAL);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        Button btn1 = new Button(TaskActivity.this);
        btn1.setText("cleaTop");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTopActivity();
            }
        });
        layout.addView(btn1, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        Button btn2 = new Button(TaskActivity.this);
        btn2.setText("newTask");
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newTaskActivity();
            }
        });
        layout.addView(btn2, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        this.setContentView(layout);

        AssertUtil.getAssetFileINode("id.png", this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String activityClassString = data.getStringExtra(_ACTIVITY);
        if(activityClassString == null || "".equalsIgnoreCase(activityClassString)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(activityClassString);
        intent.putExtra(_ACTIVITY, activityClassString);
        this.startActivityForResult(intent, requestCode);
    }

    private void clearTopActivity() {
        Intent intent = new Intent("com.aqnote.app.test.activity.task.DisplayActivity");
        Bundle bundle = new Bundle();
        bundle.putString("action", "Intent.FLAG_ACTIVITY_CLEAR_TOP");
        intent.putExtras(bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setData(Uri.parse("aqnote://activity_https"));
        startActivity(intent);
    }

    private void newTaskActivity() {
        Intent intent = new Intent("com.aqnote.app.test.activity.task.DisplayActivity");
        Bundle bundle = new Bundle();
        bundle.putString("action", "Intent.FLAG_ACTIVITY_NEW_TASK");
        intent.putExtras(bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("aqnote://activity_https"));
        startActivity(intent);
    }
}
