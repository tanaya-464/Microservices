package org.bank.cust_service.service;


import org.bank.cust_service.entity.Customer;
import org.bank.cust_service.feignclient.AddressClient;
import org.bank.cust_service.repository.CustomerRepo;
import org.bank.cust_service.response.AddressResponse;
import org.bank.cust_service.response.CustomerResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepo customerRepo;
  @Autowired
  private ModelMapper modelMapper;
@Autowired
private AddressClient addressClient;

public CustomerService(){

}
//  @Autowired
//  private RestTemplate restTemplate;
  @Value("${addressservice.base.url}")
 private String addressBaseURL;


  public  CustomerResponse getCustomerById(int id){
//      AddressResponse addressResponse = new AddressResponse();
     Customer customer =customerRepo.findById(id).get();
      CustomerResponse customerResponse =modelMapper.map(customer,CustomerResponse.class);
      ResponseEntity<AddressResponse>addressResponseEntity=addressClient.getAddressByCustomerId(id);
      AddressResponse addressResponse = addressResponseEntity.getBody();
      customerResponse.setAddressResponse(addressResponse);
      return customerResponse;
   }
}
