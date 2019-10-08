package com.aqnote.app.test.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aqnote.module.container.Callbackable;
import com.aqnote.module.container.thread.Executor;
import com.aqnote.module.software.IdentifiersInstance;

/**
 *
 * @author "Peng Li"<aqnote@aqnote.com>
 */
public class IdentifiersActivity extends AQNoteActivity {

    private static final String TAG = IdentifiersActivity.class.getSimpleName();

    private TextView textView;
    private Button serialButton;
    private Button buildInfoButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(IdentifiersActivity.this);
        alayout.addView(textView, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        textView.setVisibility(1);

        serialButton = new Button(IdentifiersActivity.this);
        serialButton.setText("Serial No.");
        alayout.addView(serialButton, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        serialButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                op(1);
            }
        });

        buildInfoButton = new Button(IdentifiersActivity.this);
        buildInfoButton.setText("Build Info");
        alayout.addView(buildInfoButton, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        buildInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op(2);
            }
        });

    }

    public void op(final int opId) {
        Callbackable<String> callback = new Callbackable<String>() {
            @Override
            public void run(String data) {
                Executor.runOnMain(new Render(IdentifiersActivity.this, opId, data));
            }
        };
        Executor.runOnBackgroud(new Action(opId, callback));
    }

    class Render implements Runnable {

        private IdentifiersActivity activity;
        private String data;
        private int opId;

        public Render(IdentifiersActivity activity, int opId, String data) {
            this.activity = activity;
            this.data = data;
            this.opId = opId;
        }

        @Override
        public void run() {
            switch (opId) {
                default:
                    activity.textView.setText(data);
                    break;
            }
        }
    }

    class Action implements Runnable {

        private int opId;
        private Callbackable<String> callback;

        public Action(int opId, Callbackable<String> callback) {
            this.opId = opId;
            this.callback = callback;
        }

        @Override
        public void run() {
            switch (opId) {
                case 1:
                    callback.run(IdentifiersInstance.getSerial());
                    break;
                case 2:
                    callback.run(IdentifiersInstance.getBuildInfo());
            }
        }
    }

}