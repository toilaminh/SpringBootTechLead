package com.example.demo.repository;

import com.example.demo.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query(value = "select r.* from role r where r.role_id = :id", nativeQuery = true)
    Role findRoleById(@RequestParam Integer id);
}
