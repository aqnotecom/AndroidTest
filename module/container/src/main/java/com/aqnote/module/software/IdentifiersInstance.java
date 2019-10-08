package com.aqnote.module.software;

import android.os.Build;

public class IdentifiersInstance {

    public static String getUniqueID() {
        String m_szDevIDShort = "35" + //we make this look like a valid IMEI
                Build.BOARD.length()%10+ Build.BRAND.length()%10 +
                Build.CPU_ABI.length()%10 + Build.DEVICE.length()%10 +
                Build.DISPLAY.length()%10 + Build.HOST.length()%10 +
                Build.ID.length()%10 + Build.MANUFACTURER.length()%10 +
                Build.MODEL.length()%10 + Build.PRODUCT.length()%10 +
                Build.TAGS.length()%10 + Build.TYPE.length()%10 +
                Build.USER.length()%10 ; //13 digits

        return m_szDevIDShort;
    }

    public static String getBuildInfo() {
        StringBuilder result = new StringBuilder();
        result.append("Build.SERIAL=").append(Build.SERIAL).append("\n")
                .append("Build.BOARD=").append(Build.BOARD).append("\n")
                .append("Build.BRAND=").append(Build.BRAND).append("\n")
                .append("Build.CPU_ABI=").append(Build.CPU_ABI).append("\n")
                .append("Build.DEVICE=").append(Build.DEVICE).append("\n")
                .append("Build.DISPLAY=").append(Build.DISPLAY).append("\n")
                .append("Build.HOST=").append(Build.HOST).append("\n")
                .append("Build.ID=").append(Build.ID).append("\n")
                .append("Build.MANUFACTURER=").append(Build.MANUFACTURER).append("\n")
                .append("Build.MODEL=").append(Build.MODEL).append("\n")
                .append("Build.PRODUCT=").append(Build.PRODUCT).append("\n")
                .append("Build.TAGS=").append(Build.TAGS).append("\n")
                .append("Build.TYPE=").append(Build.TYPE).append("\n")
                .append("Build.USER=").append(Build.USER);

        return result.toString();
    }

    public static String getSerial() {
        String result = Build.getSerial();
        return result;
    }
}
