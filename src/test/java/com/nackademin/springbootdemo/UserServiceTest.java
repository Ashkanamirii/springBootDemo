package com.nackademin.springbootdemo;

import com.nackademin.springbootdemo.model.Address;
import com.nackademin.springbootdemo.model.Users;
import com.nackademin.springbootdemo.repository.UserRepo;
import com.nackademin.springbootdemo.service.UserService;
import com.nackademin.springbootdemo.utils.UserException;
import org.apache.catalina.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by Ashkan Amiri
 * Date:  2021-05-13
 * Time:  18:35
 * Project: springBootDemo
 * Copyright: MIT
 */
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void findUserByEmailAndPasswordTest() throws UserException {
        //creat an object of Users
        Users users = new Users(1L, "test@gmail.com", "123456", "test", "testLast",
                new Address(1L, "testStreet", "testZipcode",
                        "testCity", null, null), null, null, null);
        // mock data
        Mockito.when(userRepo.findByEmailAndPassword("test@gmail.com", "123456")).thenReturn(users);

        Users u = userService.findUserByEmailAndPassword(users.getEmail(), users.getPassword());
        assertThat(u.getEmail()).isEqualTo(users.getEmail());

       /* *********************Main method****************************
       public Users findUserByEmailAndPassword(String email, String password) throws UserException
                Users u = userRepo.findByEmailAndPassword(email, password);
        if (u == null) {
            throw new UserException("Incorrect USER or PASSWORD");
        } else {
           return u;
        }
       *******************************************************/

    }


    @Test(expected = UserException.class)
    public void findUserByEmailAndPassword_GivenNullShouldThrowException() throws UserException {
        //create an object of Users
        Users users = new Users(1L, "test@gmail.com", "123456", "test", "testLast",
                new Address(1L, "testStreet", "testZipcode",
                        "testCity", null, null), null, null, null);
        // mock data
        Mockito.when(userRepo.findByEmailAndPassword(users.getEmail(),users.getPassword())).thenReturn(users);

        Users u = userService.findUserByEmailAndPassword("test@gmail.com", "12345");

    }

}
