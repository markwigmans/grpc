package com.capgemini.perf.shared.util;

import com.capgemini.perf.shared.data.CustomerDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DataSetGeneratorTest {

    @Test
    void dataSet() {
        String firstName = "First";
        List<CustomerDTO> dataSet = DataSetGenerator.dataSet(firstName);
        assertThat(dataSet.size(), is(DataSetGenerator.DEFAULT_RECORDS));
        dataSet.stream().forEach(i -> assertThat(i.getFirstName(), is(firstName)));
    }

    @Test
    void dataSetSized() {
        String firstName = "Second";
        int size = 20;
        List<CustomerDTO> dataSet = DataSetGenerator.dataSet(firstName, size);
        assertThat(dataSet.size(), is(size));
        dataSet.stream().forEach(i -> assertThat(i.getFirstName(), is(firstName)));
    }
}