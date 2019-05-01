package com.vinayakpatilec5.admin.rupeekdemo.data.network;

import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationDataResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiHelper {

    @GET("v2/5c261ccb3000004f0067f6ec")
    Observable<LocationDataResponse> fetchLocations();
}
