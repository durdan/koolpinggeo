package com.drg.koolping.rest;

import com.drg.koolping.domain.Address;
import com.drg.koolping.domain.BusinessEntity;
import com.drg.koolping.domain.LocationEntity;
import com.drg.koolping.model.BusinessModel;
import com.drg.koolping.repository.BusinessRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;


import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by durdan on 26/10/2015.
 */
@RestController
@RequestMapping(path="api/")
public class BusinessResource {

    @Autowired
    private BusinessRepository businessRepository;
    private Logger log = Logger.getLogger(BusinessResource.class);


    @RequestMapping(path = "business",method = RequestMethod.GET)
    public final List<BusinessEntity> getBusinessLocations(@RequestParam("latitude") String longitude,
                                                   @RequestParam("longitude") String latitude,
                                                   @RequestParam("distance") double distance,
                                                   @RequestParam(value = "type", required = false) String type)


    {
        log.info("********"+longitude+latitude+distance+type);
        if(type==null || type.isEmpty()){
           return this.businessRepository.findByAddressLocationNear( new Point(Double.valueOf(longitude), Double.valueOf(latitude)),
                   new Distance(distance, Metrics.KILOMETERS));
        }else
        return this.businessRepository.findByNameAndAddressLocationNear(type,
                new Point(Double.valueOf(longitude), Double.valueOf(latitude)),
                new Distance(distance, Metrics.KILOMETERS));
    }

    @RequestMapping(path="business/create",method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public final BusinessEntity createBusinessEntry(@RequestBody BusinessModel businessModel){
        BusinessEntity businessEntity=new BusinessEntity();
        businessEntity.setType(businessModel.getType());
        businessEntity.setName(businessModel.getName());
        Address address=new Address();
        address.setAptNo(businessModel.getAptNo());
        address.setCity(businessModel.getCity());
        address.setStreet(businessModel.getStreet());
        address.setCountry(businessModel.getCountry());
        address.setZip(businessModel.getZip());
        address.setState(businessModel.getState());
        address.setLocation(new GeoJsonPoint(Double.valueOf(businessModel.getLongitude()),Double.valueOf(businessModel.getLatitude())));
        businessEntity.setAddress(address);
        return  this.businessRepository.save(businessEntity);
    }
}
