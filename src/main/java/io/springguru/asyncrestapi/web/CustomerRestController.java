package io.springguru.asyncrestapi.web;

import io.springguru.asyncrestapi.model.CustomerAddress;
import io.springguru.asyncrestapi.model.CustomerAddresses;
import io.springguru.asyncrestapi.model.CustomerName;
import io.springguru.asyncrestapi.model.CustomerNames;
import io.springguru.asyncrestapi.model.CustomerPhone;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class CustomerRestController {

    @SneakyThrows
    @GetMapping("/addresses")
    public CustomerAddresses getAddresses() {
        log.info("get addresses Start");

        var customerAddressesList = new CustomerAddresses();

        var customerAddress = new CustomerAddress();
        var customerAddress2 = new CustomerAddress();

        List<CustomerAddress> addressList = new ArrayList<>();
        customerAddress.setHouseNo("1111");
        customerAddress.setStreetNo("111");
        customerAddress.setZipCode(111111);

        customerAddress2.setHouseNo("222");
        customerAddress2.setStreetNo("222");
        customerAddress2.setZipCode(222222);

        addressList.add(customerAddress);
        addressList.add(customerAddress2);

        customerAddressesList.setCustomerAddresses(addressList);
        Thread.sleep(500);

        return customerAddressesList;
    }

    @SneakyThrows
    @GetMapping("/phones")
    public CustomerPhone getPhoneNumbers() {
        log.info("get phones Start");

        var customerPhone = new CustomerPhone();
        ArrayList<String> phoneNumberList = new ArrayList<>();

        phoneNumberList.add("+905325320000");
        phoneNumberList.add("+905325320001");

        customerPhone.setPhoneNumberList(phoneNumberList);
        Thread.sleep(500);

        return customerPhone;
    }

    @SneakyThrows
    @GetMapping("/names")
    public CustomerNames getCustomerName() {
        log.info("get names Start");

        var customerNames = new CustomerNames();

        var customerName = new CustomerName();
        var customerName2 = new CustomerName();

        List<CustomerName> customerNameList = new ArrayList<>();

        customerName.setFirstName("Kemal");
        customerName.setLastName("Sunal");

        customerName2.setFirstName("Halit");
        customerName2.setLastName("Akçatepe");

        customerNameList.add(customerName);
        customerNameList.add(customerName2);

        customerNames.setCustomerNames(customerNameList);
        Thread.sleep(500);
        return customerNames;
    }
}
