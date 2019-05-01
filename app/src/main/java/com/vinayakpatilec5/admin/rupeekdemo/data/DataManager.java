package com.vinayakpatilec5.admin.rupeekdemo.data;

import android.content.Context;

import com.vinayakpatilec5.admin.rupeekdemo.data.database.DbHelper;
import com.vinayakpatilec5.admin.rupeekdemo.data.network.ApiHelper;
import com.vinayakpatilec5.admin.rupeekdemo.data.pref.PreferencesHelper;

public interface DataManager extends ApiHelper, DbHelper,PreferencesHelper {
    void initDb(Context context);
}
