package com.aqnote.app.test.webview;

import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by "Peng Li"<aqnote@aqnote.com> on 5/26/16.
 *
 * @author "Peng Li"<aqnote@aqnote.com>
 */
public class AQWebViewClient extends WebViewClient {

    private static final String TAG = AQWebViewClient.class.getSimpleName();

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return false;
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        Log.e(TAG, error.toString());
        handler.proceed();
    }
}