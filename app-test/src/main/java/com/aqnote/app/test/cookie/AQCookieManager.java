package com.aqnote.app.test.cookie;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;

/**
 * Created by madding on 12/20/16.
 */

public class AQCookieManager {

    public static AQCookieManager aqCookieManager = null;

    public static AQCookieManager getInstance() {
        if(aqCookieManager == null) {
            aqCookieManager = new AQCookieManager();
        }

        return aqCookieManager;
    }

    private AQCookieManager() {
    }

    public void addCookie(Context context, AQCookie[] cookies) {

        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        for(AQCookie cookie : cookies) {
            cookieManager.setCookie(cookie.domain, cookie.toString());
        }
        cookieManager.flush();
    }

    public void clearCookieForDomain(Context context, String domain) {

        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        String cookies = cookieManager.getCookie(domain);
        if (cookies == null) {
            return;
        }

        String[] splitCookies = cookies.split(";");
        for (String cookie : splitCookies) {
            String[] cookieParts = cookie.split("=");
            if (cookieParts.length > 0) {
                String newCookie = cookieParts[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;";
                cookieManager.setCookie(domain, newCookie);
            }
        }
        cookieManager.flush();
    }

    public void clearAllCookies() {

        ValueCallback<Boolean> callback = new ValueCallback<Boolean>() {
            public void onReceiveValue(Boolean value) {
                System.out.println("[madding] remove cookie result=" + value);
            }
        };

        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.removeSessionCookies(callback);
        cookieManager.removeAllCookies(callback);
        cookieManager.flush();
    }




}
