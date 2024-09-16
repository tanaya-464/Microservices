package org.bank.custaddressservice.controller;

import org.bank.custaddressservice.response.AddressResponse;
import org.bank.custaddressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerAddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/address/{customerId}")
    public ResponseEntity<AddressResponse> getAddressByCustomer(@PathVariable("customerId")int id){
        AddressResponse addressResponse=addressService.findAddressByCustomerID(id);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }
}
