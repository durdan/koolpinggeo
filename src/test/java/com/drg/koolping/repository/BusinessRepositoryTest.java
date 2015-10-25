package com.drg.koolping.repository;

import com.drg.koolping.config.MongoConfig;
import com.drg.koolping.domain.BusinessEntity;
import com.drg.koolping.util.GenerateBusinessCollectionData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
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


//    @Before
//    public void setUp() {
//        generateBusinessCollectionData=new GenerateBusinessCollectionData();
//        List<BusinessEntity> businessEntityList=generateBusinessCollectionData.generateBusinessCollectionData(52);
//        businessRepository.save(businessEntityList);
//    }

    @Test
    public void readsFirstPageCorrectly() {

        List<BusinessEntity> businessEntitiesusiness = businessRepository.findAll();
        assertTrue(businessEntitiesusiness.size() > 50);
    }

    @Test
    public void addressNearByWithMaxDistance() {
        Point point = new Point( new Point(Double.valueOf(longitude), Double.valueOf(latitude)));
        Distance maxDistance=new Distance(Double.valueOf(distance));
        List<BusinessEntity> businessEntitiesusiness = businessRepository.findByAddressLocationNear(point,maxDistance);
        assertTrue(businessEntitiesusiness.size() > 0);
    }
}