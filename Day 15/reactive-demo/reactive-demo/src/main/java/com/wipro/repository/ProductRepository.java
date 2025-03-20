package com.wipro.repository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.wipro.entity.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
