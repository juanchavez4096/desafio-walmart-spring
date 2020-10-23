package com.spring.walmart.desafio.web;

import com.spring.walmart.desafio.service.ProductService;
import com.spring.walmart.desafio.service.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api")
@Log4j2
@Validated
public class ProductController {

    @Autowired
    ProductService productService;

    @Value("${page.size}")
    Integer size;

    @GetMapping("v1/products/findPage")
    public ResponseEntity<Page<ProductDto>> findByOrderNumber(@RequestParam @NotNull String search,
                                                              @RequestParam(defaultValue = "0") Integer page) {

        log.info("Getting " + search + " in page " + page);
        Page<ProductDto> productDtos = productService.getPageOfProducts(search, PageRequest.of(page >= 0 ? page : 0, size));
        log.info("Products obtained with search: " + productDtos.getTotalElements());

        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }


}