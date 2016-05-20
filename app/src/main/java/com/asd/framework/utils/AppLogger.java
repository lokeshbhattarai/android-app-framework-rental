package com.asd.framework.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by indra on 5/18/2016.
 */
public class AppLogger {
    public static void Debugger(String TAG, String MSG){
        Log.d(TAG, MSG);
    }

    public static void ToastMessage(Context context, String MSG){
        Toast.makeText(context, MSG, Toast.LENGTH_SHORT).show();
    }
}
