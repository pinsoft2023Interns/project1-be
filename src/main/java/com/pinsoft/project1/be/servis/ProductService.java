package com.pinsoft.project1.be.servis;

import com.pinsoft.project1.be.dto.CreateProductRequest;
import com.pinsoft.project1.be.dto.UpdateProductRequest;
import com.pinsoft.project1.be.entity.Category;
import com.pinsoft.project1.be.entity.Product;
import com.pinsoft.project1.be.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryService categoryService;

    public Product add(CreateProductRequest productRequest) throws IOException{
        Product product = new Product();
        product.setExplanation(productRequest.getExplanation());
        product.setPrice(productRequest.getPrice());
        product.setName(productRequest.getName());
        product.setBase64image(productRequest.getBase64Image());
        Category category = categoryService.getById(productRequest.getCategoryId()).get();
        product.setCategory(category);
        return productRepository.save(product);
    }
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
    public List<Product> getAll(){
        return productRepository.findAll();
    }
    public Optional<Product> getById(Long id){
        return productRepository.findById(id);
    }

    public void update(UpdateProductRequest productRequest) {
        Optional<Product> productOptional=productRepository.findById(productRequest.getId());
        if(productOptional.isPresent()){
            Product product = new Product();
            product.setId(productRequest.getId());
            product.setName(productRequest.getName());
            product.setPrice(productRequest.getPrice());
            product.setExplanation(productRequest.getExplanation());
            product.setBase64image(productRequest.getBase64Image());
            Category category = categoryService.getById(productRequest.getCategoryId()).get();
            product.setCategory(category);
            productRepository.save(product);
        }
    }
}
