package com.anky.xutils;

import android.app.Application;

/**
 * @author: Anky
 * @time: 2018
 * @desc:
 */

public class BaseApp extends Application {
    private static BaseApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static BaseApp getInstance() {
        return mInstance;
    }
}
