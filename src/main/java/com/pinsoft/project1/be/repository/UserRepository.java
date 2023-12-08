package com.pinsoft.project1.be.repository;

import com.pinsoft.project1.be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, Long> {
}
