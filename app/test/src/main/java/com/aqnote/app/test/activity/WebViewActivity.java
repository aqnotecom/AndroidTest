package com.aqnote.app.test.activity;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aqnote.app.test.R;
import com.aqnote.app.test.webview.AQWebChromeClient;
import com.aqnote.app.test.webview.AQWebViewClient;

/**
 * webView使用
 *
 * @author "Peng Li"<aqnote@aqnote.com>
 */
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


        requestPermission();
        // load context
        webView.loadUrl(inputURL.getText().toString());

    }

    private void initInputURL() {
        inputURL = (EditText) findViewById(R.id.webview_url);
        inputURL.setText("http://10.0.2.2:8080/cookie.html");
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
//            cookieManager.removeAllCookies(null);
//            cookieManager.removeSessionCookies(null);
            cookieManager.setCookie("10.0.2.2", "sid=001; Domain=10.0.2.2; Path=/; HttpOnly");
            cookieManager.setCookie("10.0.2.2", "cookie2=002; Domain=10.0.2.2; Path=/");
            cookieManager.flush();
            Log.i("yudao", cookieManager.getCookie("10.0.2.2"));
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

    /**
     * 请求授权
     */
    private void requestPermission() {


        String permission = Manifest.permission.CAMERA;
        int pid = android.os.Process.myPid();
        int uid = android.os.Process.myUid();
        int result = WebViewActivity.this.checkPermission(permission, pid, uid);
        if (result != PackageManager.PERMISSION_GRANTED) { //表示未授权时
            //进行授权
            WebViewActivity.this.requestPermissions(new String[]{permission},1);
        }else{
            webView.loadUrl(inputURL.getText().toString());
        }
    }

    /**
     * 权限申请返回结果
     * @param requestCode 请求码
     * @param permissions 权限数组
     * @param grantResults  申请结果数组，里面都是int类型的数
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){ //同意权限申请
                    webView.loadUrl(inputURL.getText().toString());
                }else { //拒绝权限申请
                    Toast.makeText(this,"权限被拒绝了", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
