package com.drg.koolping.repository;

import com.drg.koolping.domain.UserTaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

/**
 * Created by durdan on 30/10/2015.
 */

@RepositoryRestResource(collectionResourceRel="customer",path = "/customerTask")
public interface UserTaskRepository extends MongoRepository<UserTaskEntity,Long> {
    List<UserTaskEntity> findByUserEmailId(@Param("email") String email);
}
