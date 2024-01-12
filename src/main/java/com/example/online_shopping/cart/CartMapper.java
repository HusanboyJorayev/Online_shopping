package com.example.online_shopping.cart;

import com.example.online_shopping.order.OrderMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class CartMapper {

    @Autowired
    protected OrderMapper orderMapper;

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "orders")
    public abstract Cart toEntity(CartDto dto);

    @Mapping(ignore = true, target = "orders")
    public abstract CartDto toDto(Cart cart);


    @Mapping(target = "orders", expression = "java(cart.getOrders().stream().map(this.orderMapper::toDto).toList())")
    public abstract CartDto toDtoWithOrder(Cart cart);

    @Mapping(ignore = true, target = "orders")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Cart cart, CartDto dto);

    public void view(Cart cart, CartDto dto) {
        dto.setOrders(cart.getOrders().stream().map(this.orderMapper::toDto).toList());
    }
}
