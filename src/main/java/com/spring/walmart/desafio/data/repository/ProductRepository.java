package com.spring.walmart.desafio.data.repository;

import com.spring.walmart.desafio.data.document.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    Page<Product> findBy(Pageable pageable);

    Page<Product> findByBrandIgnoreCaseContainsOrDescriptionIgnoreCaseContains(String brand, String description, Pageable pageable);

    Page<Product> findById(Long id, Pageable pageable);
}
