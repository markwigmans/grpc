package com.capgemini.perf.shared.util;

import com.capgemini.perf.shared.data.CustomerDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DataSetGeneratorTest {

    @Test
    void dataSet() {
        String ref = "First";
        List<CustomerDTO> dataSet = DataSetGenerator.dataSet(ref);
        assertThat(dataSet.size(), is(DataSetGenerator.DEFAULT_RECORDS));
        dataSet.forEach(i -> assertThat(i.getRef(), is(ref)));
    }

    @Test
    void dataSetSized() {
        String ref = "Second";
        int size = 20;
        List<CustomerDTO> dataSet = DataSetGenerator.dataSet(ref, size);
        assertThat(dataSet.size(), is(size));
        dataSet.forEach(i -> assertThat(i.getRef(), is(ref)));
    }
}