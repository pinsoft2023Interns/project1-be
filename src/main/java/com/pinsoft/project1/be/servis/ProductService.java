package com.pinsoft.project1.be.servis;

import com.pinsoft.project1.be.entity.Product;
import com.pinsoft.project1.be.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public Product add(Product product) throws IOException {
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


}
