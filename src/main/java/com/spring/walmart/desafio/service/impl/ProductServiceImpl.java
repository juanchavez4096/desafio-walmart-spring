package com.spring.walmart.desafio.service.impl;

import com.spring.walmart.desafio.data.repository.ProductRepository;
import com.spring.walmart.desafio.service.ProductService;
import com.spring.walmart.desafio.service.dto.ProductDto;
import com.spring.walmart.desafio.utils.PalindromeUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PalindromeUtils palindromeUtils;

    @Override
    public Page<ProductDto> getPageOfProducts(String search, Pageable pageable) {


        Boolean isPalindrome = palindromeUtils.palindromeValidation(search.trim().toLowerCase().replace(" ", ""));
        if (NumberUtils.isParsable(search)){
            log.info("Is number: " + search);
            return productRepository.findById(Long.parseLong(search), pageable).map( p -> palindromeUtils.palindromeApplication(p, isPalindrome));
        }
        return search.length() > 3 ?
                productRepository.findByBrandIgnoreCaseContainsOrDescriptionIgnoreCaseContains(search, search, pageable).map( p ->
                        palindromeUtils.palindromeApplication(p, isPalindrome)
                ) :
                new PageImpl<>(Collections.emptyList());
    }
}
