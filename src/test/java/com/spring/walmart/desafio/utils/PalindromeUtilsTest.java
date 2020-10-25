package com.spring.walmart.desafio.utils;

import com.spring.walmart.desafio.data.document.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PalindromeUtilsTest {

    Product headphones = new Product("1523153", 1L, "walmart", "Headphones", "www.lider.com/image.svg", 2500d);

    @InjectMocks
    private PalindromeUtils palindromeUtils;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPalindromeApplication() {
        Assertions.assertNotNull(palindromeUtils.palindromeApplication(headphones, Boolean.TRUE));
        Assertions.assertNotNull(palindromeUtils.palindromeApplication(headphones, Boolean.FALSE));
    }

    @Test
    public void testPalindromeValidation() {
        Assertions.assertTrue(palindromeUtils.palindromeValidation("abba"));
        Assertions.assertFalse(palindromeUtils.palindromeValidation("abbaa"));
    }


}
