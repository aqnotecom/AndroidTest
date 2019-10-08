package com.aqnote.module.hardware.cellular;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.aqnote.module.container.util.PermissionUtil;

/**
 * Created by "Peng Li"<aqnote@aqnote.com> on 5/25/17.
 * <p>
 * Permission:
 * <p>
 * <!--Phone: 使用和管理电话-->
 * <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
 * <uses-permission android:name="android.permission.CALL_PHONE"/>
 * <uses-permission android:name="android.permission.READ_CALL_LOG"/>
 * <uses-permission android:name="android.permission.WRITE_CALL_LOG"/>
 * <uses-permission android:name="android.permission.USE_SIP"/>
 * <uses-permission android:name="android.permission.ACCESS_UCE_OPTIONS_SERVICE"/>
 * <uses-permission android:name="android.permission.ACCESS_UCE_PRESENCE_SERVICE"/>
 * <uses-permission android:name="android.permission.ACCESS_IMS_CALL_SERVICE"/>
 * <uses-permission android:name="android.permission.PROCESS_OUTGOING_CALLS"/>
 * <uses-permission android:name="com.android.voicemail.permission.ADD_VOICEMAIL"/>
 *
 * @author "Peng Li"<aqnote@aqnote.com>
 */
public class CellularInstance {

    public static final int PERMISSION_READ_PHONE_STATE = 1001;

    private static CellularInstance instance;

    private Activity               activity;
    private TelephonyManager mTelephonyManager;


    public synchronized static CellularInstance getInstance(Activity activity) {
        if (instance == null) {
            instance = new CellularInstance(activity);
            instance.init();
        }
        return instance;
    }

    private CellularInstance(Activity activity) {
        this.activity = activity;
    }

    private void init() {
        if (activity == null) return;
        mTelephonyManager = (TelephonyManager) activity.getSystemService(Context.TELEPHONY_SERVICE);
    }

    public String getCellularInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%1$-20s %2$25s\n", "phoneNumber:", getPhoneNumber()));
        sb.append(String.format("%1$-20s %2$25s\n", "imei:", getIMEI()));
        sb.append(String.format("%1$-20s %2$25s\n", "imsi:", getIMSI()));
        sb.append(String.format("%1$-20s %2$25s\n", "simCountryIso:", getSimCountryIso()));
        sb.append(String.format("%1$-20s %2$25s\n", "simOperator:", getSimOperator()));
        sb.append(String.format("%1$-20s %2$25s\n", "simOperatorName:", getSimOperatorName()));
        sb.append(String.format("%1$-20s %2$25s\n", "simOperatorName2:", getSimOperatorName2()));
        sb.append(String.format("%1$-20s %2$25s\n", "simSerialNumber:", getSimSerialNumber()));
        sb.append(String.format("%1$-20s %2$25d\n", "simState:", getSimState()));
        sb.append(String.format("%1$-20s %2$25s\n", "simStateName:", getSimStateName()));

        return sb.toString();
    }

    public String getPhoneNumber() {
        String result = "";
        boolean hasPermission = PermissionUtil.checkPermission(activity,
                Manifest.permission.READ_PHONE_STATE, PERMISSION_READ_PHONE_STATE);
        if (hasPermission) {
            result = mTelephonyManager.getLine1Number();
        }

        return result;
    }

    public String getIMEI() {
        String result = "";
        boolean hasPermission = PermissionUtil.checkPermission(activity,
                Manifest.permission.READ_PHONE_STATE, PERMISSION_READ_PHONE_STATE);
        if (hasPermission) {
            result = mTelephonyManager.getDeviceId();
        }

        return result;
    }

    public String getIMSI() {
        String result = "";
        boolean hasPermission = PermissionUtil.checkPermission(activity,
                Manifest.permission.READ_PHONE_STATE, PERMISSION_READ_PHONE_STATE);
        if (hasPermission) {
            result = mTelephonyManager.getSubscriberId();
        }
        return result;
    }

    public String getSimCountryIso() {
        String result = "";
        boolean hasPermission = PermissionUtil.checkPermission(activity,
                Manifest.permission.READ_PHONE_STATE, PERMISSION_READ_PHONE_STATE);
        if (hasPermission) {
            result = mTelephonyManager.getSimCountryIso();
        }
        return result;
    }

    public String getSimOperator() {
        String result = "";
        boolean hasPermission = PermissionUtil.checkPermission(activity,
                Manifest.permission.READ_PHONE_STATE, PERMISSION_READ_PHONE_STATE);
        if (hasPermission) {
            result = mTelephonyManager.getSimOperator();
        }
        return result;
    }

    public String getSimOperatorName() {
        String result = "";
        boolean hasPermission = PermissionUtil.checkPermission(activity,
                Manifest.permission.READ_PHONE_STATE, PERMISSION_READ_PHONE_STATE);
        if (hasPermission) {
            result = mTelephonyManager.getSimOperatorName();
        }
        return result;
    }

    public String getSimSerialNumber() {
        String result = "";
        boolean hasPermission = PermissionUtil.checkPermission(activity,
                Manifest.permission.READ_PHONE_STATE, PERMISSION_READ_PHONE_STATE);
        if (hasPermission) {
            result = mTelephonyManager.getSimSerialNumber();
        }
        return result;
    }

    public int getSimState() {
        int result = -1;
        boolean hasPermission = PermissionUtil.checkPermission(activity,
                Manifest.permission.READ_PHONE_STATE, PERMISSION_READ_PHONE_STATE);
        if (hasPermission) {
            result = mTelephonyManager.getSimState();
        }
        return result;
    }

    public String getSimStateName() {
        String result = "API_ERROR";

        int simState = getSimState();
        switch (simState) {
            case 0:
                result = "SIM_STATE_UNKNOWN";
            break;
            case 1:
                // no SIM card is available in the device
                result = "SIM_STATE_ABSENT";
            break;
            case 2:
                // Locked: requires the user's SIM PIN to unlock
                result = "SIM_STATE_PIN_REQUIRED";
            break;
            case 3:
                //  Locked: requires the user's SIM PUK to unlock
                result = "SIM_STATE_PUK_REQUIRED";
            break;
            case 4:
                // Locked: requires a network PIN to unlock
                result = "SIM_STATE_NETWORK_LOCKED";
            break;
            case 5:
                result = "SIM_STATE_READY";
            break;
            case 6:
                // SIM Card is NOT READY
                result = "SIM_STATE_NOT_READY";
            break;
            case 7:
                // SIM Card Error, permanently disabled
                result = "SIM_STATE_PERM_DISABLED";
            break;
            case 8:
                // SIM Card Error, present but faulty
                result = "SIM_STATE_CARD_IO_ERROR";
            break;
            case 9:
                // SIM Card restricted, present but not usable due to carrier restrictions.
                result = "SIM_STATE_CARD_RESTRICTED";
            break;
            default:
                result = "API_ERROR";
            break;
        }
        return result;
    }

    public String getSimOperatorName2() {
        String result = "Unknown";
        String imsi = getIMSI();
        if (TextUtils.isEmpty(imsi)) return result;
        //因为移动网络编号46000下的IMSI已经用完，所以虚拟了一个46002编号，134/159号段使用了此编号
        if (imsi.startsWith("46000") || imsi.startsWith("46002")) {
            //中国移动
            result = "中国移动";
        } else if (imsi.startsWith("46001")) {
            //中国联通
            result = "中国联通";
        } else if (imsi.startsWith("46003")) {
            //中国电信
            result = "中国电信";
        }
        return result;
    }
}
