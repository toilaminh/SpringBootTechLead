package com.example.demo.service.sql;

import com.example.demo.model.entity.Address;
import com.example.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    //Level4
    @Transactional
    public void updateNewAddressName(){
        List<Address> addresses = addressRepository.listAddressesUpdate8();
        addresses.forEach(c -> c.setAddress( c.getAddress() + "samecity"));
        addressRepository.saveAll(addresses);
    }
}
