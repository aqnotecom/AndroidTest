package com.aqnote.app.test.activity;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.MainThread;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aqnote.module.container.Callbackable;
import com.aqnote.module.container.thread.Executor;
import com.aqnote.module.container.util.IpAddressUtil;
import com.aqnote.module.rpc.util.IOUtil;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author "Peng Li"<aqnote@aqnote.com>
 */
public class AboutActivity extends AQNoteActivity {

    private static final String TAG = AboutActivity.class.getSimpleName();

    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageView = new ImageView(AboutActivity.this);
        alayout.addView(imageView, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        addDownloadJob();
    }

    public void addDownloadJob() {
        Callbackable<Bitmap> callback = new Callbackable<Bitmap>() {
            @Override
            public void run(Bitmap data) {
                Executor.runOnMain(new JobMainRunnable(data));
            }
        };
        Executor.runOnBackgroud(new JobRunnable(callback));
    }

    private class JobMainRunnable implements Runnable {

        private Bitmap data;

        public JobMainRunnable(Bitmap data) {
            this.data = data;
        }

        @Override
        public void run() {
            imageView.setImageBitmap(data);
            imageView.setVisibility(1);
        }
    }

    private class JobRunnable implements Runnable {

        private Callbackable<Bitmap> callback;

        public JobRunnable(Callbackable<Bitmap> callback) {
            this.callback = callback;
        }

        @Override
        public void run() {
            HttpURLConnection con = null;
            try {
                String imageURL = "https://img.alicdn.com/tfs/TB1_uT8a5ERMeJjSspiXXbZLFXa-143-59.png";
                URL url = new URL(imageURL);
                con = (HttpURLConnection) url.openConnection();
                con.setConnectTimeout(5 * 1000);
                con.setReadTimeout(15 * 1000);
                Bitmap bitmap = IOUtil.readImage(con.getInputStream());
                if(callback != null) {
                    callback.run(bitmap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (con != null) {
                    con.disconnect();
                }
            }
        }
    }
}