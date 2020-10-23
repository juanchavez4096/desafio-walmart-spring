package com.spring.walmart.desafio.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {
    private Long id;
    private String brand;
    private String description;
    private String image;
    private Double price;
    private Long discount;
    private Double priceDiscount;
}
