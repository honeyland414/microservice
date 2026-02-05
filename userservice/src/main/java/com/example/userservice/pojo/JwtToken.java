package com.example.userservice.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user_token")
public class JwtToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "token")
    private String token;
}
