package com.aqnote.app.test.activity;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;

import com.aqnote.app.test.R;
import com.aqnote.module.rpc.http.Api;
import com.aqnote.module.rpc.http.AuthenticationParameters;
import com.aqnote.module.rpc.util.IOUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 *
 * 模拟请求https接口页面
 *
 * @author "Peng Li"<aqnote@aqnote.com>
 */
public class HttpsActivity extends Activity {
    private static final String TAG = HttpsActivity.class.getSimpleName();

    private Api exampleApi;

    TextView   mainTextView;
    ScrollView mainTextScroller;

    String caCertificateName         = "master-cacert.pem";
    String clientCertificateName     = "client-cert.p12";
    String clientCertificatePassword = "chariot";
    String exampleUrl                = "https://www.aqnote.com";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_https);
        mainTextView = (TextView) this.findViewById(R.id.mainTextView);
        mainTextScroller = (ScrollView) this.findViewById(R.id.mainTextScroller);
    }


    @Override
    protected void onResume() {
        super.onResume();

        doRequest();
    }

    private void updateOutput(String text) {
        mainTextView.setText(mainTextView.getText() + "\n\n" + text);
    }

    private void doRequest() {

        try {
            AuthenticationParameters authParams = new AuthenticationParameters();
            authParams.setClientCertificate(getClientCertFile());
            authParams.setClientCertificatePassword(clientCertificatePassword);
            authParams.setCaCertificate(readCaCert());

            exampleApi = new Api(authParams);
            updateOutput("Connecting to " + exampleUrl);

            new AsyncTask() {
                @Override
                protected Object doInBackground(Object... objects) {

                    try {
                        String result = exampleApi.doGet(exampleUrl);
                        int responseCode = exampleApi.getLastResponseCode();
                        if (responseCode == 200) {
                            publishProgress(result);
                        } else {
                            publishProgress("HTTP Response Code: " + responseCode);
                        }

                    } catch (Throwable ex) {
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        PrintWriter writer = new PrintWriter(baos);
                        ex.printStackTrace(writer);
                        writer.flush();
                        writer.close();
                        publishProgress(ex.toString() + " : " + baos.toString());
                    }

                    return null;
                }

                @Override
                protected void onProgressUpdate(final Object... values) {
                    StringBuilder buf = new StringBuilder();
                    for (final Object value : values) {
                        buf.append(value.toString());
                    }
                    updateOutput(buf.toString());
                }

                @Override
                protected void onPostExecute(final Object result) {
                    updateOutput("Done!");
                }
            }.execute();

        } catch (Exception ex) {
            Log.e(TAG, "failed to create timeApi", ex);
            updateOutput(ex.toString());
        }
    }

    private File getClientCertFile() {
//        File externalStorageDir = Environment.getExternalStorageDirectory();
//        return new File(externalStorageDir, clientCertificateName);
        return null;
    }

    private String readCaCert() throws Exception {
        AssetManager assetManager = getAssets();
        InputStream inputStream = assetManager.open(caCertificateName);
        return IOUtil.readFully(inputStream);
    }
}
