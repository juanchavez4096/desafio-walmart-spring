package com.spring.walmart.desafio.service;

import com.spring.walmart.desafio.data.document.Product;
import com.spring.walmart.desafio.data.repository.ProductRepository;
import com.spring.walmart.desafio.service.impl.ProductServiceImpl;
import com.spring.walmart.desafio.utils.PalindromeUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    Product headphones = new Product("1562153",1L, "walmart", "Headphones", "www.lider.com/image.svg", 2500d);

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Mock
    private PalindromeUtils palindromeUtils;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProductsPalindrome(){

        String searchString = "abba";
        String searchId = "252";

        Page<Product> product = new PageImpl<>(Collections.singletonList(headphones));
        Mockito.when(productRepository.findByBrandIgnoreCaseContainsOrDescriptionIgnoreCaseContains(Mockito.anyString(), Mockito.anyString(), Mockito.any()))
                .thenReturn(product);
        Mockito.when(productRepository.findById(Mockito.anyLong(), Mockito.any()))
                .thenReturn(product);
        Mockito.when(palindromeUtils.palindromeValidation(Mockito.anyString()))
                .thenReturn(Boolean.TRUE);

        Assertions.assertNotNull(productServiceImpl.getPageOfProducts(searchString, PageRequest.of(0,24)));
        Assertions.assertNotNull(productServiceImpl.getPageOfProducts(searchId, PageRequest.of(0,24)));
    }

    @Test
    public void getProductsNotPalindrome(){

        String searchString = "abbaa";
        String searchStringShort = "ab";
        String searchId = "25";

        Page<Product> product = new PageImpl<>(Collections.singletonList(headphones));
        Mockito.when(productRepository.findByBrandIgnoreCaseContainsOrDescriptionIgnoreCaseContains(Mockito.anyString(), Mockito.anyString(), Mockito.any()))
                .thenReturn(product);
        Mockito.when(productRepository.findById(Mockito.anyLong(), Mockito.any()))
                .thenReturn(product);
        Mockito.when(palindromeUtils.palindromeValidation(Mockito.anyString()))
                .thenReturn(Boolean.FALSE);

        Assertions.assertNotNull(productServiceImpl.getPageOfProducts(searchString, PageRequest.of(1,24)));
        Assertions.assertNotNull(productServiceImpl.getPageOfProducts(searchId, PageRequest.of(1,24)));
        Assertions.assertNotNull(productServiceImpl.getPageOfProducts(searchStringShort, PageRequest.of(1,24)));
    }


}
