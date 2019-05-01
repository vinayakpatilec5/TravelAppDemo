package com.vinayakpatilec5.admin.rupeekdemo.ui.details;

import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationData;

public class PlaceDetailPresenter implements PlaceDetailMvpPresenter {

    private PlaceDetailView view;

    private LocationData locationData;

    @Override
    public void setLocationData(LocationData locationData) {
        this.locationData = locationData;
    }

    @Override
    public void onAttach(PlaceDetailView view) {
        this.view = view;
        setData();
    }

    private void setData(){
        if(locationData != null){
            view.setDateData(locationData.getDate());
            view.setDesc(locationData.getDescription());
            view.setPlaceName(locationData.getPlace());
            view.setPlaceImage(locationData.getUrl());
            view.setPrice("₹ "+locationData.getRate());
        }
    }
}
