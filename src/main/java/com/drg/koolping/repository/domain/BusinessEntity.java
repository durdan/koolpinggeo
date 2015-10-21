package com.drg.koolping.repository.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by durdan on 19/10/2015.
 */
@Document(collection="business")
public class BusinessEntity implements Serializable {

    private static final long serialVersionUID = -4435384885078147241L;

    @Id
    private String business_id;
    private String type;
    private String name;
    private Address address;

    public String getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

