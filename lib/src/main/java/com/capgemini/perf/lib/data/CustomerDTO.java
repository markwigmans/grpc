package com.capgemini.perf.lib.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private int userId;
    private String firstName;
    private String lastName;
}
