package com.capgemini.perf.shared.util;

import com.capgemini.perf.shared.data.CustomerDTO;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Generate test data.
 */
public class DataSetGenerator {

    public static final int DEFAULT_RECORDS = 100;

    public static List<CustomerDTO> dataSet(String firstName) {
        return dataSet(firstName, DEFAULT_RECORDS);
    }

    public static List<CustomerDTO> dataSet(String ref, int count) {
        final List<CustomerDTO> result = new ArrayList<>(count);
        // first 5 records are fixed, rest is random
        result.add(new CustomerDTO(null, 1, ref, "Bauer"));
        result.add(new CustomerDTO(null, 2, ref, "O'Brian"));
        result.add(new CustomerDTO(null, 3, ref, "Johnson"));
        result.add(new CustomerDTO(null, 4, ref, "Palmer"));
        result.add(new CustomerDTO(null, 5, ref, "Dessler"));

        IntStream.rangeClosed(6, count).forEach(i -> result.add(new CustomerDTO(null, i, ref, RandomStringUtils.randomAlphabetic(5, 20))));

        return result;
    }
}
