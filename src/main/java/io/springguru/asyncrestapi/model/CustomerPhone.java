package io.springguru.asyncrestapi.model;

import lombok.Data;

import java.util.List;

@Data
public class CustomerPhone {

    private List<String> phoneNumberList;
}
