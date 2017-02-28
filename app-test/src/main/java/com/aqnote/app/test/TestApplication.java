package com.aqnote.app.test;

import com.aqnote.module.store.cookie.Cookie;
import com.aqnote.module.store.cookie.CookieStore;
import com.aqnote.module.system.AQNoteApplication;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;


/**
 * Created by madding on 12/20/16.
 */

public class TestApplication extends AQNoteApplication {

    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        mRefWatcher = LeakCanary.install(this);

        Cookie cookie = new Cookie();
        cookie.name = "userid";
        cookie.value = "12345";
        cookie.expires = System.currentTimeMillis() + 3600;
        cookie.domain = "http://aqnote.com";
        cookie.secure = false;
        CookieStore.getInstance().addCookie(TestApplication.this, new Cookie[] {cookie});
    }


}
