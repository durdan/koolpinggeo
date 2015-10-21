package com.drg.koolping.repository;

import com.drg.koolping.LocationsApplication;
import com.drg.koolping.config.MongoConfig;
import com.drg.koolping.domain.BusinessEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by durdan on 21/10/2015.
 */
@ContextConfiguration(classes={MongoConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BusinessRepositoryTest  {

@Autowired
 BusinessRepository businessRepository;

    @Test
    public void readsFirstPageCorrectly() {

        Page<BusinessEntity> businessEntitiesusiness = businessRepository.findAll(new PageRequest(0, 10));
        assertTrue(businessEntitiesusiness.getTotalElements()>0);
    }
}