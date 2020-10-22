package com.spring.walmart.desafio.service;

import com.spring.walmart.desafio.service.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Page<ProductDto> getPageOfProducts(String search, Pageable pageable);
}
