package com.nackademin.springbootdemo.repository;

import com.nackademin.springbootdemo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-09 <br>
 * Time: 16:15 <br>
 * Project: webshop-back-end <br>
 */
//
@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {
}
