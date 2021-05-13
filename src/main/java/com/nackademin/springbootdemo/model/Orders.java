package com.nackademin.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-09 <br>
 * Time: 15:11 <br>
 * Project: webshop-back-end <br>
 */
@Entity
@Data
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Users users;

    private String date;
    private Status status;
    private double totalPrice;

    private enum Status{
        PENDING,
        PRINTED,
        DELIVERED,
    };


    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "modify_date")
    private LocalDateTime  modifyDate;
}

