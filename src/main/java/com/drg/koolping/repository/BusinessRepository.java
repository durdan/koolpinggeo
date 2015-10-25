package com.drg.koolping.repository;

import com.drg.koolping.domain.BusinessEntity;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by durdan on 19/10/2015.
 */

//@RepositoryRestResource(collectionResourceRel = "business", path = "business")
public interface BusinessRepository extends MongoRepository<BusinessEntity,String> {
    // { 'location' : { '$near' : [point.x, point.y], '$maxDistance' : distance}}
   // List<BusinessEntity> findByLocationNear(Point location, Distance distance);
    List<BusinessEntity> findByAddressLocationNear(Point location, Distance distance);

//    List<Location> findByPositionWithin(Circle c);
//
//    List<Location> findByPositionWithin(Box b);
//
//    List<Location> findByPositionNear(Point p, Distance d);


}
