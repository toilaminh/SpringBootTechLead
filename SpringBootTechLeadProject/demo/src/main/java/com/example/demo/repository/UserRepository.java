package com.example.demo.repository;

import com.example.demo.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {
//    @Query(value = "select u.* from user u where u.username = :username")
    AppUser findByUsername(String userName);
}
