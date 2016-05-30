package com.aqnote.androidtest.webview;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by madding on 5/26/16.
 */
public class AliWebViewClient  extends WebViewClient {

    private static final String TAG = AliWebViewClient.class.getSimpleName();

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }

    @Override
    public void onReceivedSslError (WebView view, SslErrorHandler handler, SslError error) {
        Log.e(TAG, error.toString());
        handler.proceed();
    }
}