package io.springguru.asyncrestapi.web;

import io.springguru.asyncrestapi.model.Customer;
import io.springguru.asyncrestapi.model.CustomerAddresses;
import io.springguru.asyncrestapi.model.CustomerNames;
import io.springguru.asyncrestapi.model.CustomerPhone;
import io.springguru.asyncrestapi.service.CustomerAsyncService;
import io.springguru.asyncrestapi.service.AbstractCustomerService;
import io.springguru.asyncrestapi.service.CustomerSyncService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AsyncRestController {

    private final CustomerAsyncService customerAsyncService;
    private final CustomerSyncService customerSyncService;

    @SneakyThrows
    @GetMapping("/testSync")
    public Customer testSync() {
        log.info("testSync start");
        long start = new Date().getTime();
        var customer = retrieveCustomerInfo(customerSyncService);
        long end = new Date().getTime();
        log.info("Sync Duration: " + (end - start));
        return customer;
    }

    @SneakyThrows
    private Customer retrieveCustomerInfo(AbstractCustomerService customerService) {
        CompletableFuture<CustomerAddresses> customerAddresses = customerService.retrieveCustomerAddresses();
        CompletableFuture<CustomerNames> customerNames = customerService.retrieveCustomerNames();
        CompletableFuture<CustomerPhone> customerPhone = customerService.retrieveCustomerPhones();

        CompletableFuture.allOf(customerAddresses, customerNames, customerPhone).join();

        log.info("CustomerAddresses --> {}", customerAddresses.get());
        log.info("CustomerNames --> {}", customerNames.get());
        log.info("CustomerPhone --> {}", customerPhone.get());
        return Customer.builder().customerNames(customerNames.get()).customerPhone(customerPhone.get()).customerAddresses(customerAddresses.get()).build();
    }

    @SneakyThrows
    @GetMapping("/testAsync")
    public Customer testAsync() {
        log.info("testAsync start");
        long start = new Date().getTime();
        var customer = retrieveCustomerInfo(customerAsyncService);
        long end = new Date().getTime();
        log.info("Async Duration: " + (end - start));
        return customer;
    }
}
