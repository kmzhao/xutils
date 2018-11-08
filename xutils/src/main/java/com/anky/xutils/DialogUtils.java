package com.anky.xutils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * @author: Anky
 * @time: 2018
 * @desc:
 */

public class DialogUtils {
    private DialogUtils() {
        throw new UnsupportedOperationException("sorry, can't instantiate me.");
    }


    public static AlertDialog showDialog(Context context,String tiltle,String message){
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(tiltle)
                .setMessage(message)
                .create();
        dialog.show();
        return dialog;
    }

    public static AlertDialog showDialog(Context context, String tiltle, String message,
                                              String ok, DialogInterface.OnClickListener listener,
                                              String cancel,DialogInterface.OnClickListener cl){
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(tiltle)
                .setPositiveButton(ok, listener)
                .setNegativeButton(cancel,cl)
                .setMessage(message)
                .create();
        dialog.show();
        return dialog;
    }

    public static AlertDialog showDialog(Context context, String tiltle, String message,
                                         String ok, DialogInterface.OnClickListener listener){
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(tiltle)
                .setPositiveButton(ok, listener)
                .setMessage(message)
                .create();
        dialog.show();
        return dialog;
    }
}
