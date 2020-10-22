package com.spring.walmart.desafio.utils;

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
public class PalindromeUtilsTest {

    Product headphones = new Product("1523153",1L, "walmart", "Headphones", "www.lider.com/image.svg", 2500d);

    @InjectMocks
    private PalindromeUtils palindromeUtils;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPalindromeApplication(){
        Assertions.assertNotNull(palindromeUtils.palindromeApplication(headphones, Boolean.TRUE));
        Assertions.assertNotNull(palindromeUtils.palindromeApplication(headphones, Boolean.FALSE));
    }

    @Test
    public void testPalindromeValidation(){
        Assertions.assertTrue(palindromeUtils.palindromeValidation("abba"));
        Assertions.assertFalse(palindromeUtils.palindromeValidation("abbaa"));
    }


}
