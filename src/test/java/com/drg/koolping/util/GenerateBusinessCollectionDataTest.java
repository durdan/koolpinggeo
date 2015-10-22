package com.drg.koolping.util;

import com.drg.koolping.domain.BusinessEntity;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by durdan on 22/10/2015.
 */
public class GenerateBusinessCollectionDataTest {

    private GenerateBusinessCollectionData generateBusinessCollectionData=new GenerateBusinessCollectionData();

    @Test
    public void testGeneratedDataSize(){
        List<BusinessEntity> businessEntityList=generateBusinessCollectionData.generateBusinessCollectionData(20);
        System.out.println(businessEntityList.get(0).getAddress().getZip());
        assertTrue(businessEntityList.size()==20);

    }
}
