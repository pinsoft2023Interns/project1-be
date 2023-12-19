package com.pinsoft.project1.be.repository;

import com.pinsoft.project1.be.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface RoleRepository extends JpaRepository<Role, Long> {
  List<Role> findByNameEquals(String name);

}
