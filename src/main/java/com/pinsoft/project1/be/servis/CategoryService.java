package com.pinsoft.project1.be.servis;

import com.pinsoft.project1.be.entity.Category;
import com.pinsoft.project1.be.entity.Role;
import com.pinsoft.project1.be.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public Category add(Category category) {return categoryRepository.save(category);}
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
    public Optional<Category> getById(Long id){
        return categoryRepository.findById(id);
    }
}
