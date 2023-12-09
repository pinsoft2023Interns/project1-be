package com.pinsoft.project1.be.repository;

import com.pinsoft.project1.be.entity.User;
import com.pinsoft.project1.be.servis.UserServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

 public interface UserRepository extends JpaRepository<User, Long> {

}
