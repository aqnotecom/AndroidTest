package com.aqnote.app.test.activity;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aqnote.module.container.Callbackable;
import com.aqnote.module.container.thread.Executor;
import com.aqnote.module.container.util.IpAddressUtil;
import com.aqnote.module.rpc.util.IOUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author "Peng Li"<aqnote.com@gmail.com>
 */
public class AboutActivity extends AQNoteActivity {

    private static final String TAG = AboutActivity.class.getSimpleName();

    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(AboutActivity.this);
        StringBuilder sb = new StringBuilder();
        sb.append("ip address: ").append(IpAddressUtil.getIPAddress(true)).append("\n");
        sb.append("mac address: ").append(IpAddressUtil.getMACAddress("eth0")).append("\n");
        textView.setText(sb.toString());
        alayout.addView(textView, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        imageView = new ImageView(AboutActivity.this);
        alayout.addView(imageView, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        Callbackable<Bitmap> job2Callback = new Callbackable<Bitmap>() {
            @Override
            public void run(Bitmap data) {
                Executor.runOnMain(new Job1(data));
            }
        };
        Executor.runOnBackgroud(new Job2(job2Callback));

    }

    private class Job1 implements Runnable {

        private Bitmap data;

        public Job1(Bitmap data) {
            this.data = data;
        }

        @Override
        public void run() {
            imageView.setImageBitmap(data);
            imageView.setVisibility(1);
        }
    }

    private class Job2 implements Runnable {

        private Callbackable<Bitmap> callback;

        public Job2(Callbackable<Bitmap> callback) {
            this.callback = callback;
        }

        @Override
        public void run() {
            HttpURLConnection con = null;
            try {
                String imageURL = "http://oss.aliyuncs.com/aliyun_id_photo_bucket/account-console-aliyun-com/yone_wy_alibaba_inc_com151183563573823401.jpeg";
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