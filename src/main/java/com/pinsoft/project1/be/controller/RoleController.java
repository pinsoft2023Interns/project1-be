package com.pinsoft.project1.be.controller;

import com.pinsoft.project1.be.entity.Role;
import com.pinsoft.project1.be.entity.User;
import com.pinsoft.project1.be.servis.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;
    @GetMapping("/role")
    public Collection<Role>get(){return roleService.getAll();}
    @GetMapping("/role/{id}")
    public Role get(@PathVariable Long id){
        Optional<Role> optional = roleService.getById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/role/{id}")
    public void delete(@PathVariable Long id){
        roleService.delete(id);
    }
    @PostMapping("/role")
    public Role add(@RequestBody Role role){
        return roleService.add(role);
    }
}
