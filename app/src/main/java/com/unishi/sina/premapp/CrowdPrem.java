package com.unishi.sina.premapp;

import com.firebase.client.Firebase;

/**
 * Created by Sina on 2016-06-21.
 */
public class CrowdPrem extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
