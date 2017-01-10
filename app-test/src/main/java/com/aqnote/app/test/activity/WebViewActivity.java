package com.aqnote.app.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.aqnote.app.test.R;
import com.aqnote.app.test.webview.AQWebChromeClient;
import com.aqnote.app.test.webview.AQWebViewClient;

public class WebViewActivity extends Activity {

    private static final String  TAG    = WebViewActivity.class.getSimpleName();
    private static       boolean v_init = false;

    private ViewGroup webViewLayout;
    private EditText  inputURL;
    private Button    go;
    private WebView   webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TAG);
        setContentView(R.layout.activity_webview);

        webViewLayout = (ViewGroup) findViewById(R.id.webview_container);

        initInputURL();
        initGoButton();
        initWebView();

        addGoButtonListener();

        // load context
        webView.loadUrl(inputURL.getText().toString());

    }

    private void initInputURL() {
        inputURL = (EditText) findViewById(R.id.webview_url);
        inputURL.setText("https://www.aqnote.com");
    }

    private void initGoButton() {
        go = (Button) findViewById(R.id.webview_go);
    }

    private void initWebView() {
        webView = (WebView) this.findViewById(R.id.webview_default);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(false);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");

        webView.setWebViewClient(new AQWebViewClient());

        webView.setWebChromeClient(new AQWebChromeClient());


        if (v_init == false) {
            v_init = true;
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.removeAllCookies(null);
            cookieManager.removeSessionCookies(null);
            cookieManager.setCookie("aqnote.com", "nick=madding; Domain=aqnote.com; Path=/; ");
        }
    }


    private void addGoButtonListener() {
        go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webView.loadUrl(inputURL.getText().toString());
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
