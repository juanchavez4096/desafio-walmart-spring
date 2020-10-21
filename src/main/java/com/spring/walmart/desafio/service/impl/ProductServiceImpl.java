package com.spring.walmart.desafio.service.impl;

import com.spring.walmart.desafio.data.document.Product;
import com.spring.walmart.desafio.data.repository.ProductRepository;
import com.spring.walmart.desafio.service.ProductService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getPageOfProducts(String search, Pageable pageable) {
        return productRepository.findByIdOrBrandOrDescription(NumberUtils.isParsable(search) ? Long.parseLong(search) : 0L, search, search, pageable);
    }
}
