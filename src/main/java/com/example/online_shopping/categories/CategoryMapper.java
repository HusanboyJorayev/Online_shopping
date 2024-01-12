package com.example.online_shopping.categories;

import com.example.online_shopping.cart.Cart;
import com.example.online_shopping.cart.CartDto;
import com.example.online_shopping.products.ProductMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class CategoryMapper {
    @Autowired
    protected ProductMapper productMapper;

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "products")
    public abstract Category toEntity(CategoryDto dto);

    @Mapping(ignore = true, target = "products")
    public abstract CategoryDto toDto(Category category);


    @Mapping(target = "products", expression = "java(category.getProducts().stream().map(this.productMapper::toDto).toList())")
    public abstract CategoryDto toDtoWithProduct(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Category category, CategoryDto dto);

    public void view(Category category, CategoryDto dto) {
        dto.setProducts(category.getProducts().stream().map(this.productMapper::toDto).toList());
    }
}
