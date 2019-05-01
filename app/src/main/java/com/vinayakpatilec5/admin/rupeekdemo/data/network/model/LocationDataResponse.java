package com.vinayakpatilec5.admin.rupeekdemo.data.network.model;

import java.util.List;

public class LocationDataResponse {
    private List<LocationData> locations;
    private String cust_name;

    public List<LocationData> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationData> locations) {
        this.locations = locations;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }
}
