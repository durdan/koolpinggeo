package com.drg.koolping.config;

import com.drg.koolping.repository.RepositoryPackage;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by durdan on 21/10/2015.
 */
@Configuration
   @EnableMongoRepositories(basePackageClasses=RepositoryPackage.class)
   //@ComponentScan(basePackageClasses=TemplatePackage.class)
public class MongoConfig extends AbstractMongoConfiguration {


    @Override
    protected String getDatabaseName() {
        //return mongoDB;
        return "location";
    }

    @Override
    public Mongo mongo() throws Exception {

       // return new MongoClient(mongoHost + ":" + mongoPort);
        return  new MongoClient();
    }
    @Override
    protected String getMappingBasePackage() {
        return "com.drg.koolping.repository";
    }
}
