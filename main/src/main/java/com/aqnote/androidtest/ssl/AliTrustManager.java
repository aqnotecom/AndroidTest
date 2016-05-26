package com.aqnote.androidtest.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.TrustManager;

/**
 * Created by madding on 5/26/16.
 */
public class AliTrustManager implements TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            try {
                chain[0].checkValidity();
            } catch (Exception e) {
                throw new CertificateException("Certificate not valid or trusted.");
            }
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
}
