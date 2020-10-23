package com.spring.walmart.desafio.service.mapper;

import com.spring.walmart.desafio.data.document.Product;
import com.spring.walmart.desafio.service.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "priceDiscount", source = "priceDiscount")
    @Mapping(target = "discount", source = "discount")
    @Mapping(target = "price", source = "product.price")
    @Mapping(target = "image", source = "product.image")
    @Mapping(target = "description", source = "product.description")
    @Mapping(target = "brand", source = "product.brand")
    @Mapping(target = "id", source = "product.id")
    ProductDto productToProductDto(Product product, Long discount, Double priceDiscount);

}
