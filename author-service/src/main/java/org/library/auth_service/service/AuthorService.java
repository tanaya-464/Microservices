package org.library.auth_service.service;


import org.library.auth_service.entity.Author;
import org.library.auth_service.repository.AuthorRepo;
import org.library.auth_service.response.AuthorResponse;
import org.library.auth_service.response.BookResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AuthorService {

  @Autowired
  private AuthorRepo authorRepo;
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
  public AuthorResponse getAuthorById(int id){
//      AddressResponse addressResponse = new AddressResponse();
     Author author =authorRepo.findById(id).get();
      AuthorResponse authorResponse =modelMapper.map(author,AuthorResponse.class);

      //addressResponse = restTemplate.getForObject(addressBaseURL+"/address/{id}",AddressResponse.class,id);
      //System.out.println(addressBaseURL);
      //customerResponse.setAddressResponse(addressResponse);
      BookResponse bookResponse =webClient.get()
              .uri("/book/"+id)
              .retrieve()
              .bodyToMono(BookResponse.class)
              .block();
      authorResponse.setBookResponse(bookResponse);
      return authorResponse;
   }
}
