package com.aqnote.androidtest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.aqnote.androidtest.webview.AliWebViewClient;
import com.aqnote.androidtest.R;

public class SysWebViewActivity extends Activity {

    private static final String TAG = SysWebViewActivity.class.getSimpleName();

    private ViewGroup   webViewLayout;
    private EditText    inputURL;
    private Button      go;
    private WebView     webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("SysWebView Activity");
        setContentView(R.layout.activity_syswebview);

        webViewLayout = (ViewGroup)findViewById(R.id.webview_container);

        initInputURL();
        initGoButton();
        initWebView();

        addGoButtonListener();

        // load context
        webView.loadUrl(inputURL.getText().toString());

    }

    private void initInputURL() {
        inputURL = (EditText)findViewById(R.id.webview_url);
        inputURL.setText("https://login.daily.taobao.net/member/login.jhtml");
    }

    private void initGoButton() {
        go = (Button)findViewById(R.id.webview_go);
    }

    private void initWebView() {
        webView = (WebView) this.findViewById(R.id.webview_default);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(false);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        webView.setWebViewClient(new AliWebViewClient());
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
