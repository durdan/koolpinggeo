package com.drg.koolping.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by durdan on 22/10/2015.
 */

public class CsvReader {


    private static final String SEPARATOR = ",";

    private final String fileName;

    public CsvReader(String fileName) {
        this.fileName = fileName;
    }

    public List<PostCodeGeoLocation> readRecords() {
        Path path = Paths.get("src/test/resource", fileName);

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);) {
            return convertIntoList(reader.lines()
                    .skip(1)
                    .map(line -> Arrays.asList(line.split(SEPARATOR)))
                    .collect(Collectors.toList()));

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public List<PostCodeGeoLocation> convertIntoList(List<List<String>> geoPostCodes) {
        List<PostCodeGeoLocation> postCodeGeoLocationList=new ArrayList<PostCodeGeoLocation>();
        for (int i = 0; i < geoPostCodes.size(); i++) {
            PostCodeGeoLocation postCodeGeoLocation = new PostCodeGeoLocation();
            postCodeGeoLocation.setId(Integer.parseInt(geoPostCodes.get(i).get(0)));
            postCodeGeoLocation.setOutcode(geoPostCodes.get(i).get(1));
            postCodeGeoLocation.setLatitude(geoPostCodes.get(i).get(2));
            postCodeGeoLocation.setLongitude(geoPostCodes.get(i).get(3));
            postCodeGeoLocationList.add(postCodeGeoLocation);
        }
        return  postCodeGeoLocationList;
    }
}
