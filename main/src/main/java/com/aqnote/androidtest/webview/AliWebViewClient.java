package com.aqnote.androidtest.webview;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by madding on 5/26/16.
 */
public class AliWebViewClient  extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }

    @Override
    public void onReceivedSslError (WebView view, SslErrorHandler handler, SslError error) {
        handler.proceed();
    }
}