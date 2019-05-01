package com.vinayakpatilec5.admin.rupeekdemo.ui.details;

import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationData;

public interface PlaceDetailView {
    void setDateData(String date);
    void setPlaceName(String name);
    void setPlaceImage(String url);
    void setDesc(String desc);
    void setPrice(String priceStr);
}
