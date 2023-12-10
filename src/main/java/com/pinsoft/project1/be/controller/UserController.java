package com.pinsoft.project1.be.controller;

import com.pinsoft.project1.be.entity.User;
import com.pinsoft.project1.be.servis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;
@RestController
public class UserController {
    @Autowired
    UserService userServis;
    @GetMapping("/user_account")
    public Collection<User> get(){
        return userServis.getAll();
    }

    @GetMapping("/user_account/{id}")
    public User get(@PathVariable Long id){
        Optional<User> optional = userServis.getById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/user_account/{id}")
    public void delete(@PathVariable Long id){
        userServis.delete(id);

    }
    @PostMapping("/user_account")
    public User add(@RequestBody User user){
        return userServis.add(user);
     }
}
