package com.drg.koolping.model;

import com.drg.koolping.domain.Address;
import lombok.Data;

/**
 * Created by durdan on 30/10/2015.
 */

@Data
public class BusinessModel {
    private String business_id;
    private String type;
    private String name;
    private String street;
    private String aptNo;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String longitude;
    private String latitude;
}
