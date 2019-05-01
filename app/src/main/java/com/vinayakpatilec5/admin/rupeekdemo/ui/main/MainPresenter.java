package com.vinayakpatilec5.admin.rupeekdemo.ui.main;

import android.util.Log;

import com.vinayakpatilec5.admin.rupeekdemo.data.DataManager;
import com.vinayakpatilec5.admin.rupeekdemo.data.MyDataManager;
import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationData;
import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationDataResponse;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainMvpPresenter {

    private MainView mainView;
    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private LocationDataResponse locationDataResponse;

    @Override
    public void onAttach(MainView mainView) {
        this.mainView = mainView;
        fetchLocationData();
    }

    @Override
    public void onDeAttach() {
        //mCompositeDisposable.dispose();
    }

    @Override
    public void fetchLocationData() {
        mainView.showLoader();
        mCompositeDisposable.add(MyDataManager.getInstance().fetchLocations().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<LocationDataResponse>() {
            @Override
            public void accept(LocationDataResponse response) throws Exception {
                mainView.hideLoader();
                locationDataResponse = response;
                mainView.setLocationList();
                mainView.setCustomerName(response.getCust_name());
                syncData();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
               getSavedData();
            }
        }));
    }

    private void syncData(){
        MyDataManager.getInstance().saveNotification(locationDataResponse.getLocations());
        MyDataManager.getInstance().saveUserName(locationDataResponse.getCust_name());
    }

    private void getSavedData(){
        mCompositeDisposable.add(MyDataManager.getInstance().getSavedLocations().
        subscribeOn(Schedulers.computation()).
        observeOn(AndroidSchedulers.mainThread()).
        subscribe(new Consumer<List<LocationData>>() {
            @Override
            public void accept(List<LocationData> locationDataList) throws Exception {
                mainView.hideLoader();
                if(locationDataList.size()>0) {
                    locationDataResponse = new LocationDataResponse();
                    locationDataResponse.setLocations(locationDataList);
                    locationDataResponse.setCust_name(MyDataManager.getInstance().getUserName());
                    mainView.setLocationList();
                    mainView.setCustomerName(locationDataResponse.getCust_name());
                }else {
                    mainView.onError();
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mainView.hideLoader();
                mainView.onError();
            }
        }));
                //locationDataResponse.setLocations(MyDataManager.getInstance().getSavedLocations());
    }

    @Override
    public LocationData getLocationData(int position) {
        return locationDataResponse.getLocations().get(position);
    }

    @Override
    public int getLocationsCount() {
        return locationDataResponse.getLocations().size();
    }

    @Override
    public void tappedPlaceDetails(int position) {
        mainView.tappedPlaceDetails(getLocationData(position));
    }
}
