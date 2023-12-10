package com.pinsoft.project1.be.servis;

import com.pinsoft.project1.be.entity.Category;
import com.pinsoft.project1.be.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository kategoriRepository;
}
