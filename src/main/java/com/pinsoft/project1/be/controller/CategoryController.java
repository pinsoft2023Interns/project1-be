package com.pinsoft.project1.be.controller;

import com.pinsoft.project1.be.entity.Category;
import com.pinsoft.project1.be.entity.Role;
import com.pinsoft.project1.be.servis.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/category")
    public Collection<Category> get(){return categoryService.getAll();}
    @GetMapping("/category/{id}")
    public Category get(@PathVariable Long id){
        Optional<Category> optional = categoryService.getById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/category/{id}")
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
    @PostMapping("/category")
    public Category add(@RequestBody Category category){
        return categoryService.add(category);
    }

}
