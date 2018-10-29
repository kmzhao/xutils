package com.anky.xutils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import java.lang.reflect.InvocationTargetException;

/**
 * @author: Anky
 * @time: 2018
 * @desc:
 */

public final class UtilsManager {

    @SuppressLint("StaticFieldLeak")
    private static Application mApplication;


    private UtilsManager() {
        throw new UnsupportedOperationException("sorry, can't instantiate me.");
    }

    /**
     * init in al
     * @param context
     */
    public static void init(@NonNull final Context context) {
        init((Application) context.getApplicationContext());
    }

    public static void init(@NonNull final Application app) {
        if (mApplication == null) {
            UtilsManager.mApplication = app;
        }
    }

    public static Application getApp() {
        if (mApplication != null) return mApplication;
        try {
            @SuppressLint("PrivateApi")
            Class<?> activityThread = Class.forName("android.app.ActivityThread");
            Object at = activityThread.getMethod("currentActivityThread").invoke(null);
            Object app = activityThread.getMethod("getApplication").invoke(at);
            if (app == null) {
                throw new NullPointerException("u should init first");
            }
            init((Application) app);
            return mApplication;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new NullPointerException("u must invoke to init() first");
    }


}
