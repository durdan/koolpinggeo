package com.drg.koolping.util;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;


/**
 * Created by durdan on 22/10/2015.
 */
public class CsvReaderTest {



    @Test
    public void readsRecords() {
        CsvReader csvReader = new CsvReader( "postcode-outcodes.csv");
        List<PostCodeGeoLocation> records = csvReader.readRecords();
        System.out.println(records.get(0));
        assertTrue(records.size() > 0);
    }

//    private CsvReader createCsvReader() {
//        try {
//            Path path = Paths.get("src/test/resources", "sample.csv");
//            Reader reader = Files.newBufferedReader(
//                    path, Charset.forName("UTF-8"));
//            return new CsvReader(reader);
//        } catch (IOException e) {
//            throw new UncheckedIOException(e);
//        }
//    }
}
