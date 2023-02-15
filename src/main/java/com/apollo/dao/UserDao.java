package com.apollo.dao;

import com.apollo.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<TUser, Integer> {

    @Query(value = "FROM TUser WHERE email = :email")
    TUser findName1(@Param("email") String email);

    @Query(value = "SELECT * FROM TUser", nativeQuery = true)
    List<TUser> getAllUser();

}
