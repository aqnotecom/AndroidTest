package com.aqnote.app.test.activity;

import android.content.Context;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aqnote.module.container.Callbackable;
import com.aqnote.module.container.thread.Executor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author "Peng Li"<aqnote@aqnote.com>
 */
public class ExternalStorageActivity extends AQNoteActivity {
    private static final String TAG = ExternalStorageActivity.class.getSimpleName();

    protected TextView textView;
    protected Button storeButton;
    protected Button checkButton;
    protected Button deleteButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textView = new TextView(ExternalStorageActivity.this);
        alayout.addView(textView, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        storeButton = new Button(ExternalStorageActivity.this);
        storeButton.setText("storeFile");
        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op(1);
            }
        });
        alayout.addView(storeButton, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        checkButton = new Button(ExternalStorageActivity.this);
        checkButton.setText("checkFile");
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op(2);
            }
        });
        alayout.addView(checkButton, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        deleteButton = new Button(ExternalStorageActivity.this);
        deleteButton.setText("deleteFile");
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op(3);
            }
        });
        alayout.addView(deleteButton, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

    }

    public void op(int op) {
        Callbackable<String> callback = new Callbackable<String>() {
            public void run(final String msg) {
                Executor.runOnMain(new Runnable() {
                    @Override
                    public void run() {
                        StringBuilder sb = new StringBuilder(textView.getText());
                        sb.append(msg).append("\n");
                        ExternalStorageActivity.this.textView.setText(sb.toString());
                    }
                });
            }
        };
        Executor.runOnMain(new Action(ExternalStorageActivity.this, callback, op));
    }

    private class Action  implements Runnable {

        public static final String FILE_1_TXT = "1.txt";

        private Context context;
        private Callbackable<String> callback;
        private int op;

        public Action(Context context, Callbackable<String> callback, int op) {
            this.context = context;
            this.callback = callback;
            this.op = op;
        }

        public void run() {
            switch (op) {
                case 1:
                    storeFile();
                    break;
                case 2:
                    checkFile();
                    break;
                case 3:
                    deleteFile();
                    break;
                default:
                    break;
            }
        }

        private void storeFile() {
            File file = new File(context.getExternalFilesDir(null), FILE_1_TXT);
            try {
                OutputStream os = new FileOutputStream(file);
                os.write("HelloWorld".getBytes("UTF-8"));
                os.close();
                callback.run("write file success");
            } catch (FileNotFoundException e) {
                callback.run(e.getMessage());
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                callback.run(e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                callback.run(e.getMessage());
                e.printStackTrace();
            }
        }

        private void checkFile() {
            File file = new File(context.getExternalFilesDir(null), FILE_1_TXT);
            if (file.exists()) {
                callback.run("has exist file");
            } else {
                callback.run("no exist file");
            }
        }

        private void deleteFile() {
            File file = new File(context.getExternalFilesDir(null), FILE_1_TXT);
            boolean result = file.delete();
            if( result ) {
                callback.run("delete File success");
            } else {
                callback.run("delete File failure");
            }
        }

        private void storePhoto() {

        }

        private void storeVideo() {

        }

        private void storeAudio() {

        }
    }

}


