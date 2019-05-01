package com.vinayakpatilec5.admin.rupeekdemo.data.network.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "locationdata")
public class LocationData implements Serializable{

    private static final long serialVersionUID = 7526472295622776147L;

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "place")
    private String place;

    @Property(nameInDb = "url")
    private String url;

    @Property(nameInDb = "date")
    private String date;

    @Property(nameInDb = "rate")
    private int rate;

    @Property(nameInDb = "description")
    private String description;


    @Generated(hash = 2115386802)
    public LocationData(Long id, String place, String url, String date, int rate,
            String description) {
        this.id = id;
        this.place = place;
        this.url = url;
        this.date = date;
        this.rate = rate;
        this.description = description;
    }

    @Generated(hash = 1606831457)
    public LocationData() {
    }


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
