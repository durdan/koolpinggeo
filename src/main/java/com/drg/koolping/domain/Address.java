package com.drg.koolping.domain;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

/**
 * Created by durdan on 19/10/2015.
 */

public class Address {

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint  location;

    private String street;
    private String aptNo;
    private String city;
    private String state;
    private String zip;
    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint  location) {
        this.location = location;
    }

    public String getAptNo() {
        return aptNo;
    }

    public void setAptNo(String aptNo) {
        this.aptNo = aptNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (!getLocation().equals(address.getLocation())) return false;
        if (!getStreet().equals(address.getStreet())) return false;
        if (!getAptNo().equals(address.getAptNo())) return false;
        if (!getCity().equals(address.getCity())) return false;
        if (!getState().equals(address.getState())) return false;
        if (!getZip().equals(address.getZip())) return false;
        return getCountry().equals(address.getCountry());

    }

    @Override
    public int hashCode() {
        int result = getLocation().hashCode();
        result = 31 * result + getStreet().hashCode();
        result = 31 * result + getAptNo().hashCode();
        result = 31 * result + getCity().hashCode();
        result = 31 * result + getState().hashCode();
        result = 31 * result + getZip().hashCode();
        result = 31 * result + getCountry().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Address [street=" + street + ", aptNo=" + aptNo
                + ", city=" + city + ", state=" + state + ", zip=" + zip
                + ", country=" + country + "]";
    }
}