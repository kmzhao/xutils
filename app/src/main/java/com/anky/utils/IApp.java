package com.anky.utils;

import android.annotation.SuppressLint;

import com.anky.xutils.BaseApp;
import com.anky.xutils.CrashUtils;
import com.anky.xutils.LUtils;

/**
 * @author: Anky
 * @time: 2018
 * @desc:
 */

public class IApp extends BaseApp{
    @Override
    public void onCreate() {
        super.onCreate();
        initCrash();
    }


    @SuppressLint("MissingPermission")
    private void initCrash() {
        CrashUtils.init(new CrashUtils.OnCrashListener() {
            @Override
            public void onCrash(String crashInfo, Throwable e) {
                LUtils.e(crashInfo);
            }
        });
    }
}
