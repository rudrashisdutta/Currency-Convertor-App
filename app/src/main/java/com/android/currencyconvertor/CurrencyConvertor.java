package com.android.currencyconvertor;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;


public class CurrencyConvertor extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static String getFromResources(int resId) {
        return mContext.getString(resId);
    }

    /**
     *  This is an application class!
     *  Overridden, so user defined method getFromResources() can assign a value from resources to a final variable
     *  Do not forget to change android:name in application{} in Manifests, to the name of this class.
     **/
}

