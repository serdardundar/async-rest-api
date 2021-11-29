package io.springguru.asyncrestapi.model;

import lombok.Data;

import java.util.List;

@Data
public class CustomerAddresses {
    private List<CustomerAddress> customerAddresses;
}
