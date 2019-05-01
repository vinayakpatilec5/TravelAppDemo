package com.vinayakpatilec5.admin.rupeekdemo.data.database;

import android.content.Context;

import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.DaoMaster;
import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.DaoSession;
import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationData;
import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationDataDao;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;

public class MyHelper implements DbHelper {

    private DaoSession mDaoSession;

    public MyHelper(Context context) {
        mDaoSession = new DaoMaster(new DaoMaster.DevOpenHelper(context,"rupeek").getWritableDb()).newSession();
    }

    @Override
    public Observable<List<LocationData>> getSavedLocations() {
        return Observable.fromCallable(new Callable<List<LocationData>>() {
            @Override
            public List<LocationData> call() throws Exception {
                return mDaoSession.getLocationDataDao().queryBuilder()
                        .list();
            }
        });
    }

    @Override
    public void saveNotification(List<LocationData> locationDataList) {
        mDaoSession.getLocationDataDao().deleteAll();
        for (int i = 0;i<locationDataList.size();i++){
            mDaoSession.getLocationDataDao().insertOrReplace(locationDataList.get(i));
        }
    }
}
