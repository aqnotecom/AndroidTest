package com.aqnote.app.test.ssl;

import android.util.Log;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by madding on 5/26/16.
 */
public class AQTrustManager implements X509TrustManager {

    private static final String LOG_TAG = AQTrustManager.class.getSimpleName();

    private final SSLContext sslContext;
    private final X509Certificate[] acceptedIssuers;

    public AQTrustManager(SSLContext sslContext, X509Certificate[] acceptedIssuers) {
        this.sslContext = sslContext;
        this.acceptedIssuers = acceptedIssuers;
    }

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
