package com.drg.koolping.repository;

import com.drg.koolping.domain.LocationEntity;
import java.util.List;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<LocationEntity, String> {

  List<LocationEntity> findBySubjectAndLocationNear(String sid, Point p, Distance d);

}
