package com.pinsoft.project1.be.controller;

import com.pinsoft.project1.be.dto.AuthenticationRequest;
import com.pinsoft.project1.be.dto.AuthenticationResponse;
import com.pinsoft.project1.be.dto.RegisterRequest;
import com.pinsoft.project1.be.entity.User;
import com.pinsoft.project1.be.servis.AuthenticationService;
import com.pinsoft.project1.be.servis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private AuthenticationService authService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authService.authenticate(request));
    }
    @GetMapping("/user_account")
    public Collection<User> get(){
        return userService.getAll();
    }
    @GetMapping("/user_account/{id}")
    public User get(@PathVariable Long id){
        Optional<User> optional = userService.getById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/user_account/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
    @PostMapping("/user_account")
    public User add(@RequestBody User user){
        return userService.add(user);
     }
}
