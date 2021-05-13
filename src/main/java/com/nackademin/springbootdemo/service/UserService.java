package com.nackademin.springbootdemo.service;

import com.nackademin.springbootdemo.model.Orders;
import com.nackademin.springbootdemo.model.Users;
import com.nackademin.springbootdemo.repository.OrderRepo;
import com.nackademin.springbootdemo.repository.UserRepo;
import com.nackademin.springbootdemo.utils.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-12 <br>
 * Time: 12:10 <br>
 * Project: webshop-back-end <br>
 */
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public Users getUserById(Long id) {
        return userRepo.findById(id).orElse(null); // Makes it possible to return User instead of Optional
    }

    public Users addUser(Users users) throws Exception {
        return userRepo.save(users);
    }

    public Users addUser1(Users users) throws UserException {
        Users u = userRepo.findByEmail(users.getEmail());
        if (u != null) {
            throw new UserException("Can't be same!!!!!!");
        } else {
            return userRepo.save(users);
        }
    }


    public Users findUserByEmailAndPassword(String email, String password) throws UserException {
        Users u = userRepo.findByEmailAndPassword(email, password);
        if (u == null) {
            throw new UserException("Incorrect USER or PASSWORD");
        } else {
            return u;
        }
    }

    public Users updateUser(Users users) {
        Users u = userRepo.getOne(users.getId());
        u.setFirstname(users.getFirstname());
        u.setLastname(users.getLastname());
        u.setPassword(users.getPassword());
        u.getAddress().setCity(users.getAddress().getCity());
        u.getAddress().setStreet(users.getAddress().getStreet());
        u.getAddress().setZipcode(users.getAddress().getZipcode());
        return userRepo.save(u);
    }

    public Users deleteUser(Users users) {
        List<Orders> o = orderRepo.findByUsersId(users.getId());
        if (!o.isEmpty()) {
            for (Orders order : o) {
                order.setUsers(null);
                orderRepo.save(order);
            }
        }
        userRepo.delete(users);
        return users;
    }

    public String removeUserById(Long id) {
        userRepo.deleteById(id);
        return "User with id " + id + " removed.";
    }

    public String removeUsers() {
        userRepo.deleteAllInBatch();
        return "All users deleted.";
    }


    public List<Users> addUsers(List<Users> users) {
        return userRepo.saveAll(users);
    }
}
