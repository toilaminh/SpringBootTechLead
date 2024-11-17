package com.example.demo.repository;

import com.example.demo.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address,Integer>, JpaRepository<Address, Integer> {
    @Query(value = "select a.*\n" +
            "from customer c\n" +
            "join address a on a.address_id = c.address_id\n" +
            "where a.address_id in (select c1.address_id from customer c1\n" +
            "join address a1 on a1.address_id = c1.address_id\n" +
            "where c.last_name = c1.last_name and c.customer_id <> c1.customer_id and a.city_id = a1.city_id)",nativeQuery = true)
    List<Address> listAddressesUpdate8();

}
