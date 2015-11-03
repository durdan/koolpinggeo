package com.drg.koolping.repository;

import com.drg.koolping.domain.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by durdan on 30/10/2015.
 */

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends MongoRepository<CustomerEntity,String> {

    List<CustomerEntity> findByFirstName(@Param("firstName") String firstName);
    List<CustomerEntity> findByLastName(@Param("lastName") String lastName);
    List<CustomerEntity> findByEmail(@Param("email") String email);

}
