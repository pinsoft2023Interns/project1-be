package com.pinsoft.project1.be.controller;

import com.pinsoft.project1.be.entity.Category;
import com.pinsoft.project1.be.servis.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService kategoriServis;

    public List<Category> list(){
        return kategoriServis.list();
    }


}
