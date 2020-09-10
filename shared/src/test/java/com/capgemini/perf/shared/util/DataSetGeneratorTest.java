package com.capgemini.perf.shared.util;

import com.capgemini.perf.shared.data.CustomerDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DataSetGeneratorTest {

    @Test
    void dataSet() {
        List<CustomerDTO> dataSet = DataSetGenerator.dataSet("First");
        assertThat(dataSet.size(), is(100));
    }
}