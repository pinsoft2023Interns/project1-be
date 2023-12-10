package com.pinsoft.project1.be.servis;

import com.pinsoft.project1.be.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    //public Role add(Role role) {return roleRepository.save(role)}
}
