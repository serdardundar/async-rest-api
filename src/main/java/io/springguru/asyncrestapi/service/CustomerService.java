package io.springguru.asyncrestapi.service;

import io.springguru.asyncrestapi.model.CustomerAddresses;
import io.springguru.asyncrestapi.model.CustomerNames;
import io.springguru.asyncrestapi.model.CustomerPhone;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerService {

    private static final String REMOTE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate;

    @SneakyThrows
    public CompletableFuture<CustomerNames> retrieveCustomerNames() {
        log.info("retrieve customer names");
        var customerNames = restTemplate.getForObject(REMOTE_URL + "/names", CustomerNames.class);
        log.info("customerNames: " + customerNames);
        Thread.sleep(1000);
        return CompletableFuture.completedFuture(customerNames);
    }

    @SneakyThrows
    public CompletableFuture<CustomerAddresses> retrieveCustomerAddresses() {
        log.info("retrieve customer addresses");
        var customerAddresses =
            restTemplate.getForObject(REMOTE_URL + "/addresses", CustomerAddresses.class);
        log.info("customerAddresses: " + customerAddresses);
        Thread.sleep(1000);
        return CompletableFuture.completedFuture(customerAddresses);
    }

    @SneakyThrows
    public CompletableFuture<CustomerPhone> retrieveCustomerPhones() {
        log.info("retrieve customer phones");
        var customerPhone = restTemplate.getForObject(REMOTE_URL + "/phones", CustomerPhone.class);
        log.info("customerPhones: " + customerPhone);
        Thread.sleep(1000);
        return CompletableFuture.completedFuture(customerPhone);
    }
}
