package com.nackademin.springbootdemo.service;

import com.nackademin.springbootdemo.model.Address;
import com.nackademin.springbootdemo.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ashkan Amiri
 * Date:  2021-04-15
 * Time:  19:19
 * Project: webshop-backend
 * Copyright: MIT
 */
@Service
public class AddressService {

    @Autowired
    AddressRepo addressRepo;
    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepo.findById(id).orElse(null); // Makes it possible to return Address instead of Optional
    }

    public void addAddress(Address address) {
        addressRepo.save(address);
    }

    public void addAddresses(List<Address> addresses) {
        addressRepo.saveAll(addresses);
    }

    public void removeAllAddresses() {
        addressRepo.deleteAllInBatch();
    }

    public void removeAddressById(Long id) {
        addressRepo.deleteById(id);
    }
}
