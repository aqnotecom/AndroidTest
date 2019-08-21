package com.aqnote.module.container.util;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;

/**
 * Created by "Peng Li"<aqnote@aqnote.com> on 5/26/17.
 */

public class PermissionUtil {


    public static boolean checkPermission(Activity activity, String permission, int target) {
        boolean result = false;
        // 是否有权限
        if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
            // 为什么需要权限
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                Toast.makeText(activity, "使用该功能需要你打开对应权限", Toast.LENGTH_LONG).show();
            }
            // 要求具体权限
            ActivityCompat.requestPermissions(activity, new String[]{permission}, target);
        } else {
            result = true;
        }
        return result;
    }

    public static boolean onRequestPermissionsResult(int requestCode, int[] grantResults, int target, Activity activity) {
        boolean result = false;
        if (requestCode != target) return result;

        if (grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            result = true;
        } else {
            Toast.makeText(activity, "你拒绝了授权，业务无法访问", Toast.LENGTH_LONG).show();
        }
        return result;
    }
}
