package com.nackademin.springbootdemo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-09 <br>
 * Time: 15:32 <br>
 * Project: webshop-back-end <br>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true)
    @NotNull
    private String email;

    private String password;
    private String firstname;
    private String lastname;

    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    private Address address;

    @OneToMany
    @JoinColumn
    private List<Orders> orders;


    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "modify_date")
    private LocalDateTime  modifyDate;
}
