package com.vinayakpatilec5.admin.rupeekdemo.ui.main;

import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationData;

public interface MainMvpPresenter {
    void onAttach(MainView mainView);
    void onDeAttach();
    void fetchLocationData();
    LocationData getLocationData(int position);
    int getLocationsCount();
    void tappedPlaceDetails(int position);
}
