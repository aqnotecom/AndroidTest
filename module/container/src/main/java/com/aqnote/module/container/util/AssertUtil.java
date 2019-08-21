package com.aqnote.module.container.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Build;
import androidx.annotation.RequiresApi;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;

import java.io.FileDescriptor;
import java.io.IOException;

/**
 * Created by "Peng Li"<aqnote@aqnote.com>.lip on 6/21/16.
 *
 * @author "Peng Li"<aqnote@aqnote.com>
 */
public class AssertUtil {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static Long getAssetFileINode(String fileName, Context context) {
        // TODO
        int a = 0;
        AssetManager assetManager = context.getResources().getAssets();
        AssetFileDescriptor assetFd = null;
        try {
            assetFd = assetManager.openFd(fileName);
            FileDescriptor fd = assetFd.getFileDescriptor();
            StructStat structStat = Os.fstat(fd);
            System.out.println(structStat.st_mtime);
            return structStat.st_ino;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ErrnoException e) {
            e.printStackTrace();
        } finally {
            if (assetFd != null) {
                try {
                    assetFd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0L;

    }
}
