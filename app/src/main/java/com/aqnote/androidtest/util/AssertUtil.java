package com.aqnote.androidtest.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import android.system.StructStatVfs;

import java.io.FileDescriptor;
import java.io.IOException;
import java.net.URI;

/**
 * Created by madding.lip on 6/21/16.
 */
public class AssertUtil {

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
            if(assetFd != null) {
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
