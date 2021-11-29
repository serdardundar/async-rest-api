package io.springguru.asyncrestapi.model;

import lombok.Data;

@Data
public class CustomerAddress {

    private String houseNo;
    private String streetNo;
    private int zipCode;
}
