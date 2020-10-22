package com.spring.walmart.desafio.dto;

import com.spring.walmart.desafio.data.document.Product;
import com.spring.walmart.desafio.service.dto.ProductDto;
import com.spring.walmart.desafio.utils.PojoTestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DtoTest {

    @InjectMocks
    private Product product;

    @InjectMocks
    private ProductDto productDto;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validateDto() {

        PojoTestUtils.validateAccessors(Product.class);
        PojoTestUtils.validateAccessors(ProductDto.class);

        Assert.assertNotNull(product.toString());
        Assert.assertNotNull(productDto.toString());

    }
}