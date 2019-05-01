package com.vinayakpatilec5.admin.rupeekdemo.ui.details;

import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationData;

public interface PlaceDetailMvpPresenter {
    void onAttach(PlaceDetailView view);
    void setLocationData(LocationData locationData);
}
