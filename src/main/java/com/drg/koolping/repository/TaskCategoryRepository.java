package com.drg.koolping.repository;

import com.drg.koolping.domain.TaskCategoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by durdan on 30/10/2015.
 */

@RepositoryRestResource(collectionResourceRel = "taskType",path = "taskAdmin")
public interface TaskCategoryRepository extends MongoRepository<TaskCategoryEntity,String> {

    List<TaskCategoryEntity> findByTaskType(String taskType);
}
