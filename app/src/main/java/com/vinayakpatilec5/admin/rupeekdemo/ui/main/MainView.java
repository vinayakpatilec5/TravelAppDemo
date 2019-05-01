package com.vinayakpatilec5.admin.rupeekdemo.ui.main;

import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationData;

public interface MainView {
    void showLoader();
    void hideLoader();
    void setCustomerName(String name);
    void setLocationList();
    void tappedPlaceDetails(LocationData data);
    void onError();
}
