package com.nick.bsdiff;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * Created by nick on 2017/2/28.
 */

public class ApkUtils {
    public static String extract(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
        String apkPath = applicationInfo.sourceDir;
        return apkPath;
    }

}
