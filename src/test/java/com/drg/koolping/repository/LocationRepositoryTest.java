package com.drg.koolping.repository;

import com.drg.koolping.config.MongoConfig;
import com.drg.koolping.domain.BusinessEntity;
import com.drg.koolping.domain.LocationEntity;
import com.drg.koolping.model.LocationEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by durdan on 21/10/2015.
 */
@ContextConfiguration(classes = {MongoConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LocationRepositoryTest {

    private static final Point DUS = new Point(6.810036, 51.224088);
    @Autowired
    LocationRepository locationRepository;

    @Test
    public void readsFirstPageCorrectly() {

        Page<LocationEntity> businessEntitiesusiness = locationRepository.findAll(new PageRequest(0, 10));
        assertTrue(businessEntitiesusiness.getTotalElements() > 0);
    }

    @Test
    public void testFindBySubjectAndLocationNear() throws Exception {

        List<LocationEntity> locationNear=locationRepository.findBySubjectAndLocationNear("test1",DUS,new Distance(1, Metrics.KILOMETERS));
        assertTrue(locationNear.size()>0);


    }
}