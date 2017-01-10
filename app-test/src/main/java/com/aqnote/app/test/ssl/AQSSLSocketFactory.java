package com.aqnote.app.test.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocketFactory;

class AQSSLSocketFactory extends SSLSocketFactory {

    private final String errMessage;

    AQSSLSocketFactory(String mes) {
        errMessage = mes;
    }

    @Override
    public String[] getDefaultCipherSuites() {
        return new String[]{};
    }

    @Override
    public String[] getSupportedCipherSuites() {
        return new String[]{};
    }

    @Override
    public Socket createSocket(Socket s, String host, int port, boolean autoClose)
            throws IOException {
        throw new SocketException(errMessage);
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        throw new SocketException(errMessage);
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort)
            throws IOException {
        throw new SocketException(errMessage);
    }

    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        throw new SocketException(errMessage);
    }

    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress,
            int localPort) throws IOException {
        throw new SocketException(errMessage);
    }

}