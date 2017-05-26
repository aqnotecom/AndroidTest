package com.aqnote.module.container.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 *
 * @author "Peng Li"<aqnote.com@gmail.com>
 */
class AQHostnameVerifier implements HostnameVerifier {

    private AQHostnameVerifier() {
    }

    public boolean verify(String var1, SSLSession var2) {
        return false;
    }
}