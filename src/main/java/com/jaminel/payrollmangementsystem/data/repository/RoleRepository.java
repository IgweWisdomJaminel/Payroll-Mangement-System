package com.jaminel.payrollmangementsystem.data.repository;

import com.jaminel.payrollmangementsystem.data.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name);
}
