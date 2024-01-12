package com.example.online_shopping.products;

import com.example.online_shopping.cart.CartMapper;
import com.example.online_shopping.payment.PaymentMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class ProductMapper {
    @Autowired
    protected CartMapper cartMapper;
    @Autowired
    protected PaymentMapper paymentMapper;

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "payments")
    @Mapping(ignore = true, target = "carts")
    public abstract Product toEntity(ProductDto dto);


    @Mapping(ignore = true, target = "carts")
    @Mapping(ignore = true, target = "payments")
    public abstract ProductDto toDto(Product product);


    @Mapping(target = "carts", expression = "java(product.getCarts().stream().map(this.cartMapper::toDto).toList())")
    @Mapping(target = "payments", expression = "java(product.getPayments().stream().map(this.paymentMapper::toDto).toList())")
    public abstract ProductDto toDtoWithCartAndPayment(Product product);


    @Mapping(ignore = true, target = "carts")
    @Mapping(ignore = true, target = "payments")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Product product, ProductDto dto);


    public void view(Product product, ProductDto dto) {
        dto.setCarts(product.getCarts().stream().map(this.cartMapper::toDto).toList());
        dto.setPayments(product.getPayments().stream().map(this.paymentMapper::toDto).toList());
    }
}
