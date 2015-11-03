package com.drg.koolping.repository;

import com.drg.koolping.config.MongoConfig;
import com.drg.koolping.domain.BusinessEntity;

import com.drg.koolping.util.GenerateBusinessCollectionData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
//import org.springframework.data.geo.Point;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by durdan on 21/10/2015.
 */
@ContextConfiguration(classes = {MongoConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BusinessRepositoryTest {

    @Autowired
    BusinessRepository businessRepository;

    private GenerateBusinessCollectionData generateBusinessCollectionData;

    private static String longitude="-2.122482";
    private static String latitude="57.161";
    private static String distance="1000.0";
    private Logger log = Logger.getLogger(BusinessRepositoryTest.class);

//
//    @Before
//    public void setUp() {
//        generateBusinessCollectionData=new GenerateBusinessCollectionData();
//        List<BusinessEntity> businessEntityList=generateBusinessCollectionData.generateBusinessCollectionData(52);
//        businessRepository.save(businessEntityList);
//    }
//
//    @After
//    public void cleanUp(){
//     businessRepository.deleteAll();
//    }

    @Test
    public void readsFirstPageCorrectly() {

        List<BusinessEntity> businessEntitiesusiness = businessRepository.findAll();
        assertTrue(businessEntitiesusiness.size() > 50);
    }

    @Test
    public void testFindByNameAndAddressLocationNear() {
        Point point = new Point( new Point(Double.valueOf(longitude), Double.valueOf(latitude)));
        Distance maxDistance=new Distance(Double.valueOf(distance));
        List<BusinessEntity> businessEntitiesusiness = businessRepository.findByAddressLocationNear(point, maxDistance);
        log.info("*******************"+businessEntitiesusiness.get(0).getAddress().getLocation().toString());
        assertTrue(businessEntitiesusiness.size() > 0);
    }


    @Test
    public void findaddressNearByWithMaxDistanceAndName() {
        Point point = new Point( new Point(Double.valueOf(longitude), Double.valueOf(latitude)));
        Distance maxDistance=new Distance(Double.valueOf(distance));
        List<BusinessEntity> businessEntitiesusiness = businessRepository.findByNameAndAddressLocationNear("Test name6", point, maxDistance);
        log.info(businessEntitiesusiness.get(0).getName());
        assertTrue(businessEntitiesusiness.size() > 0);
    }



}