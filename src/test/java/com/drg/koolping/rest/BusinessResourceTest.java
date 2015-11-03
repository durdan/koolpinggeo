package com.drg.koolping.rest;

import com.drg.koolping.LocationsApplication;
import com.drg.koolping.config.MongoConfig;
import com.drg.koolping.repository.BusinessRepository;
import com.drg.koolping.repository.BusinessRepositoryTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.*;

/**
 * Created by durdan on 26/10/2015.
 */
//@ContextConfiguration(classes = {MongoConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
// Makes sure the application starts at a random free port, caches it throughout
// all unit tests, and closes it again at the end.
@SpringApplicationConfiguration(classes = {MongoConfig.class, LocationsApplication.class})
@WebIntegrationTest(randomPort = true)
public class BusinessResourceTest {

    //Required to Generate JSON content from Java objects
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static String latitude = "-2.122482";
    private static String longitude = "57.161";
    private static String distance = "1000.0";
    private static String name = "Test name0";

    @Autowired
    private BusinessRepository businessRepository;

    // Will contain the random free port number
    @Value("${local.server.port}")
    private int port;

    /**
     * Returns the base url for your rest interface
     *
     * @return
     */
    private String getBaseUrl() {
        return "http://localhost:" + port + "/api/business";
    }

    //Test RestTemplate to invoke the APIs.
    private RestTemplate restTemplate = new TestRestTemplate();
    private Logger log = Logger.getLogger(BusinessRepositoryTest.class);

    @Test
    public void shouldGetLocationOfTheBusinessGivenTypeAndCoordinates() throws Exception {

//        //Creating http entity object with request body and headers
//        HttpEntity<String> requestEntity =
//                new HttpEntity<String>(OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getBaseUrl())
                .queryParam("longitude", longitude)
                .queryParam("latitude", latitude)

                .queryParam("distance", distance)
                .queryParam("type", name);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        log.info("*****from Test"+builder.build().encode().toUri());
        ResponseEntity<BusinessModel[]> responseEntity = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, BusinessModel[].class);
        //final ResponseEntity<String> responseEntity = restTemplate.exchange(getBaseUrl(), HttpMethod.GET, requestEntity, String.class);
        log.info(builder.build().encode().toUri() + "******" + responseEntity.getBody()[0].address);
        MediaType contentType = responseEntity.getHeaders().getContentType();
         HttpStatus statusCode = responseEntity.getStatusCode();
        assertTrue(statusCode.value() == 200);
        //Verify that the data from the API and data saved in the DB are same
        assertNotNull(responseEntity);
        assertEquals(responseEntity.getBody()[0].name, name);

    }

    @Test
    public void shouldGetLocationOfAllBusinessGivenCoordinates()throws Exception{
        //Creating http entity object with request body and headers
//        HttpEntity<String> requestEntity =
//                new HttpEntity<String>(OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getBaseUrl())
                .queryParam("longitude", longitude)
                .queryParam("latitude", latitude)

                .queryParam("distance", distance);


        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<BusinessModel[]> responseEntity = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, BusinessModel[].class);
        //final ResponseEntity<String> responseEntity = restTemplate.exchange(getBaseUrl(), HttpMethod.GET, requestEntity, String.class);
        log.info(builder.build().encode().toUri() + "******" + responseEntity.getBody()[0].address);
        MediaType contentType = responseEntity.getHeaders().getContentType();
        HttpStatus statusCode = responseEntity.getStatusCode();
        assertTrue(statusCode.value() == 200);
        //Verify that the data from the API and data saved in the DB are same
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody()[0].name);




    }

    static class BusinessModel {
        public String business_id;
        public String type;
        public String name;

        public Address address;

        static class Address {

            public String street;
            public String aptNo;
            public String city;
            public String state;
            public String zip;
            public String country;
            public Location location;

            @Override
            public String toString() {
                return String.format("%s, %s,%s,%s,%s %s - lat: %s, long: %s", street,aptNo,city,state, zip, country, location.y, location.x);
            }

            static class Location {
                public double x, y;
            }
        }
    }
}