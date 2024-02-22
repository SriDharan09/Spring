package com.sridhar.SpringBootTokenBasedAuth.Repository;

import com.sridhar.SpringBootTokenBasedAuth.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByName(String name);




}
