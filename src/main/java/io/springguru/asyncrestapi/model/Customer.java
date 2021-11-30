package io.springguru.asyncrestapi.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private CustomerAddresses customerAddresses;
    private CustomerNames customerNames;
    private CustomerPhone customerPhone;
}
