package com.example.orderservice.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "item")
    private String item;
    @Column(name = "price")
    private Long price;
    @Column(name = "amount")
    private Integer amount;
}
