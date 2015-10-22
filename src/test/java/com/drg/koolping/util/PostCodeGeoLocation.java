package com.drg.koolping.util;

/**
 * Created by durdan on 22/10/2015.
 */
public class PostCodeGeoLocation {

    private int Id;
    private String outcode;
    private String latitude;
    private String longitude;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getOutcode() {
        return outcode;
    }

    public void setOutcode(String outcode) {
        this.outcode = outcode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "PostCodeGeoLocation{" +
                "Id=" + Id +
                ", outcode='" + outcode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
