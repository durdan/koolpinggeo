package com.drg.koolping.rest;

import com.drg.koolping.domain.LocationEntity;
import com.drg.koolping.model.LocationEntry;
import com.drg.koolping.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LocationResource {
//  @Autowired
//  private LocationRepository repository;
//
//  @RequestMapping(method = RequestMethod.GET)
//  public final List<LocationEntity> getLocations(
//    @RequestParam("lat") String latitude,
//    @RequestParam("long") String longitude,
//    @RequestParam("d") double distance,
//    @RequestParam(value = "s", required = false) String subjects) {
//
//    return this.repository.findBySubjectAndLocationNear(subjects,
//      new Point(Double.valueOf(longitude), Double.valueOf(latitude)),
//      new Distance(distance, Metrics.KILOMETERS));
//  }
//
//  @RequestMapping(method = RequestMethod.POST)
//  @ResponseStatus(HttpStatus.CREATED)
//  public final void addLocations(
//    @RequestParam("s") String sid,
//    @RequestBody List<LocationEntry> entries) {
//
//    List<LocationEntity> entities = new ArrayList<>();
//    for (LocationEntry location : entries) {
//      final GeoJsonPoint locationPoint = new GeoJsonPoint(
//        Double.valueOf(location.getLongitude()),
//        Double.valueOf(location.getLatitude()));
//
//      entities.add(new LocationEntity(sid, locationPoint));
//    }
//
//    this.repository.save(entities);
//  }
}
