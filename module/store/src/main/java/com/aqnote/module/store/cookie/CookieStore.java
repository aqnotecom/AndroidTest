package com.aqnote.module.store.cookie;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;

/**
 * Created by "Peng Li"<aqnote@aqnote.com> on 12/20/16.
 */

public class CookieStore {

    public static CookieStore cookieStore = null;

    public static CookieStore getInstance() {
        if(cookieStore == null) {
            cookieStore = new CookieStore();
        }
        return cookieStore;
    }

    private CookieStore() { }

    public void addCookie(Context context, Cookie[] cookies) {

        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        for(Cookie cookie : cookies) {
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
                System.out.println("[aqnote] remove cookie result=" + value);
            }
        };

        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.removeSessionCookies(callback);
        cookieManager.removeAllCookies(callback);
        cookieManager.flush();
    }




}
