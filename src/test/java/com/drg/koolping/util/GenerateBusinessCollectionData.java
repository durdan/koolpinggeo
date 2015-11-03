package com.drg.koolping.util;

import com.drg.koolping.domain.*;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by durdan on 22/10/2015.
 */
public class GenerateBusinessCollectionData {

    private BusinessEntity businessEntity;

    public List<BusinessEntity> generateBusinessCollectionData(int collectionSize) {
        CsvReader csvReader = new CsvReader("postcode-outcodes.csv");
        List<PostCodeGeoLocation> postCodeGeoLocationList = csvReader.readRecords();
        List<BusinessEntity> businessEntities = new ArrayList<BusinessEntity>();
        for (int i = 0; i < collectionSize; i++) {
            BusinessEntity businessEntity = new BusinessEntity();
            businessEntity.setType("Hospital");
            businessEntity.setName("Test name" + i);
            Address address = new Address();
            Random randomNo = new Random();
            address.setAptNo(String.valueOf(randomNo.nextInt()));
            address.setCity("TestCity" + randomNo.nextInt());
            address.setCountry("UK");
            address.setState("MiddleSex");
            address.setStreet("TestStreet" + i);
            address.setZip(postCodeGeoLocationList.get(i).getOutcode());
            GeoJsonPoint geoJsonPoint = new GeoJsonPoint(Double.valueOf(postCodeGeoLocationList.get(i).getLongitude()), Double.valueOf(postCodeGeoLocationList.get(i).getLatitude()));

            address.setLocation(geoJsonPoint);
            businessEntity.setAddress(address);
            businessEntities.add(businessEntity);

        }
        return businessEntities;
    }

    //mongoDBquery to find nearBy
//    db.business.find({   "address.location": {     $near: {       $geometry: { type: "Point", coordinates: [-2.27, 57.1081]       },       $maxDistance: 10000  }   }    })


//    {
//        "type":"venue2",
//            "name":"Durgesh vaticapp",
//            "address": {
//        "loc1": {
//            "type": "Point",
//                    "coordinates": [
//            -122.0829,
//                    37.4211
//            ]
//        },
//
//        "street": "1600 Amphitheatre Parkway",
//                "city": "Mountain View",
//                "state": "California",
//                "zip": "94043",
//                "country": "United States"
//    }

    //}

}
