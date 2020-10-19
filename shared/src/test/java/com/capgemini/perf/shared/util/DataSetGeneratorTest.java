package com.capgemini.perf.shared.util;

import com.capgemini.perf.shared.data.CustomerDTO;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DataSetGeneratorTest {

    @Test
    void dataSet() {
        String ref = "First";
        var dataSet = DataSetGenerator.dataSet(ref);
        assertThat(dataSet.size(), is(DataSetGenerator.DEFAULT_RECORDS));
        dataSet.forEach(i -> assertThat("check ref", i.getRef(), is(ref)));
        assertThat("check if all userId's are unique", dataSet.stream().map(CustomerDTO::getUserId).distinct().count(), CoreMatchers.is((long) dataSet.size()));
    }

    @Test
    void dataSetSized() {
        String ref = "Second";
        int size = 20;
        var dataSet = DataSetGenerator.dataSet(ref, size);
        assertThat(dataSet.size(), is(size));
        dataSet.forEach(i -> assertThat("check ref", i.getRef(), is(ref)));
        assertThat("check if all userId's are unique", dataSet.stream().map(CustomerDTO::getUserId).distinct().count(), CoreMatchers.is((long) dataSet.size()));
    }
}