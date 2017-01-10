package com.aqnote.app.test.cookie;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by madding on 12/20/16.
 */

public class AQCookie {

    public String  domain;
    public String  path;
    public String  name;
    public String  value;
    public long    expires;
    public boolean secure;
    public boolean httpOnly;

    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(name).append("=").append(value).append("; ");
        builder.append("Domain=").append(domain).append("; ");

        if ( expires > 0) {
            builder.append("Expires=");

            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
            DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            String temp = DATE_FORMAT.format(expires);
            builder.append(temp);
            builder.append("; ");
        }
        builder.append("Path=").append(path);

        if (secure) {
            builder.append("; ");
            builder.append("Secure");
        }

        if (httpOnly) {
            builder.append("; ");
            builder.append("HttpOnly");
        }

        return builder.toString();
    }

}
