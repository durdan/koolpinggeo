package com.drg.koolping;

import com.drg.koolping.config.MongoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan
public class LocationsApplication {

  public static void main(String[] args) {
    SpringApplication.run(MongoConfig.class, args);
  }
}
