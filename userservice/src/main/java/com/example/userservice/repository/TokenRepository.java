package com.example.userservice.repository;

import com.example.userservice.pojo.JwtToken;
import com.example.userservice.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<JwtToken, Integer> {
    @Query(value = "select token from JwtToken token where token.username = :username")
    Optional<JwtToken> findByUsername(@Param("username") String username);
}
