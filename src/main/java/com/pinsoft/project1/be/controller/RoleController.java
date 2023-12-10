package com.pinsoft.project1.be.controller;

import com.pinsoft.project1.be.servis.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;
}
