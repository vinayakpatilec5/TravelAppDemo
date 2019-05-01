package com.vinayakpatilec5.admin.rupeekdemo.data.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.vinayakpatilec5.admin.rupeekdemo.BuildConfig;
import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationDataResponse;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApiHelper implements ApiHelper {

    private ApiHelper apiHelper;

    public MyApiHelper() {
        initializeRectofit();
    }

    private void initializeRectofit(){
       OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(defaultHttpClient)
                .build();
        apiHelper = retrofit.create(ApiHelper.class);
    }

    @Override
    public Observable<LocationDataResponse> fetchLocations() {
        return apiHelper.fetchLocations();
    }
}
