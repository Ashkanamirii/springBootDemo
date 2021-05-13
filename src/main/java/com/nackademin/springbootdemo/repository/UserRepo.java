package com.nackademin.springbootdemo.repository;

import com.nackademin.springbootdemo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-09 <br>
 * Time: 16:05 <br>
 * Project: webshop-back-end <br>
 */
@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    Users findByEmailAndPassword(String email, String password);

    Users findByEmail(String email);
}
