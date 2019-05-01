package com.vinayakpatilec5.admin.rupeekdemo.data.pref;

import android.content.Context;
import android.content.SharedPreferences;

import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.DaoMaster;

import java.net.URL;

public class MyPreferencesHelper implements PreferencesHelper {

    private final SharedPreferences mPrefs;
    private static final String USER_NAME = "USER_NAME";


    public MyPreferencesHelper(Context context) {
        mPrefs = context.getSharedPreferences("MY_PREFS", Context.MODE_PRIVATE);
    }

    @Override
    public void saveUserName(String name) {
        mPrefs.edit().putString(USER_NAME, name).apply();
    }

    @Override
    public String getUserName() {
        return mPrefs.getString(USER_NAME, "");
    }
}
