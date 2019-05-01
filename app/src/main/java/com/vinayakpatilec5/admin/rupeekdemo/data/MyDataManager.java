package com.vinayakpatilec5.admin.rupeekdemo.data;

import android.content.Context;

import com.vinayakpatilec5.admin.rupeekdemo.data.database.MyHelper;
import com.vinayakpatilec5.admin.rupeekdemo.data.network.ApiHelper;
import com.vinayakpatilec5.admin.rupeekdemo.data.network.MyApiHelper;
import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationData;
import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationDataResponse;
import com.vinayakpatilec5.admin.rupeekdemo.data.pref.MyPreferencesHelper;

import java.util.List;

import io.reactivex.Observable;

public class MyDataManager implements DataManager{

    private static MyDataManager myDataManager = null;

    private ApiHelper apiHelper;
    private MyHelper myHelper;
    private MyPreferencesHelper myPreferencesHelper;

    public static MyDataManager getInstance() {
        if (myDataManager == null)
            myDataManager = new MyDataManager();

        return myDataManager;
    }

    public MyDataManager() {
        apiHelper = new MyApiHelper();
    }

    @Override
    public void initDb(Context context) {
        myHelper = new MyHelper(context);
        myPreferencesHelper = new MyPreferencesHelper(context);

    }

    @Override
    public Observable<LocationDataResponse> fetchLocations() {
        return apiHelper.fetchLocations();
    }

    @Override
    public Observable<List<LocationData>> getSavedLocations() {
        return myHelper.getSavedLocations();
    }

    @Override
    public void saveNotification(List<LocationData> locationDataList) {
        myHelper.saveNotification(locationDataList);
    }

    @Override
    public void saveUserName(String name) {
        myPreferencesHelper.saveUserName(name);
    }

    @Override
    public String getUserName() {
        return myPreferencesHelper.getUserName();
    }
}
