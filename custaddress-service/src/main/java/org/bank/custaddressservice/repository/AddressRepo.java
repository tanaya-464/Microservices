package org.bank.custaddressservice.repository;

import org.bank.custaddressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepo extends JpaRepository<Address,Integer> {
    @Query(nativeQuery = true, value="select ca.id,ca.lane1,ca.lane2,ca.state,ca.zip from bankdb.address ca join bankdb.customer c on c.id=ca.customer_id where ca.customer_id=:customerId;")
    Address findAddressByCustomerId(@Param("customerId") int customerId);

}
