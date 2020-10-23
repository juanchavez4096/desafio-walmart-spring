package com.spring.walmart.desafio.utils;

import com.spring.walmart.desafio.data.document.Product;
import com.spring.walmart.desafio.service.dto.ProductDto;
import com.spring.walmart.desafio.service.mapper.ProductMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class PalindromeUtils {

    public ProductDto palindromeApplication(Product product, boolean isPalindrome){
        return ProductMapper.INSTANCE.productToProductDto(product, isPalindrome ? 50L : 0L, isPalindrome ? product.getPrice()/2 : product.getPrice());
    }

    public Boolean palindromeValidation(String search){
        return StringUtils.reverse(search).equals(search);
    }
}
