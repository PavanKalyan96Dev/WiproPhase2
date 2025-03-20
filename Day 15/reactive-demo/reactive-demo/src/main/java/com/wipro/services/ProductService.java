package com.wipro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.entity.Product;
import com.wipro.repository.ProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Mono<Product> saveProduct(Product product) {
        return productRepository.save(product); 
    }

    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Mono<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Mono<Void> deleteProduct(String id) {
        return productRepository.deleteById(id);
    }
}
