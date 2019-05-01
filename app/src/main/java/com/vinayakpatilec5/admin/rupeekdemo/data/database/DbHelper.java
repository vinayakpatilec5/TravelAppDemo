package com.vinayakpatilec5.admin.rupeekdemo.data.database;

import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationData;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {

    Observable<List<LocationData>> getSavedLocations();
    void saveNotification(List<LocationData> locationDataList);
}
