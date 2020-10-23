package com.spring.walmart.desafio.e2e;

import com.spring.walmart.desafio.data.document.Product;
import com.spring.walmart.desafio.service.dto.ProductDto;
import com.spring.walmart.desafio.service.impl.ProductServiceImpl;
import com.spring.walmart.desafio.web.ProductController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@TestPropertySource(properties="page.size=24")
public class ProductControllerTest {

    ProductDto headphones = new ProductDto(1L, "walmart", "Headphones", "www.lider.com/image.svg", 2500d, 50L, 1250d);

    @MockBean
    ProductServiceImpl productService;
    @Autowired
    private MockMvc mvc;

    @Test
    public void numericSearch() throws Exception {

        BDDMockito.given(productService.getPageOfProducts(BDDMockito.anyString(), BDDMockito.any())).willReturn(new PageImpl<>(Collections.singletonList(headphones)));

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/products/findPage?search=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id").value("1"));

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/products/findPage?search=-1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id").value("1"));

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/products/findPage")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }
}
