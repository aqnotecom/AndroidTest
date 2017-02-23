package com.aqnote.module.account.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.aqnote.module.account.Authenticator;

/**
 * Created with IntelliJ IDEA.
 * User: Udini
 * Date: 19/03/13
 * Time: 19:10
 */
public class AuthenticatorService extends Service {
    @Override
    public IBinder onBind(Intent intent) {

        Authenticator authenticator = new Authenticator(this);
        return authenticator.getIBinder();
    }
}
