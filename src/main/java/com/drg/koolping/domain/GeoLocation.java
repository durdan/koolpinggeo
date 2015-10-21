package com.drg.koolping.domain;

/**
 * Created by durdan on 19/10/2015.
 */
import java.util.List;

public class GeoLocation {
    private String type;
    private List<Double> coordinates;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public List<Double> getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }
    @Override
    public String toString() {
        return "GeoLocation [type=" + type + ", coordinates=" + coordinates + "]";
    }

}