package org.bank.cust_service.feignclient;

import org.bank.cust_service.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="demofeign",url="http://localhost:8085/custaddress-service/api")

public interface AddressClient {
    @GetMapping("/address/{id}")
    public ResponseEntity<AddressResponse> getAddressByCustomerId(@PathVariable("id")int id);
}
