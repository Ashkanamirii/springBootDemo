package com.nackademin.springbootdemo.controller;

import com.nackademin.springbootdemo.model.Address;
import com.nackademin.springbootdemo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ashkan Amiri
 * Date:  2021-04-15
 * Time:  19:17
 * Project: webshop-backend
 * Copyright: MIT
 */
@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    AddressService addressService;
    //

    @GetMapping("/get")
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("/get/id")
    public Address getAddressById(Long id){
        return addressService.getAddressById(id);
    }

    @PostMapping("/add")
    public void addAddress(@RequestBody Address Address){
        addressService.addAddress(Address);
    }

    @PostMapping("/add/list")
    public void addAddresses(@RequestBody List<Address> Addresses){
        addressService.addAddresses(Addresses);
    }

    @PostMapping("/delete/all")
    public void deleteAllAddresses(){
        addressService.removeAllAddresses();
    }

    @PostMapping("/delete/{id}")
    public void deleteAddressById(@PathVariable Long id) {
        addressService.removeAddressById(id);
    }

}
