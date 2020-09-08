package com.capgemini.perf.lib.util;

import com.capgemini.perf.lib.data.CustomerDTO;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class DataSetGenerator {

    public static final int DEFAULT_RECORDS = 100;

    public static List<CustomerDTO> dataSet(String firstName) {
        return dataSet(firstName, DEFAULT_RECORDS);
    }

    public static List<CustomerDTO> dataSet(String firstName, int count) {
        final List<CustomerDTO> result = new LinkedList<>();
        // first records are fixed, rest is random
        result.add(new CustomerDTO(1, firstName, "Bauer"));
        result.add(new CustomerDTO(2, firstName, "O'Brian"));
        result.add(new CustomerDTO(3, firstName, "Johnson"));
        result.add(new CustomerDTO(4, firstName, "Palmer"));
        result.add(new CustomerDTO(5, firstName, "Dessler"));

        IntStream.rangeClosed(6, count).forEach( i -> result.add(new CustomerDTO(i, firstName, RandomStringUtils.randomAlphabetic(5, 20))));

        return result;
    }
}