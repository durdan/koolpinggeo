package com.drg.koolping.repository;

import com.drg.koolping.repository.domain.BusinessEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by durdan on 19/10/2015.
 */

@RepositoryRestResource(collectionResourceRel = "business", path = "business")
public interface BusinessRepository extends MongoRepository<BusinessEntity,BusinessEntity> {

}
