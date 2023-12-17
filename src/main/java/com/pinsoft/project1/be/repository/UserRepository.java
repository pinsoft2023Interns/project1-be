package com.pinsoft.project1.be.repository;

import com.pinsoft.project1.be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
      Optional<User> findByEmail(String email);

}
