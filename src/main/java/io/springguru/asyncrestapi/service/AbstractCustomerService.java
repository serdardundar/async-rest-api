package io.springguru.asyncrestapi.service;

import io.springguru.asyncrestapi.model.CustomerAddresses;
import io.springguru.asyncrestapi.model.CustomerNames;
import io.springguru.asyncrestapi.model.CustomerPhone;

import java.util.concurrent.CompletableFuture;

public abstract class AbstractCustomerService {

    public abstract CompletableFuture<CustomerNames> retrieveCustomerNames();

    public abstract CompletableFuture<CustomerAddresses> retrieveCustomerAddresses();

    public abstract CompletableFuture<CustomerPhone> retrieveCustomerPhones();
}
