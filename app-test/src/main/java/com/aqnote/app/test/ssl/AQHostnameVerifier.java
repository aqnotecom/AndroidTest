package com.aqnote.app.test.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

class AQHostnameVerifier implements HostnameVerifier {

        private AQHostnameVerifier() {
        }

        public boolean verify(String var1, SSLSession var2) {
            return false;
        }
    }