package com.aqnote.app.test;

import android.app.Application;

import com.aqnote.app.test.cookie.AQCookie;
import com.aqnote.app.test.cookie.AQCookieManager;

/**
 * Created by madding on 12/20/16.
 */

public class AQApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AQCookie cookie = new AQCookie();
        cookie.name = "userid";
        cookie.value = "12345";
        cookie.expires = System.currentTimeMillis() + 3600;
        cookie.domain = "http://aqnote.com";
        cookie.secure = false;
        AQCookieManager.getInstance().addCookie(AQApplication.this, new AQCookie[] {cookie});
    }


}
