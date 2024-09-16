package org.bank.custaddressservice.service;

import org.bank.custaddressservice.entity.Address;
import org.bank.custaddressservice.repository.AddressRepo;
import org.bank.custaddressservice.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    private ModelMapper modelMapper;
    public AddressResponse findAddressByCustomerID(int customerId){
        Address address = addressRepo.findById(customerId).get();
        AddressResponse addressResponse = modelMapper.map(address,AddressResponse.class);
        return  addressResponse;

    }
}
