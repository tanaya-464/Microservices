package org.bank.cust_service.service;


import org.bank.cust_service.entity.Customer;
import org.bank.cust_service.repository.CustomerRepo;
import org.bank.cust_service.response.AddressResponse;
import org.bank.cust_service.response.CustomerResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
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
private WebClient webClient;
//  @Autowired
//  private RestTemplate restTemplate;
  @Value("${addressservice.base.url}")
 private String addressBaseURL;

//  public  CustomerService(RestTemplate restTemplate){
//      this.restTemplate=restTemplate;
//  }
//public  CustomerService(@Value("${addressservice.base.url}")
//                        String addressBaseURL,
//                        RestTemplateBuilder restTemplateBuilder){
//    System.out.println("uri"+ addressBaseURL);
//    this.restTemplate=restTemplateBuilder
//            .rootUri(addressBaseURL)
//            .build();
//}
  public  CustomerResponse getCustomerById(int id){
//      AddressResponse addressResponse = new AddressResponse();
     Customer customer =customerRepo.findById(id).get();
      CustomerResponse customerResponse =modelMapper.map(customer,CustomerResponse.class);

      //addressResponse = restTemplate.getForObject(addressBaseURL+"/address/{id}",AddressResponse.class,id);
      //System.out.println(addressBaseURL);
      //customerResponse.setAddressResponse(addressResponse);
      AddressResponse addressResponse =webClient.get()
              .uri("/address/"+id)
              .retrieve()
              .bodyToMono(AddressResponse.class)
              .block();
      customerResponse.setAddressResponse(addressResponse);
      return customerResponse;
   }
}
