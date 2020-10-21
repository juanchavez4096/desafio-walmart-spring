package com.spring.walmart.desafio.service;

import com.spring.walmart.desafio.data.document.Product;
import com.spring.walmart.desafio.data.repository.ProductRepository;
import com.spring.walmart.desafio.service.impl.ProductServiceImpl;
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

    Product headphones = new Product(1L, "walmart", "Headphones", "www.lider.com/image.svg", 2500d);

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProducts(){
        Page<Product> product = new PageImpl<>(Collections.singletonList(headphones));
        Mockito.when(productRepository.findByIdOrBrandOrDescription(Mockito.anyLong(), Mockito.anyString(), Mockito.anyString(), Mockito.any()))
                .thenReturn(product);

        Assertions.assertNotNull(productServiceImpl.getPageOfProducts("walmart", PageRequest.of(1,24)));
    }


}
